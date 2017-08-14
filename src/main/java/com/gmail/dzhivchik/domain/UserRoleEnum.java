package com.gmail.dzhivchik.domain;

/**
 * Created by User on 14.08.2017.
 */
public enum UserRoleEnum {
    ADMIN,
    USER,
    ANONYMOUS;

    UserRoleEnum() {
    }

    @Override
    public String toString() {
        return "ROLE_" + name();
    }
}
