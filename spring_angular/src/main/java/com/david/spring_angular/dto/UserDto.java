package com.david.spring_angular.dto;

import com.david.spring_angular.models.User;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class UserDto {

    private Integer id;

    @NotNull(message = "Le prénom ne doit pas être null")
    @NotEmpty(message = "Le prénom ne doit pas être vide")
    @NotBlank(message = "Le prénom ne doit pas être blank")
    private String firstname;

    @NotNull(message = "Le nom de famille ne doit pas être null")
    @NotEmpty(message = "Le nom de famille ne doit pas être vide")
    @NotBlank(message = "Le nom de famille ne doit pas être blank")
    private String lastname;

    @NotNull(message = "L'email ne doit pas être null")
    @NotEmpty(message = "L'email ne doit pas être vide")
    @NotBlank(message = "L'email ne doit pas être blank")
    @Email
    private String email;

    @NotNull(message = "Le mot de passe ne doit pas être null")
    @NotEmpty(message = "Le mot de passe ne doit pas être vide")
    @NotBlank(message = "Le mot de passe ne doit pas être blank")
    @Size(min=8, max=60)
    private String password;

    public static UserDto fromEntity(User user) {
        return UserDto.builder()
                .id(user.getId())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }

    public static User toEntity(UserDto user) {
        return User.builder()
                .id(user.getId())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }
}
