package com.nhq;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Objects;

@SpringBootTest
class SpringbootTliasApplicationTests {

    @Test
    public void testJWT(){
        HashMap<String, Object> claims = new HashMap<>();
        claims.put("id",1);
        claims.put("name","cxk");

        String jwt = Jwts.builder().signWith(SignatureAlgorithm.HS256, "hpy666")
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000))
                .compact();

        System.out.println(jwt);
    }

    @Test
    public void testParseJWT(){
        Claims claims = Jwts.parser().setSigningKey("hpy666")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoiY3hrIiwiaWQiOjEsImV4cCI6MTY4OTE2ODgzMH0.6vlwPrQ5q1GgWug9wJ73qJ7dRLu3KvuSqwkJcikdR7Y")
                .getBody();


        System.out.println(claims);


    }

}
