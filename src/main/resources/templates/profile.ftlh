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
    <div class="aside">
        <#if user.role == "ADMIN">
            <a href="/accounts">Перейти в настройки - Администратор</a>
        </#if>
        <a href="/articles">Ваши посты</a>
        <a href="profile/update">Изменить данные</a>
        <a href="/logout">Выход</a>
    </div>

    <div class="profile">
        <p>Добро пожаловать, ${user.name}!</p>
<#--        <#if account.avatar ?? >-->
<#--            <img src="http://localhost:8081/profile/files/${account.avatar}" alt="image" class="avatar">-->
<#--        </#if>-->

    </div>
</#macro>
</body>
</html>