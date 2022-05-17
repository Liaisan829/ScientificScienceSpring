<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <#macro title>Ваши статьи</#macro>
    <link rel="stylesheet" href="styles/myArticles.css">
    <#include "base.ftlh"/>

</head>
<body>
<#macro content>
    <div class="articles">
        <h1>Ваши статьи</h1>

        <#list articles as article>
            <div class="article">
                <a href="/articles/${article.id}"><h5>${article.title}</h5></a>
                <p>${article.text}</p>
                <p>Автор статьи: ${article.userName}</p>
                <form action="/myArticles/${article.id}/delete" method="post">
                    <input type="submit" value="Удалить">
                </form>
            </div>
        </#list>
    </div>
</#macro>
</body>
</html>