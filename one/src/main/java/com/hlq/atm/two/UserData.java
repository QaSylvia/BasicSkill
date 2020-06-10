package com.hlq.atm.two;

public class UserData {
    private String username;
    private String password;
    private String phone;
    private double balance;
    private boolean isAdmin;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean IsAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public UserData() { }

    public UserData(String username, String password, String phone) {
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.balance = 5000;
        this.isAdmin = false;
    }

    public UserData(String username, String password, String phone, double balance, boolean isAdmin) {
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.balance = balance;
        this.isAdmin = isAdmin;
    }
}
