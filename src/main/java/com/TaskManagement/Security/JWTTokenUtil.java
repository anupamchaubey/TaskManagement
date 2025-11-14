package com.TaskManagement.Security;

import com.TaskManagement.Enum.Role;
import org.springframework.stereotype.Component;

import java.security.Signature;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class JWTTokenUtil {

    private final String jwtSecret="JWTTOKEN";
    private final long expireJWT =8400000;

    public String generateToken(String userName, Set<Role> role){
        List<String> authorities=role.stream().map(role -> "Role"+role.name()).collect(Collectors.toList());
        return Jwts.builder().setSubject(userName).claim("roles", authorities).
                setIssuedAt(new Date(System.currentTimeMillis()+expireJWT))
                .signWith(SignatureAlgorithm.E5512.jwtSecret)
                .compact();
    }
    public String extractUserName(String token){
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSub
    }


}
