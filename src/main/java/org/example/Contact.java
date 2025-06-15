package org.example;

public class Contact {
    private String name;
    private int phone;
    private String email;
    private String group; // Work, Family, Friends

    public Contact(String name, int phone, String email, String group) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '|' +
                ", phone=" + phone +
                ", email='" + email + '|' +
                ", group='" + group + '|' +
                '}';
    }
}
