package com.example.example;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashPassword {
    

    private final String SALT_START = "297v5yOA*&Wvn21";
    private final String SALT_END = "|SDF.jc*(Sfe";
    public String getHash (String password) {
        String encryptedPassword = "";
        try {
            String saltedPassword = SALT_START + password + SALT_END;
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(saltedPassword.getBytes(StandardCharsets.UTF_8));
            StringBuilder s = new StringBuilder();  
            for(int i=0; i<  hash.length; i++)  {  
                s.append(Integer.toString((hash[i] & 0xff) + 0x100, 16).substring(1));  
            } 
            encryptedPassword = s.toString(); 
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return encryptedPassword;
    }

    
}
