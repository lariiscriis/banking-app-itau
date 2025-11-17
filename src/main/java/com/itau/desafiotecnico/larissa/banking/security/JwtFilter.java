package com.itau.desafiotecnico.larissa.banking.security;

import com.itau.desafiotecnico.larissa.banking.repository.ClientRepository;
import com.itau.desafiotecnico.larissa.banking.service.JwtService;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;

public class JwtFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final ClientRepository clientRepository;

    public JwtFilter(JwtService jwtService, ClientRepository clientRepository) {
        this.jwtService = jwtService;
        this.clientRepository = clientRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);

            if (jwtService.validateToken(token)) {
                String email = jwtService.extractEmail(token);

                clientRepository.findByEmail(email).ifPresent(client -> {
                    UsernamePasswordAuthenticationToken auth =
                            new UsernamePasswordAuthenticationToken(email, null, new ArrayList<>());
                    SecurityContextHolder.getContext().setAuthentication(auth);
                });
            }
        }

        filterChain.doFilter(request, response);
    }
}
