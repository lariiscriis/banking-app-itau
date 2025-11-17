package com.itau.desafiotecnico.larissa.banking.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;
import java.security.Key;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
public class JwtService {

    private final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);


    public String generateToken(String email){
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+86400000))
                .signWith(SECRET_KEY)
                .compact();
    }



    public String extractEmail(String token){
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean validateToken(String token){
        try{
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
            return true;
        }
        catch (Exception e){
            return false;

        }
    }

}
