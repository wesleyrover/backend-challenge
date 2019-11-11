package com.invillia.acme.auth.service;

import com.invillia.acme.auth.AuthApplication;
import com.invillia.acme.auth.db.dto.LoginDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.mockito.Mockito.mock;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AuthApplication.class)
public class AuthServiceTest {

    @Autowired
    private AuthService authService;

    LoginDto login = LoginDto.builder().login("admin").senha("123456").build();
    LoginDto loginFail = LoginDto.builder().login("admin").senha("12345684 ").build();

    HttpServletRequest request = mock(HttpServletRequest.class);
    HttpServletResponse response = mock(HttpServletResponse.class);

    @Test
    public void gerarToken() throws IOException {
        String token = authService.login(request, response, login.getLogin(), login.getSenha());
        Assert.assertNotNull(token);
    }

    @Test
    public void naoDeveRealizarLoginRetornarToken() throws IOException {
        String token = authService.login(request, response, loginFail.getLogin(), loginFail.getSenha());
        Assert.assertNull(token);
    }
}
