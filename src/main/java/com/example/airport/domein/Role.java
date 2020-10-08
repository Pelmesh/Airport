package com.example.airport.domein;

import org.springframework.security.core.GrantedAuthority;

public enum Role  implements GrantedAuthority {
    USER,ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
