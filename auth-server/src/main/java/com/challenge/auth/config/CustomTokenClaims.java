package com.challenge.auth.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.server.authorization.token.OAuth2TokenCustomizer;
import org.springframework.stereotype.Component;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.server.authorization.token.JwtEncodingContext;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomTokenClaims implements OAuth2TokenCustomizer<JwtEncodingContext> {

    @Override
    public void customize(JwtEncodingContext context) {
        Authentication principal = context.getPrincipal();

        // Agregar roles como claim
        List<String> roles = principal.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        context.getClaims().claim("roles", roles);

        // Agregar claim personalizado 'categorias'
        // Aquí podrías extraer desde una base de datos o definir estáticamente según usuario
        if (principal.getName().equals("admin")) {
            context.getClaims().claim("categorias", List.of("Ficción", "Tecnología", "Historia"));
        } else {
            context.getClaims().claim("categorias", List.of("Ficción"));
        }
    }
}
