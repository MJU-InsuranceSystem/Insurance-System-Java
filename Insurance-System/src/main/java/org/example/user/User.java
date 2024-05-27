package org.example.user;

public abstract class User {

    String name;
    String age;
    String sex;
    String phoneNumber;
    String id;
    String password;
    boolean loginStatus;
    UserType userType;

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public String getId() {
        return id;
    }

    public UserType getUserType() {
        return userType;
    }

    public void login() {
        loginStatus = true;
    }

    public void logout() {
        loginStatus = false;
    }

    public boolean isLogin() {
        return loginStatus;
    }
}
