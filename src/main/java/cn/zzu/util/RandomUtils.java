package cn.zzu.util;

import java.security.SecureRandom;
import java.util.Random;


public class RandomUtils {
    private static SecureRandom random = new SecureRandom();
    private static final char[] BASE62 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();


    public static Long genId() {
        Long nanoSec = Long.valueOf(System.nanoTime());
        Random random = new Random();
        Long ranLong = Long.valueOf(Math.abs(random.nextLong()));
        Long id = Long.valueOf(((nanoSec.longValue() & 65535L) << 32) + (ranLong.longValue() & 32767L));
        return id;
    }

    public static String randomStr(int length) {
        byte[] randomBytes = new byte[length];
        random.nextBytes(randomBytes);
        return encodeBase62(randomBytes);
    }
    public static String encodeBase62(byte[] input) {
        char[] chars = new char[input.length];

        for(int i = 0; i < input.length; ++i) {
            chars[i] = BASE62[(input[i] & 255) % BASE62.length];
        }

        return new String(chars);
    }

}
