<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <#macro title>Ваши статьи</#macro>
    <#include "base.ftlh"/>
</head>
<body>
<#macro content>
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
</#macro>
</body>
</html>