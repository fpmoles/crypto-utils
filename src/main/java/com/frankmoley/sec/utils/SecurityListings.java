package com.frankmoley.sec.utils;

import java.security.Provider;
import java.security.Security;

public class SecurityListings {

    static{
        Security.setProperty("crypto.policy", "unlimited");
    }

    public static void main(String[] args) {
        for (Provider provider : Security.getProviders()) {
            System.out.println("Provider: " + provider.getName());
            for (Provider.Service service : provider.getServices()) {
                System.out.println("  Algorithm: " + service.getAlgorithm());
            }
        }
    }
}