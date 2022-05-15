<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <#include "base.ftlh"/>
    <#import "/spring.ftl" as spring/>
    <#macro title>Главная страница</#macro>
    <link rel="stylesheet" href="styles/main.css">
</head>
<body>
<#macro content>
    <div class="content">
        <div class="links">
            <p><a href="/articles">Перейти к статьям</a></p>
            <p><a href="/articles">Перейти к статьям</a></p>
            <p><a href="/articles">Перейти к статьям</a></p>
            <p><a href="/articles">Перейти к статьям</a></p>
        </div>

        <div class="image">
            <img src="images/books.jpg" alt="books">
        </div>
    </div>
</#macro>
</body>
</html>