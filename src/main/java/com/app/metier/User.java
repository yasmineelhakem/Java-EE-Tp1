package com.app.metier;

public class User {
    private String username;
    private String password;

    public User() {
        this.username = username;
        this.password = password;
    }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public static boolean authenticate(String username, String password) {
        return "admin".equals(username) && "123".equals(password);
    }
}

