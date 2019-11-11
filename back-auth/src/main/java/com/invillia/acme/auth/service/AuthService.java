package com.invillia.acme.auth.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.invillia.acme.auth.db.dto.LoginDto;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


/**
 * OrderService
 *
 * @author wesley rover
 *
 */
@Service
public class AuthService  {

    HashMap<LoginDto, String> users = new HashMap<>();

    public AuthService() {
        LoginDto adm = LoginDto.builder().login("admin").senha("123456").build();
        users.put(adm, "ROLE_ADMIN");
        LoginDto cliente = LoginDto.builder().login("cliente").senha("123456").build();
        users.put(cliente, "ROLE_USER");
    }

    public String login(HttpServletRequest request, HttpServletResponse response, String username, String senha)
            throws IOException {
        Optional<Entry<LoginDto, String>> op = verificaAutenticacao(username, senha);
        if (!op.isPresent()) {
            return null;
        }
        return makeAuthenication(request, response, username, op.get().getValue());
    }

    private Optional<Entry<LoginDto, String>> verificaAutenticacao(String username, String senha) {
        return users.entrySet().stream()
                .filter(user -> user.getKey().getLogin().equalsIgnoreCase(username) && user.getKey().getSenha().equalsIgnoreCase(senha))
                .findAny();

    }

    private String makeAuthenication(HttpServletRequest request, HttpServletResponse response, String username,
                                     String roles) throws IOException {
        TokenAuthenticationService authenticationService = new TokenAuthenticationService();
        String userToken = authenticationService.addAuthentication(response, username, roles);
        Authentication authentication = TokenAuthenticationService.getAuthentication(request);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return userToken;
    }

}
