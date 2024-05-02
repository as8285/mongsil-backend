package com.nurung.mongsil.config;

import com.nurung.mongsil.domain.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Map;

@Service
public class TokenProvider {
    private SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS512);
    public String create(User user){

        return Jwts.builder()
                .signWith(secretKey)
                .setClaims(Map.of(
                        "id",user.getId(),
                        "name",user.getName(),
                        "phone",user.getPhone(),
                        "role",user.getRole()
                ))
                .setIssuedAt(new Date())
                .setExpiration(Date.from(Instant.now().plus(1, ChronoUnit.DAYS)))
                .compact();

    }

    public User validateGetUser(String token){
        Claims claims =Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token).getBody();
        return User.builder()
                .id((String)claims.get("id"))
                .name((String)claims.get("name"))
                .phone((String)claims.get("phone"))
                .role((String)claims.get("role"))
                .build();
    }

}