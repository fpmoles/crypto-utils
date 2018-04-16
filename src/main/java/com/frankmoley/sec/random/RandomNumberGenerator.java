package com.frankmoley.sec.random;

import java.security.SecureRandom;

/**
 * @author Frank P. Moley III.
 */
public class RandomNumberGenerator {

    private static final SecureRandom secureRandom = new SecureRandom();


    public static int generateRandomInteger(){
        return secureRandom.nextInt();
    }

    public static double generateRandomDouble(){
        return secureRandom.nextDouble();
    }

    public static long generateRandomLong(){
        return secureRandom.nextLong();
    }

    public static byte[] generateRandomByteArray(int numberOfBytes){
        byte[] bytes = new byte[numberOfBytes];
        secureRandom.nextBytes(bytes);
        return bytes;
    }

}
