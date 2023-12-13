package com.example.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class PasswordHasher { 

    public static String hashPassword(String emailId, String password) {
        try {
            // Combine the fixed salt and the password
            String saltedPassword = emailId + password;

            // Create a MessageDigest instance for SHA-256
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            // Hash the salted password
            byte[] hashedPassword = md.digest(saltedPassword.getBytes());

            // Encode the hashed password as Base64
            return Base64.getEncoder().encodeToString(hashedPassword);
        } catch (NoSuchAlgorithmException e) {
            // Handle the exception
            e.printStackTrace();
            return null;
        }
    }
}
