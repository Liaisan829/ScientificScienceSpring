package ru.kpfu.itis.akhmetova.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    public enum Role {
        USER, ADMIN
    };

    public enum State {
        NOT_CONFIRMED, CONFIRMED, DELETED, BANNED
    };

    @Size(min = 2, max = 20, message = "Name should contain from 2 to 20 symbols")
    private String name;

    @Column(unique = true)
    private String email;

    @Size(min = 5, max = 64, message = "Password should contain from 5 to 64 symbols")
    @Column(nullable = false, length = 64)
    private String password;

    @Column(length = 64)
    private String confirmCode;

    @Enumerated(value = EnumType.STRING)
    private Role role;

    @Enumerated(value = EnumType.STRING)
    private State state;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Article> articles;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ArticleComment> articleComments;

}
