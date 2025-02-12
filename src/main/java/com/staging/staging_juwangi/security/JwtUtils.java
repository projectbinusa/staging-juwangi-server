package com.staging.staging_juwangi.security;

import com.staging.staging_juwangi.model.User;
import com.staging.staging_juwangi.repository.UserRepository;
import com.staging.staging_juwangi.service.UserDetail;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
public class JwtUtils {
    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);
    private String jwtSecret = "staging_juwangi";
    private int jwtExpirationMs = 604800000;
    private static final String SECRET_KEY = "staging_juwangi";

    @Autowired
    UserRepository userRepository;

    public String generateToken(Authentication authentication) {
        UserDetail adminPrincipal = (UserDetail) authentication.getPrincipal();
        User user = userRepository.findByEmail(adminPrincipal.getUsername()).get();
        return Jwts.builder()
                .setSubject(adminPrincipal.getUsername())
                .claim("id" , adminPrincipal.getId())
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }
    public static Claims decodeJwt(String jwtToken) {
        Jws<Claims> jwsClaims = Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(jwtToken);

        return jwsClaims.getBody();
    }
    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateJwtToken(String authToken) {

        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            logger.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty: {}", e.getMessage());
        }
        return false;
    }

}