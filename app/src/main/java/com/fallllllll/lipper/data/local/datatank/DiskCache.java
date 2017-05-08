package com.fallllllll.lipper.data.local.datatank;

import com.jakewharton.disklrucache.DiskLruCache;

import java.io.File;
import java.io.IOException;


/**
 * Created by 康颢曦 on 2017/5/8.
 * 参考了https://github.com/anupcowkur/Reservoir/blob/master/Library/src/main/java/com/anupcowkur/reservoir/SimpleDiskCache.java 的写法。
 */

public class DiskCache {
    private final DiskLruCache diskLruCache;

    private DiskCache(File dir, int appVersion, long maxSize) throws IOException {
        diskLruCache = DiskLruCache.open(dir, appVersion, 1, maxSize);
    }

    static synchronized DiskCache openCache(File dir, long maxSize) throws IOException {
        return new DiskCache(dir, 1, maxSize);
    }





}
