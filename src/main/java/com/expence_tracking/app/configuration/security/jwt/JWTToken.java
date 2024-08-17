package com.expence_tracking.app.configuration.security.jwt;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class JWTToken {

    private String idToken;

    public JWTToken(String idToken) {
        this.idToken = idToken;
    }
}
