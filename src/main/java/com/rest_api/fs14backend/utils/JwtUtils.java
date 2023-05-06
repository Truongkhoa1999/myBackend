package com.rest_api.fs14backend.utils;

import com.rest_api.fs14backend.user.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtUtils {
final String secret = "IdontgiveadamnwhatyouthinkIdoitformeandfuckthewholeuniverse";
    public String createToken(Map<String, Object> claims, String subject) {
        return
               Jwts
                       .builder()
                       .setClaims(claims)
                       .setSubject(subject)
                       .setIssuedAt(new Date(System.currentTimeMillis()))
                       .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                       .signWith(SignatureAlgorithm.HS256, secret)
                       .compact();
    }
    public String generateToken(User user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", user.getId());
        claims.put("userName", user.getUsername());
        claims.put("firstName", user.getFirstName());
        return createToken(claims, user.getUsername());
    }
}
