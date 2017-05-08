package com.fallllllll.lipper.data.local.datatank;

import android.content.Context;

import java.io.File;
import java.io.IOException;


/**
 * Created by 康颢曦 on 2017/5/8.
 */

public class DataTank {
    private static JsonAdapter jsonAdapter;
    private static File cacheDir;
    private static boolean isInit = false;
    private static DiskCache diskCache;

    public static synchronized void init(final Context context, final long maxSize, final JsonAdapter adapter) throws IOException {
        cacheDir = new File(context.getCacheDir() + "/dataTank");
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

}
