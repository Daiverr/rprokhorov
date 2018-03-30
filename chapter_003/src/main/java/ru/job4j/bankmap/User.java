package ru.job4j.bankmap;

import java.util.HashMap;

public class User {
    private String name;
    private String passport;

    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (this == obj) {
            result = true;
        }
        if (obj == null) {
            result = false;
        }
        if (getClass() != obj.getClass()) {
            result = false;
        }
        User other = (User) obj;
        if (!this.name.equals(other.getName())) {
            result = false;
        }
        if (!this.passport.equals(other.getPassport())) {
            result = false;
        }
        return result;

    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + this.name.length();
        result = prime * result + this.passport.length();
        return result;
    }
}