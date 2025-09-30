package com.backend_tutorial.course_erp.services.security;

import com.backend_tutorial.course_erp.constants.TokenConstants;
import com.backend_tutorial.course_erp.models.dto.RefreshTokenDto;
import com.backend_tutorial.course_erp.models.mybatis.user.User;
import com.backend_tutorial.course_erp.models.properties.security.SecurityProperties;
import com.backend_tutorial.course_erp.services.base.TokenGenerator;
import com.backend_tutorial.course_erp.services.base.TokenReader;
import com.backend_tutorial.course_erp.services.getter.EmailGetter;
import com.backend_tutorial.course_erp.utils.PublicPrivateKeyUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
@RequiredArgsConstructor
public class RefreshTokenManager implements TokenGenerator<RefreshTokenDto>,
        TokenReader<Claims>, EmailGetter {
    private final SecurityProperties securityProperties;

    @Override
    public  String generator(RefreshTokenDto obj) {
        final User user = obj.getUser();
        Claims claims = Jwts.claims();
        claims.put("email", user.getEmail());
        claims.put("type", "REFRESH_TOKEN");

        Date now = new Date();
        Date exp = new Date(now.getTime() + securityProperties.getJwt().getRefreshTokenValidityTime(obj.isRememberMe()));


        return Jwts.builder()
                .setSubject(String.valueOf(user.getId()))
                .setIssuedAt(now)
                .setExpiration(exp)
                .setClaims(claims)
                .signWith(PublicPrivateKeyUtils.getPrivateKey(), SignatureAlgorithm.RS256)
                .compact();
    }

    @Override
    public Claims read(String token) {




        Claims tokenData= Jwts.parserBuilder().setSigningKey(PublicPrivateKeyUtils.getPublicKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
     String typeOfToken=tokenData.get("type",String.class);

     if (!"REFRESH_TOKEN".equals(typeOfToken)){
         System.out.println("burdayam");
         throw new RuntimeException("Invalid type of token");
     }
return tokenData;

    }

    @Override
    public String getEmail(String token) {
        return read(token).get(TokenConstants.EMAIL_KEY,String.class);
    }
}
