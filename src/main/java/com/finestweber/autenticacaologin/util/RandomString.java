package com.finestweber.autenticacaologin.util;

import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.SecureRandom;

// Cria o código aleatório
public class RandomString {
    private static final String CHARACTER = "ABCDEFGHIJKLMNOPQRSTUVXYWZabcdefghijklmnopqrstuvxywz0123456789";

    public static String generateRandomString(int length) {
        SecureRandom secureRandom = new SecureRandom();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = secureRandom.nextInt(CHARACTER.length());
            char randomChar = CHARACTER.charAt(index);
            stringBuilder.append(randomChar);
        }

        return stringBuilder.toString();
    }
}
