package com.sort;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import com.encode.Hashids;
import com.util.NumericConvertUtil;
import org.junit.Test;
import junit.framework.Assert;
import org.springframework.util.NumberUtils;

public class HashidsTest {
    @Test
    public void testLongUrlToShortUrl() {
        System.out.println(Long.MAX_VALUE);
        String sourceStr = "https://github.com/ivanakimov/hashids.js";
        StringBuffer buf = new StringBuffer("");

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(sourceStr.getBytes());
            byte[] b = md.digest();

            for (int offset = 0; offset < b.length; ++offset) {
                int i = b[offset];
                if (i < 0) {
                    i += 256;
                }

                if (i < 16) {
                    buf.append("0");
                }

                buf.append(Integer.toOctalString(i));
            }
        } catch (NoSuchAlgorithmException var6) {
            var6.printStackTrace();
        }

        String  urlMd5 = buf.toString();
        System.out.println(urlMd5);
        long[] arr = new long[]{NumericConvertUtil.toDecimal(urlMd5.substring(0, 10), NumericConvertUtil.BaseType.BASE_16), NumericConvertUtil.toDecimal(urlMd5.substring(10, 20), NumericConvertUtil.BaseType.BASE_16), NumericConvertUtil.toDecimal(urlMd5.substring(20), NumericConvertUtil.BaseType.BASE_16)};
        Arrays.asList(arr).forEach(a ->System.out.println(a.toString()));
    }

    @Test
    public void test_large_nummber() {
        long num_to_hash = 9007199254740992L;
        Hashids a = new Hashids("this is my salt");
        String res = a.encode(num_to_hash);
        long[] b = a.decode(res);
        Assert.assertEquals(num_to_hash, b[0]);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_large_nummber_not_supported() throws Exception {
        long num_to_hash = 9007199254740993L;
        Hashids a = new Hashids("this is my salt");
        a.encode(num_to_hash);
    }

    @Test
    public void test_wrong_decoding() {
        Hashids a = new Hashids("this is my pepper");
        long[] b = a.decode("NkK9");
        Assert.assertEquals(b.length, 0);
    }

    @Test
    public void test_one_number() {
        String expected = "NkK9", res;
        long num_to_hash = 12345L;
        long[] res2;
        Hashids a = new Hashids("this is my salt");
        res = a.encode(num_to_hash);
        Assert.assertEquals(res, expected);
        res2 = a.decode(expected);
        Assert.assertEquals(res2.length, 1);
        Assert.assertEquals(res2[0], num_to_hash);
    }

    @Test
    public void test_serveral_numbers() {
        String expected = "aBMswoO2UB3Sj", res;
        long[] num_to_hash = {683L, 94108L, 123L, 5L}, res2;
        Hashids a = new Hashids("this is my salt");
        res = a.encode(num_to_hash);
        Assert.assertEquals(res, expected);
        res2 = a.decode(expected);
        Assert.assertEquals(res2.length, num_to_hash.length);
        Assert.assertTrue(Arrays.equals(res2, num_to_hash));
    }

    @Test
    public void test_specifying_custom_hash_length() {
        String expected = "gB0NV05e", res;
        long num_to_hash = 1L;
        long[] res2;
        Hashids a = new Hashids("this is my salt", 8);
        res = a.encode(num_to_hash);
        Assert.assertEquals(res, expected);
        res2 = a.decode(expected);
        Assert.assertEquals(res2.length, 1);
        Assert.assertEquals(res2[0], num_to_hash);
    }

    @Test
    public void test_randomness() {
        String expected = "1Wc8cwcE", res;
        long[] num_to_hash = {5L, 5L, 5L, 5L}, res2;
        Hashids a = new Hashids("this is my salt");
        res = a.encode(num_to_hash);
        Assert.assertEquals(res, expected);
        res2 = a.decode(expected);
        Assert.assertEquals(res2.length, num_to_hash.length);
        Assert.assertTrue(Arrays.equals(res2, num_to_hash));
    }

    @Test
    public void test_randomness_for_incrementing_numbers() {
        String expected = "kRHnurhptKcjIDTWC3sx", res;
        long[] num_to_hash = {1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L}, res2;
        Hashids a = new Hashids("this is my salt");
        res = a.encode(num_to_hash);
        Assert.assertEquals(res, expected);
        res2 = a.decode(expected);
        Assert.assertEquals(res2.length, num_to_hash.length);
        Assert.assertTrue(Arrays.equals(res2, num_to_hash));
    }

    @Test
    public void test_randomness_for_incrementing() {
        Hashids a;
        a = new Hashids("this is my salt");
        Assert.assertEquals(a.encode(1L), "NV");
        Assert.assertEquals(a.encode(2L), "6m");
        Assert.assertEquals(a.encode(3L), "yD");
        Assert.assertEquals(a.encode(4L), "2l");
        Assert.assertEquals(a.encode(5L), "rD");
    }

    @Test
    public void test_for_vlues_greater_int_maxval() {
        Hashids a = new Hashids("this is my salt");
        Assert.assertEquals(a.encode(9876543210123L), "Y8r7W1kNN");
    }

    @Test
    public void test_issue10() {
        String expected = "3kK3nNOe", res;
        long num_to_hash = 75527867232l;
        long[] res2;
        Hashids a = new Hashids("this is my salt");
        res = a.encode(num_to_hash);
        Assert.assertEquals(res, expected);
        res2 = a.decode(expected);
        Assert.assertEquals(res2.length, 1);
        Assert.assertEquals(res2[0], num_to_hash);
    }
}
