package ru.kpfu.itis.akhmetova.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kpfu.itis.akhmetova.helper.ValidEmail;
import ru.kpfu.itis.akhmetova.helper.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignUpForm {

    @NotBlank
    @Size(min = 2, max = 20)
    private String name;

    @NotBlank
    @ValidEmail
    @Email
    private String email;

    @Validator
    private String password;
}
