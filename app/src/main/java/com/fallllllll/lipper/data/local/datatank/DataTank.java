package com.fallllllll.lipper.data.local.datatank;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;


/**
 * Created by fallllllll on 2017/5/8.
 * GitHub :  https://github.com/348476129/Lipper
 */

public class DataTank {
    private static JsonAdapter jsonAdapter;
    private static File cacheDir;
    private static boolean isInit = false;
    private static DiskCache diskCache;

    public static synchronized void init(final String filePath, final long maxSize, final JsonAdapter adapter) throws IOException {
        cacheDir = new File(filePath + "/dataTank");
        initCache(cacheDir, maxSize);
        jsonAdapter = adapter;
        isInit = true;
    }

    private static synchronized void initCache(final File cacheDir, final long maxSize) throws
            IOException {
        boolean success = true;
        if (!cacheDir.exists()) {
            success = cacheDir.mkdir();
        }
        if (!success) {
            throw new IOException("Failed to create cache directory!");
        }
        diskCache = DiskCache.openCache(cacheDir, maxSize);
    }

    private static void checkIsInitialised() {
        if (!isInit) {
            throw new IllegalStateException("Init hasn't been called! You need to initialise " +
                    "Reservoir before you call any other methods.");
        }
    }

    public static boolean containsSynchronization(final String key) throws IOException {
        checkIsInitialised();
        return diskCache.contains(key);
    }

    public static Flowable<Boolean> contains(final String key) {
        return Flowable.create(e -> {
            e.onNext(containsSynchronization(key));
            e.onComplete();
        }, BackpressureStrategy.BUFFER);
    }


    public static void putSynchronization(final String key, final Object object) throws IOException {
        checkIsInitialised();
        String json = jsonAdapter.toJson(object);
        diskCache.put(key, json);
    }

    public static Flowable<Boolean> put(final String key, final Object object) {
        return Flowable.create(e -> {
            putSynchronization(key, object);
            e.onNext(true);
            e.onComplete();
        }, BackpressureStrategy.BUFFER);

    }

    public static <T> T getSynchronization(final String key, final Class<T> classOfT) throws IOException {
        checkIsInitialised();
        String json = diskCache.getString(key).getString();
        T value = jsonAdapter.fromJson(json, classOfT);
        if (value == null)
            throw new NullPointerException();
        return value;
    }

    public static <T> Flowable<T> get(final String key, final Class<T> tClass) {
        return Flowable.create(e -> {

                T value = getSynchronization(key, tClass);
                e.onNext(value);
                e.onComplete();

        }, BackpressureStrategy.BUFFER);
    }

    public static <T> T getSynchronization(final String key, final Type typeOfT) throws IOException {
        checkIsInitialised();
        String json = diskCache.getString(key).getString();
        T value = jsonAdapter.fromJson(json, typeOfT);
        if (value == null)
            throw new NullPointerException();
        return value;
    }

    public static <T> Flowable<T> get(final String key, final Class<T> classOfT, final Type typeOfT) {
        return Flowable.create(e -> {

            Collection<T> collectionOfT = getSynchronization(key, typeOfT);
            for (T t : collectionOfT) {
                e.onNext(t);
            }
        }, BackpressureStrategy.BUFFER);
    }

    public static void deleteSynchronization(final String key) throws IOException {
        checkIsInitialised();
        diskCache.delete(key);
    }

    public static Flowable<Boolean> delete(final String key) {
        return Flowable.create(e -> {
            deleteSynchronization(key);
            e.onNext(true);
            e.onComplete();
        }, BackpressureStrategy.BUFFER);

    }

    public static void clearSynchronization() throws IOException {
        checkIsInitialised();
        ;
        long maxSize = diskCache.getMaxSize();
        diskCache.destroy();
        initCache(cacheDir, maxSize);
    }

    public static Flowable<Boolean> clear() {
        return Flowable.create(e -> {
            clearSynchronization();
            e.onNext(true);
            e.onComplete();
        }, BackpressureStrategy.BUFFER);
    }
}