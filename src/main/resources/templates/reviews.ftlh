<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="styles/reviews.css">
    <#include "base.ftlh"/>
    <#macro title>Отзывы</#macro>
</head>
<body>
<#macro content>
    <div class="content">
        <div class="reviews">
            <h1>Отзывы</h1>

            <#list reviews as review>
                <div class="review">
                    <p>${review.text}</p>
                    <p>${review.userName}</p>
                </div>
            </#list>
        </div>

        <form action="/reviews/add" method="post">
            <input type="text" name="text" placeholder="Ваш отзыв">
            <button type="submit">Добавить</button>
        </form>
    </div>
</#macro>
</body>
</html>