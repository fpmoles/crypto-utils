package com.frankmoley.sec.exception;

/**
 * @author Frank P. Moley III.
 */
public class CryptoUtilsSystemException extends RuntimeException {
    public CryptoUtilsSystemException() {
    }

    public CryptoUtilsSystemException(String message) {
        super(message);
    }

    public CryptoUtilsSystemException(String message, Throwable cause) {
        super(message, cause);
    }

    public CryptoUtilsSystemException(Throwable cause) {
        super(cause);
    }
}
