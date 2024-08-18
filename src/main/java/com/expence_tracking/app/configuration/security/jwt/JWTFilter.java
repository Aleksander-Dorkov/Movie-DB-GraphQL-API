package com.expence_tracking.app.configuration.security.jwt;

import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JWTFilter extends OncePerRequestFilter {

    private final TokenProvider tokenProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String jwt = resolveToken(request); //get the jwt value from the "Bearer " header

            if (StringUtils.hasText(jwt) && this.tokenProvider.validateToken(jwt)) //check if (jwt) is null and parse token see if it was tempered with
            {
                Authentication authentication = this.tokenProvider.getAuthentication(jwt); //create Authentication object and add it in security context
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }

            //IF there is not token, just filter
            filterChain.doFilter(request, response);
        } catch (ExpiredJwtException eje) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }

    //get the jwt value from the "Bearer " header
    private String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }
}


