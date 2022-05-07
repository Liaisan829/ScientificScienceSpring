package ru.kpfu.itis.akhmetova.dto;

import javax.validation.constraints.NotBlank;

public class CreateUserDto {
    @NotBlank(message = "Name should not be blank!")
    private String name;

    @NotBlank(message = "Email should not be blank!")
    private String email;

    @NotBlank(message = "Password should not be blank!")
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
