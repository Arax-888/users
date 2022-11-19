package com.mkrtumyan.users.persistence;

import java.util.Objects;

public class UserResponse {
    private String name;

    private String surename;

    private String email;

    public UserResponse() {
    }

    public UserResponse(String name, String surename, String email) {
        this.name = name;
        this.surename = surename;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurename() {
        return surename;
    }

    public void setSurename(String surename) {
        this.surename = surename;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserResponse that = (UserResponse) o;
        return Objects.equals(name, that.name) && Objects.equals(surename, that.surename) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surename, email);
    }
}
