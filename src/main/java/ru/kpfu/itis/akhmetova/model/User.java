package ru.kpfu.itis.akhmetova.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

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

    @OneToMany(cascade = CascadeType.ALL)
    private List<Article> articles;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ArticleComment> articleComments;

    public User(Integer id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public User(String name, String email, String password, String confirmCode, Role role, State state) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.confirmCode = confirmCode;
        this.role = role;
        this.state = state;
    }

    public User() {
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

    public String getConfirmCode() {
        return confirmCode;
    }

    public void setConfirmCode(String confirmCode) {
        this.confirmCode = confirmCode;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public List<ArticleComment> getArticleComments() {
        return articleComments;
    }

    public void setArticleComments(List<ArticleComment> articleComments) {
        this.articleComments = articleComments;
    }
}
