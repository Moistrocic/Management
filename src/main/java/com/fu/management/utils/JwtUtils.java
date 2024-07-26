package com.fu.management.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Map;

public class JwtUtils {
    private static SecretKey signKey = Jwts.SIG.HS256.key().build();
    private static Long expire = 86400000L;

    public static String generateJwt(Map<String, Object> claims) {
        return Jwts.builder()
                .claims(claims)
                .signWith(signKey, Jwts.SIG.HS256)
                .expiration(new Date(System.currentTimeMillis() + expire))
                .compact();
    }

    public static Claims parseJwt(String jwt) {
        return Jwts.parser()
                .verifyWith(signKey)
                .build()
                .parseSignedClaims(jwt)
                .getPayload();
    }
}
