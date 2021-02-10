package com.kodilla.good.patterns.challenges;

public class User {
    private final String username;
    private final String firstName;
    private final String secondName;
    private final String email;
    private final int mobileNumber;

    public User(String username, String firstName, String secondName, String email, int mobileNumber) {
        this.username = username;
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.mobileNumber = mobileNumber;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getEmail() {
        return email;
    }

    public int getMobileNumber() {
        return mobileNumber;
    }
}
