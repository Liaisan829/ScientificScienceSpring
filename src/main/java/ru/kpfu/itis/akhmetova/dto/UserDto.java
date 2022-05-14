package ru.kpfu.itis.akhmetova.dto;

import ru.kpfu.itis.akhmetova.model.User;

public class UserDto {
    private Integer id;

    private String name;

    private String email;

    private String password;

    public UserDto(Integer id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public UserDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public static UserDto fromModel(User user) {
        return new UserDto(user.getId(), user.getEmail(), user.getPassword(), user.getName());
    }
}
