package com.backend_tutorial.course_erp.filters;

import com.backend_tutorial.course_erp.constants.TokenConstants;
import com.backend_tutorial.course_erp.exception.BaseException;
import com.backend_tutorial.course_erp.services.security.AccessTokenManager;
import com.backend_tutorial.course_erp.services.security.AuthBusinessService;
import com.backend_tutorial.course_erp.services.user.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Objects;

@Component
@RequiredArgsConstructor
@Slf4j
public class AuthorizationFilter extends OncePerRequestFilter {

    private final AccessTokenManager accessTokenManager;
    private final AuthBusinessService authBusinessService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String token = request.getHeader(HttpHeaders.AUTHORIZATION);
        try {
            if (Objects.nonNull(token) && token.startsWith(TokenConstants.TOKEN_PREFIX)) {
                authBusinessService.setAuthentication(
                        accessTokenManager.getEmail(
                                token.substring(7)));
            }

        }
        catch (BaseException | JwtException ex ){
            log.warn(ex.getMessage());
        } catch (Exception ex){
            ex.printStackTrace();
        }

            filterChain.doFilter(request, response);
}
    }



