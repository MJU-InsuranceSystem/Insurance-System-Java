package org.example.user;

public abstract class User {

    public String name;
    public String age;
    public String sex;
    public String phoneNumber;
    public String id;
    public String password;
    protected boolean loginStatus;
    public UserType userType;

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
