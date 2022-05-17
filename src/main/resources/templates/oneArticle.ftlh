<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="styles/oneArticle.css">
    <#include "base.ftlh"/>
    <#macro title>Статья</#macro>
</head>
<body>
<#macro content>
    <div class="content">
        <#if article?has_content>
            <div class="article">
                <p>${article.title}</p>
                <p>${article.text}</p>
                <p>Автор: ${article.userName}</p>

                <p>Комментарии:</p>
                <#if articleComments?has_content>
                    <#list articleComments as comment>
                        <div class="comment">
                            <p>${comment.text}</p>
                        </div>
                    </#list>
                <#else>
                    <p>Пока комментариев нет</p>
                </#if>

                <form action="/createComment/${article.id}" method="post">
                    <input type="text" name="text" placeholder="Ваш комментарий">
                    <input type="submit" value="Добавить">
                </form>
            </div>
        </#if>
    </div>
</#macro>
</body>
</html>