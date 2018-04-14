package com.frankmoley.sec.random;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Frank P. Moley III.
 */
class RandomNumberGeneratorTest {

    private static final int TEST_COUNT = 1000;

    @Test
    void generateRandomInteger() {
        Set<Integer> integerSet = new HashSet<>();
        for(int i = 0; i< TEST_COUNT; i++){
            integerSet.add(RandomNumberGenerator.generateRandomInteger());
        }
        assertEquals(TEST_COUNT, integerSet.size());
    }

    @Test
    void generateRandomDouble() {
        Set<Double> doubleSet = new HashSet<>();
        for(int i = 0; i< TEST_COUNT; i++){
            doubleSet.add(RandomNumberGenerator.generateRandomDouble());
        }
        assertEquals(TEST_COUNT, doubleSet.size());
    }

    @Test
    void generateRandomLong() {
        Set<Long> longSet = new HashSet<>();
        for(int i = 0; i< TEST_COUNT; i++){
            longSet.add(RandomNumberGenerator.generateRandomLong());
        }
        assertEquals(TEST_COUNT, longSet.size());
    }
}