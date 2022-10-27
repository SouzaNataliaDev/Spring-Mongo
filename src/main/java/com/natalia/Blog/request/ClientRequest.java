package com.natalia.Blog.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
public class ClientRequest {
    @NotNull
    @NotBlank
    @JsonProperty("nome")
    private String name;
    @NotNull
    @NotBlank
    @JsonProperty("celular")
    @Size(max = 11, min = 11)
    private String cell;
    @NotNull
    @NotBlank
    @Email
    @JsonProperty("email")
    private String email;
}
