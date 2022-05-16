<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="styles/profile.css">
    <#include "base.ftlh"/>
    <#macro title>Профиль</#macro>
</head>
<body>
<#macro content>
    <div class="content">
        <div class="aside">
            <#if user.role == "ADMIN">
                <a href="/admin">Перейти в настройки - Администратор</a>
            </#if>
            <a href="/myArticles">Ваши посты</a>
            <a href="profile/update">Изменить данные</a>
            <a href="/logout">Выход</a>
        </div>

        <div class="profile">
            <p>Добро пожаловать, ${user.name}!</p>
            <p>Ваша почта: ${user.email}</p>
        </div>
    </div>
</#macro>
</body>
</html>