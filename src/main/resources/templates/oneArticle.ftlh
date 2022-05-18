<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="styles/oneArticle.css">
    <style>
        body {
            margin: 0;
            padding: 0;
        }

        .content {
            max-width: 1300px;
            margin: 30px auto;
        }

        .article {
            border: 1px solid #333333;
            border-radius: 5px;
            padding: 20px;
            width: 300px;
        }

        .comment {
            margin-top: 10px;
            border: 1px solid #2B2B5C;
            padding: 3px;
        }
    </style>
    <style>
        header {
            margin: 0 auto;
            padding: 0;
        }

        a {
            text-decoration: none;
            font-weight: normal;
        }

        a:hover {
            font-weight: bold;
        }

        .nav-bar {
            background-color: #2B2B5C;
            padding: 20px 40px 0 40px;
            display: flex;
            flex-direction: row;
            justify-content: space-between;
            align-items: center;
        }

        .nav-bar h1 {
            color: white;
            font-family: 'Open Sans', sans-serif;
            font-style: normal;
            font-weight: bold;
            font-size: 50px;
        }

        .nav-bar-innerflex a{
            font-size: 40px;
            margin: 0 auto;
            padding-right: 20px;
            color: white;

        }


    </style>
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