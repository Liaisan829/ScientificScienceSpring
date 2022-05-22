<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="styles/header.css">
    <title><@title></@title></title>
</head>
<body>
<header class="header">
    <div class="nav-bar">
        <a href="/"><h1>Scientific Science</h1></a>

        <div class="nav-bar-innerflex">
            <a class="nav-link" href="/signIn">Войти</a>
            <a class="nav-link" href="/signUp">Регистрация</a>
            <a class="nav-link" href="/profile">Личный кабинет</a>
        </div>
    </div>

</header>

<main>
    <@content></@content>
</main>

</body>
</html>