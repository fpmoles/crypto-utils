package com.frankmoley.sec.encryption;

import java.security.KeyPair;
import java.security.Security;

/**
 * @author Frank P. Moley III.
 */
public class RSAEncryptionUtils {

    static{
        Security.setProperty("crypto.policy", "unlimited");
    }


}
