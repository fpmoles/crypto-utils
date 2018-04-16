package com.frankmoley.sec.encryption;

import com.frankmoley.sec.exception.CryptoUtilsSystemException;
import com.frankmoley.sec.random.RandomNumberGenerator;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.sql.DataTruncation;

/**
 * @author Frank P. Moley III.
 */
public class AESEncryptionUtils {

    private static final String ALGORITHM = "AES";
    private static final String ROUTINE = "AES/CBC/PKCS5Padding";

    static{
        Security.setProperty("crypto.policy", "unlimited");
    }


    public static String generateSymmetricKey(){
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM);
            keyGenerator.init(256);
            SecretKey key = keyGenerator.generateKey();
            return DatatypeConverter.printHexBinary(key.getEncoded());
        }catch(NoSuchAlgorithmException ae){
            throw new CryptoUtilsSystemException("Algorithm not found", ae);
        }
    }

    public static String generateInitializationVector(){
        byte[] bytes = RandomNumberGenerator.generateRandomByteArray(16);
        return DatatypeConverter.printHexBinary(bytes);
    }

    public static String encryptData(String data, String hexEncodedKey, String hexEncodedInitializationVector){
        try {
            byte[] key = DatatypeConverter.parseHexBinary(hexEncodedKey);
            byte[] iv = DatatypeConverter.parseHexBinary(hexEncodedInitializationVector);
            SecretKeySpec keySpec = new SecretKeySpec(key, ALGORITHM);
            IvParameterSpec ivSpec = new IvParameterSpec(iv);
            Cipher cipher = Cipher.getInstance(ROUTINE);
            cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
            byte[] cipherText = cipher.doFinal(data.getBytes());
            return DatatypeConverter.printHexBinary(cipherText);
        } catch (Exception e) {
            throw new CryptoUtilsSystemException("Error during encryption", e);
        }
    }

    public static String decryptData(String hexEncodedCipherText, String hexEncodedKey, String hexEncodedInitializationVector){
        try{
            byte[] key = DatatypeConverter.parseHexBinary(hexEncodedKey);
            byte[] iv = DatatypeConverter.parseHexBinary(hexEncodedInitializationVector);
            SecretKeySpec keySpec = new SecretKeySpec(key, ALGORITHM);
            IvParameterSpec ivSpec = new IvParameterSpec(iv);
            Cipher cipher = Cipher.getInstance(ROUTINE);
            cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
            byte[] cipherText = DatatypeConverter.parseHexBinary(hexEncodedCipherText);
            byte[] plainText = cipher.doFinal(cipherText);
            return new String(plainText);
        } catch (Exception e) {
            throw new CryptoUtilsSystemException("Error during decryption", e);
        }
    }
}
