package com.kft2.selsoftdemo.domain.account.model.type;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ROLE_ADMIN,
    ROLE_CLIENT;

    public String getAuthority() {
        return name();
    }
}
