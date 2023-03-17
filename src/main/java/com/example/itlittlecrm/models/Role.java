package com.example.itlittlecrm.models;
import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER, ADMIN, SHOPER, PRODUCT, HR;

    @Override
    public String getAuthority() {
        return name();
    }


}
