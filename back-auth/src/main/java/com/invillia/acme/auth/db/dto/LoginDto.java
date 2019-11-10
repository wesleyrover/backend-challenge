package com.invillia.acme.auth.db.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {

    @ApiModelProperty(required=true)
    private String login;

    @ApiModelProperty(required=true)
    private String senha;
}
