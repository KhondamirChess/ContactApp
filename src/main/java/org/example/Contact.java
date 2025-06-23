package org.example;

import java.util.Objects;

public class Contact {
    private final String name;
    private final int phone;
    private final String email;
    private final String group; // Work, Family, Friends

    public Contact(String name, int phone, String email, String group) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Contact other = (Contact) obj;

        return phone == other.phone &&
                Objects.equals(name, other.name) &&
                Objects.equals(email, other.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phone, email, group);
    }
}
