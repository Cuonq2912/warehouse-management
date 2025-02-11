package org.example.domain.DTO.Response;

public class LoginResponse {
       private static final String DEFAULT_EMAIL = "ktpm02@gmail.com";
       private static final String DEFAULT_PASSWORD = "admin123";
    private String token;
    private String username;
    private String role;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}