package com.bahadir;

public class Member {

    String name;
    String phone;

    public Member(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }


    @Override
    public String toString() {
        String result = "Name: " + name + " - Telephone Number: " + phone;
        return result;
    }

// Mark: - Helper

    public String getName() {
        return name;
    }
    public String getPhone() {
        return phone;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
}
