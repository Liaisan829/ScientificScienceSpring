package ru.kpfu.itis.akhmetova.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kpfu.itis.akhmetova.model.User;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private Integer id;

    private String name;

    private String email;

    private String password;

    public static UserDto fromModel(User user) {
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }

    public static List<UserDto> fromModelList(List<User> users) {
        return users.stream().map(UserDto::fromModel).collect(Collectors.toList());
    }
}
