package com.invillia.acme.store.security;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import java.util.List;

public class TokenAuthenticationService {
    static final long EXPIRATION_TIME = 860_000_000;
    static final String SECRET = "RoverTest";
    static final String TOKEN_PREFIX = "Bearer";
    static final String HEADER_STRING = "Authorization";


    static Authentication getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(HEADER_STRING);
        if (token != null) {
            Claims claims = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                    .getBody();
            List<GrantedAuthority> grantedAuths =
                    AuthorityUtils.commaSeparatedStringToAuthorityList((String) claims.get("roles"));
            return new UsernamePasswordAuthenticationToken(claims.getSubject(), null, grantedAuths);
        }
        return null;
    }
}
