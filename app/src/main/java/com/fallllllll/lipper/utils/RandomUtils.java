package com.fallllllll.lipper.utils;

import java.util.Random;

/**
 * Created by fallllllll on 2017/3/11.
 * GitHub :  https://github.com/348476129/Lipper
 */

public class RandomUtils {
    public static String getRandomString(int length) { //length表示生成字符串的长度
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
}
