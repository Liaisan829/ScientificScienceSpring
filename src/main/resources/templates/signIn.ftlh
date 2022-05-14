<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="styles/signUp.css">
    <#include "base.ftlh"/>
    <#macro title>Вход</#macro>
</head>
<body>
<#macro content>

    <div class="form-style-2">
        <div class="form-style-2-heading">
            Вход
        </div>
        <form action="/signIn" method="post">

            <div class="input-field">
                <input type="email" name="email" placeholder="Почта">
            </div>

            <div class="input-field">
                <input type="password" name="password" placeholder="Пароль">
            </div>

            <div class="signup_link">Запомнить меня?
                <input type="checkbox" name="rememberMe">
            </div>

            <input type="submit" value="войти">
        </form>
    </div>
</#macro>
</body>
</html>