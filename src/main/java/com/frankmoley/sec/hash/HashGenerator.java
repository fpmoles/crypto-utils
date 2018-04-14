package com.frankmoley.sec.hash;

import com.frankmoley.sec.exception.CryptoUtilsSystemException;
import org.mindrot.jbcrypt.BCrypt;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Logger;

/**
 * @author Frank P. Moley III.
 */
public class HashGenerator {

    private static final Logger LOGGER = Logger.getLogger(HashGenerator.class.getName());

    public static String createHash(String input, String salt){
        try {
            String valueToHash = input + salt;
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] hash = messageDigest.digest(valueToHash.getBytes());
            String result = DatatypeConverter.printHexBinary(hash);
            LOGGER.info("Hash is: " + result);
            return result;
        }catch(NoSuchAlgorithmException nsae){
            throw new CryptoUtilsSystemException("Algorithm not available.");
        }
    }

    public static String createPasswordHash(String password){
        String result = BCrypt.hashpw(password, BCrypt.gensalt(11));
        LOGGER.info("BCrypt Hash is: " + result);
        return result;
    }

    public static boolean validatePasswordHash(String password, String hash){
        return BCrypt.checkpw(password, hash);
    }
}