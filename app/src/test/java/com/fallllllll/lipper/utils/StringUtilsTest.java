package com.fallllllll.lipper.utils;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/5/3/003.
 */
public class StringUtilsTest {
    @Test
    public void numberToK() throws Exception {
        assertEquals("1k",StringUtils.numberToK("1999"));
        assertEquals("999",StringUtils.numberToK("999"));
        assertEquals("1k",StringUtils.numberToK("1000"));
        assertEquals("0",StringUtils.numberToK("0"));
        assertEquals("1d",StringUtils.numberToK("1d"));
    }

}