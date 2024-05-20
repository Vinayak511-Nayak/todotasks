package com.example.todotasks.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

public class JwtUtil {
    //create token
    private final String secret = "yoursecretkeyshouldbealwayshiddenfromeverywhereitshouldbein.envfile"; // Replace with your own secret key

    SecretKey key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));

    public String generate_token(String username)
    {
        Date now=new Date();
        Date expiry_date=new Date(now.getTime()+3600000);
        return Jwts.builder().subject(username).issuedAt(now).expiration(expiry_date).signWith(key).compact();

    }

    public ResponseEntity<String> verify_token(String token)
    {
        try
        {
            Jwts.parser()

                    .verifyWith(key) // <----

                    .build()
                    .parseSignedClaims(token);
            return ResponseEntity.ok("token is valid");
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatusCode.valueOf(400)).body("invalid token");
        }

    }

    public String get_user(String bearer_token)
    {
        String token= bearer_token.substring(7);
       Claims claims= Jwts.parser()

                .verifyWith(key) // <----

                .build()
                .parseSignedClaims(token).getPayload();
       return claims.getSubject();
    }

}
