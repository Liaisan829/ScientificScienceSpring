<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <#include "base.ftlh"/>
    <#import "/spring.ftl" as spring/>
    <#macro title>Статьи</#macro>
    <link rel="stylesheet" href="styles/articles.css">
</head>
<body>
<#macro content>
    <div class="menu-search">
        <div class="menu-flex">
            <a href="#">Health</a>
            <a href="#">Science</a>
            <a href="#">Home|Garden</a>
            <a href="#">Tech</a>
            <a href="#">Animal</a>
            <a href="#">Culture</a>
        </div>
        <div class="search-flex">
            <p><input type="search" name="q" class="search-field" placeholder="Поиск по сайту">
                <input type="submit" class="searchButton" value="Найти"></p>
        </div>
    </div>

    <div class="content">
        <div class="articles">
            <#list articles as article>
                <div class="article">
                    <p>${article.title}</p>
                    <p>${article.text}</p>
                    <p>${article.userId}</p>
                    <p>${article.userName}</p>
                </div>
            </#list>
        </div>

        <div class="addArticle">
            <form action="/articles" method="post">
                <input type="text" placeholder="Название">
                <input type="text" placeholder="Содержание">
                <button type="submit">Добавить</button>
            </form>
        </div>
    </div>
</#macro>
</body>
</html>