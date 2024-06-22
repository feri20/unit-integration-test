package com.example.unit;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class JwtGenerationTest {

        @Test
        void generator() throws NoSuchAlgorithmException {
            JwtGenerator generator = new JwtGenerator();
            Map<String, String> claims = new HashMap<>();
            claims.put("action", "read");
            claims.put("sub", "pawel.spychalski");
            claims.put("email", "test@quadmeup.com");
            claims.put("aud", "*");
            String token = generator.generateJwt(claims);
            System.out.println( token);
        }

}
