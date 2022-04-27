package ru.kpfu.itis.akhmetova.model;

public class Article {
    private int id;
    private String subject;
    private String title;
    private String content;

    public Article(int id, String subject, String title, String content) {
        this.id = id;
        this.subject = subject;
        this.title = title;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
