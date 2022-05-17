<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <#include "base.ftlh"/>
    <#import "/spring.ftl" as spring/>
    <#macro title>Статьи</#macro>
    <link rel="stylesheet" href="styles/articles.css">
</head>
<body>
<#macro content>
    <div class="menu-search">
        <div class="menu-flex">
            <a href="#">Health</a>
            <a href="#">Science</a>
            <a href="#">Home|Garden</a>
            <a href="#">Tech</a>
            <a href="#">Animal</a>
            <a href="#">Culture</a>
        </div>
        <div class="search-flex">
            <p><input type="search" name="q" class="search-field" placeholder="Поиск по сайту"
                      onkeyup="showResult(this.value)">
                <input type="submit" class="searchButton" value="Найти"></p>
        </div>
    </div>

    <div class="content">

        <table id="articles_table">

        </table>

        <div class="article_content">

            <div class="articles">
                <h1>Статьи</h1>
                <#if articles?has_content>
                    <#list articles as article>
                        <div class="article">
                            <a href="/articles/${article.id}"><h5>${article.title}</h5></a>
<#--                            <p>${article.title}</p>-->
                            <p>${article.text}</p>
                            <p>Автор статьи: ${article.userName}</p>
                        </div>
                    </#list>
                <#else>
                    <p>На данный момент нет статей. Будьте первым!</p>
                </#if>
            </div>

            <div class="addArticle">
                <form action="/articles/add" method="post">
                    <input type="text" name="title" placeholder="Название">
                    <input type="text" name="text" placeholder="Содержание">
                    <button type="submit">Добавить</button>
                </form>
            </div>
        </div>
    </div>
</#macro>

<script>
    function showResult(title) {
        const xmlhttp = new XMLHttpRequest();
        xmlhttp.onreadystatechange = function () {
            if (this.readyState === 4 && this.status === 200) {
                let html =
                    '<thead>' +
                    '<th>Название</th>' +
                    '<th>Содержание</th>' +
                    '<th>Автор</th>' +
                    '</thead>'

                let response = JSON.parse(this.response);

                for (let i = 0; i < response.length; i++) {
                    html += '<tr>';
                    html += '<td>' + response[i]['title'] + '</td>';
                    html += '<td>' + response[i]['text'] + '</td>';
                    html += '<td>' + response[i]['userName'] + '</td>';
                    html += '</tr>';
                }
                document.getElementById('articles_table').innerHTML = html;
            }
        }
        xmlhttp.open("GET", "/articles/" + title, true);
        xmlhttp.send();
    }
</script>
</body>
</html>