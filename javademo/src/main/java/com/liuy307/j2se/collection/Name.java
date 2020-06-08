package com.liuy307.j2se.collection;

import lombok.EqualsAndHashCode;

//@EqualsAndHashCode(exclude = {"firstName","lastName"})
public class Name {
    private String firstName;
    private String lastName;

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return firstName+lastName;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Name) {
            Name other = (Name)obj;
            return firstName.equals(other.firstName) && lastName.equals(other.lastName);
        }
        return super.equals(obj);
    }

    @Override
    //推荐哈希
//    public int hashCode() {
//        int hash = 17;
//        hash = hash * 31 + firstName.hashCode();
//        hash = hash * 31 + lastName.hashCode();
//        return hash;
//    }
//    简单哈希
    public int hashCode() {
        return firstName.hashCode();
    }
}

