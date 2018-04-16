package com.frankmoley.sec.encryption;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Frank P. Moley III.
 */
class AESEncryptionUtilsTest {

    @Test
    void generateSymmetricKey() {
        String key = AESEncryptionUtils.generateSymmetricKey();
        assertNotNull(key);
    }

    @Test
    void generateInitializationVector() {
        String iv = AESEncryptionUtils.generateInitializationVector();
        assertNotNull(iv);
    }

    @Test
    void encryptData() {
        String testText = "We hold these truths to be self-evident, that all men are created equal, that they are endowed by their Creator with certain unalienable Rights, that among these are Life, Liberty and the pursuit of Happiness.";
        String key = AESEncryptionUtils.generateSymmetricKey();
        String iv = AESEncryptionUtils.generateInitializationVector();
        String cipherText = AESEncryptionUtils.encryptData(testText, key, iv);
        String cipherText2 = AESEncryptionUtils.encryptData(testText, key, iv);
        String cipherText3 = AESEncryptionUtils.encryptData(testText, AESEncryptionUtils.generateSymmetricKey(), AESEncryptionUtils.generateInitializationVector());
        assertEquals(cipherText, cipherText2);
        assertNotEquals(cipherText2, cipherText3);
    }

    @Test
    void decryptData() {
        String testText = "We the people of the United States, in order to form a more perfect union, establish justice, insure domestic tranquility, provide for the common defense, promote the general welfare, and secure the blessings of liberty to ourselves and our posterity, do ordain and establish this Constitution for the United States of America.";
        String key = AESEncryptionUtils.generateSymmetricKey();
        String initializationVector = AESEncryptionUtils.generateInitializationVector();
        String cipherText = AESEncryptionUtils.encryptData(testText, key, initializationVector);
        String plainText = AESEncryptionUtils.decryptData(cipherText, key, initializationVector);
        assertEquals(testText, plainText);
    }

}