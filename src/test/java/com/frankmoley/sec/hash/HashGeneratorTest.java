package com.frankmoley.sec.hash;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Frank P. Moley III.
 */
class HashGeneratorTest {

    @Test
    void createHash() {
        String input1 = "FooBarBaz";
        String salt1 = "DogDaysOfSummer";
        String input2 = "LiveFree";
        String salt2 = "FreedomIsNotFree";
        String hash1 = HashGenerator.createHash(input1, salt1);
        String hash2 = HashGenerator.createHash(input2, salt2);
        String hash3 = HashGenerator.createHash(input1, salt1);
        String hash4 = HashGenerator.createHash(input1, salt2);
        assertNotEquals(hash1, hash2);
        assertEquals(hash1, hash3);
        assertNotEquals(hash1, hash4);
    }

    @Test
    void createPasswordHash() {
        String password = "UberSecretPassword*ThatIsActuallySecure1";
        String password2 = "NotSoSecurePassword";
        String hash = HashGenerator.createPasswordHash(password);
        String hash2 = HashGenerator.createPasswordHash(password2);
        String hash3 = HashGenerator.createPasswordHash(password);
        assertNotEquals(hash, hash2);
        assertNotEquals(hash, hash3);
    }

    @Test
    void validatePasswordHash() {
        String password = "UberSecretPassword*ThatIsActuallySecure1";
        String hash = HashGenerator.createPasswordHash(password);
        assertTrue(HashGenerator.validatePasswordHash(password, hash));
    }
}