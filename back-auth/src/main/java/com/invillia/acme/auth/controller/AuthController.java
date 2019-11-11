package com.invillia.acme.auth.controller;

import com.invillia.acme.auth.db.dto.LoginDto;
import com.invillia.acme.auth.exception.BusinessException;
import com.invillia.acme.auth.service.AuthService;
import com.invillia.acme.auth.db.dto.TokenDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@RestController()
@RequestMapping(path = "/auth", produces = {MediaType.APPLICATION_JSON_VALUE})
@Api(value = "auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    /**
     * Metodo responsavel pela geração do token
     *
     * @param request
     * @param response
     * @param login
     * @return ResponseEntity<?>
     * @throws IOException
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(notes = "Geração de token de acesso", value = "Login", response = TokenDto.class)
    public ResponseEntity login(HttpServletRequest request, HttpServletResponse response,
                                   @RequestBody LoginDto login) throws IOException {
        String token = authService.login(request, response, login.getLogin(), login.getSenha());
        if (token == null) {
            throw new BusinessException("Dados invalidos");
        }
        TokenDto tokenDTO = TokenDto.builder().login(login.getLogin()).token(token).build();
        return ResponseEntity.status(HttpStatus.OK).body(tokenDTO);
    }

}
