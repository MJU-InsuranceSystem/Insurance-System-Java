package org.example.user;

public abstract class User {

    public enum Role {
        customer, worker
    }

    String name;
    String age;
    String sex;
    String phoneNumber;
    String id;
    String password;
    Role role;

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

    public Role getRole() {
        return role;
    }
}
