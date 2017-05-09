package com.fallllllll.lipper.data.local.datatank;


import com.jakewharton.disklrucache.DiskLruCache;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by 康颢曦 on 2017/5/8.
 * 参考了https://github.com/anupcowkur/Reservoir/blob/master/Library/src/main/java/com/anupcowkur/reservoir/SimpleDiskCache.java 的写法。
 */

public class DiskCache {

    static final String OBJECT_SIZE_GREATER_THAN_CACHE_SIZE_MESSAGE = "Object size greater than " +
            "cache size!";
    private static final int VALUE_IDX = 0;
    private static final int METADATA_IDX = 1;

    private final DiskLruCache diskLruCache;

    private DiskCache(File dir, int appVersion, long maxSize) throws IOException {
        diskLruCache = DiskLruCache.open(dir, appVersion, 2, maxSize);
    }

    static synchronized DiskCache openCache(File dir, long maxSize) throws IOException {
        return new DiskCache(dir, 1, maxSize);
    }

    StringEntry getString(String key) throws IOException {
        DiskLruCache.Snapshot snapshot = diskLruCache.get(getNormalKey(key));
        if (snapshot == null) {
            return null;
        }
        try {
            return new StringEntry(snapshot.getString(VALUE_IDX));
        } finally {
            snapshot.close();
        }
    }

    long getMaxSize() throws IOException {
        return diskLruCache.getMaxSize();
    }


    boolean contains(String key) throws IOException {
        DiskLruCache.Snapshot snapshot = diskLruCache.get(getNormalKey(key));
        if (snapshot == null) {
            return false;
        }

        snapshot.close();
        return true;
    }

    private OutputStream openStream(String key, Map<String, ? extends Serializable> metadata) throws
            IOException {
        DiskLruCache.Editor editor = diskLruCache.edit(getNormalKey(key));
        try {
            writeMetadata(metadata, editor);
            BufferedOutputStream bos = new BufferedOutputStream(editor.newOutputStream(VALUE_IDX));
            return new CacheOutputStream(bos, editor);
        } catch (IOException e) {
            editor.abort();
            throw e;
        }
    }
    void put(String key, String value) throws IOException {
        if (value.getBytes().length > getMaxSize()) {
            throw new IOException(OBJECT_SIZE_GREATER_THAN_CACHE_SIZE_MESSAGE);
        }
        put(key, value, new HashMap<>());
    }
    void delete(String key) throws IOException {
        diskLruCache.remove(getNormalKey(key));
    }

    public void destroy() throws IOException {
        diskLruCache.delete();
    }

    long bytesUsed() throws IOException {
        return diskLruCache.size();
    }

    private void put(String key, String value, Map<String, ? extends Serializable> annotations)
            throws
            IOException {
        OutputStream cos = null;
        try {
            cos = openStream(key, annotations);
            cos.write(value.getBytes());
        } finally {
            if (cos != null) {
                cos.close();
            }
        }

    }


    private void writeMetadata(Map<String, ? extends Serializable> metadata,
                               DiskLruCache.Editor editor) throws IOException {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new BufferedOutputStream(editor.newOutputStream
                    (METADATA_IDX)));
            oos.writeObject(metadata);
        } finally {
            closeQuietly(oos);
        }
    }

    private void closeQuietly(OutputStream output) {
        try {
            if (output != null) {
                output.close();
            }
        } catch (IOException ioe) {
            // ignore
        }
    }

    private String getNormalKey(String key) {
        return md5(key);
    }


    private String md5(String s) {
        try {
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(s.getBytes("UTF-8"));
            byte[] digest = m.digest();
            BigInteger bigInt = new BigInteger(1, digest);
            return bigInt.toString(16);
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError();
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError();
        }
    }

    static class StringEntry {
        private final String string;

        StringEntry(String string) {
            this.string = string;
        }

        String getString() {
            return string;
        }
    }

}
