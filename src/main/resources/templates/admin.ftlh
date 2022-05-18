<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <#include "base.ftlh"/>
    <#macro title>Пользователи</#macro>
    <link rel="stylesheet" href="styles/admin.css">
</head>
<body>
<#macro content>
    <div class="content">
        <div id="addUser">
            <input type="text" id="name" placeholder="Имя" name="name">
            <input type="email" id="email" placeholder="Почта" name="email">
            <input type="password" id="password" placeholder="Пароль" name="password">
            <button id="addUser">Добавить</button>
        </div>

<#--        <div class="updateUser">-->
<#--            <input type="text" id="userName" placeholder="Имя">-->
<#--            <input type="email" id="email" placeholder="Почта">-->
<#--            <input type="password" id="password" placeholder="Пароль">-->
<#--            <button id="addUser">Добавить</button>-->
<#--        </div>-->

        <div id="users"></div>
    </div>
</#macro>
<script src="js/admin.js"></script>
</body>
</html>