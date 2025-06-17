package org.example.service;

public interface EmailService {
    boolean sendOTP(String email, String otp);

    String generateOTP();
}
