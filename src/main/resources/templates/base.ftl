<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="../styles/header.css">
    <title><@title></@title></title>
</head>
<body>
<header class="header">
    <div class="nav-bar">
        <h1>Scientific Science</h1>

        <#if user?has_content>
            <div class="nav-bar-innerflex">
                <#--                TODO когда прикручу аватарку включить ее здесь-->
                <#--                <img alt="user_img" src="${user.avatar}" width="50" height="50" class="rounded-circle" style="">-->

                <a class="nav-link" href="/profile"><strong>${user.nickname}</strong></a>
            </div>

        <#else>
            <div class="nav-bar-innerflex">
                <a class="nav-link" href="/signIn">Войти</a>
                <a class="nav-link" href="/signUp">Регистрация</a>
            </div>
        </#if>
    </div>
    <div class="menu-search">
        <div class="menu-flex">
            <#--            <a href="health.jsp">Health</a>-->
            <#--            <a href="science.jsp">Science</a>-->
            <#--            <a href="homegarden.jsp">Home|Garden</a>-->
            <#--            <a href="tech.jsp">Tech</a>-->
            <#--            <a href="animal.jsp">Animal</a>-->
            <#--            <a href="culture.jsp">Culture</a>-->
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
</header>

<main>
    <@content></@content>
</main>

</body>
</html>