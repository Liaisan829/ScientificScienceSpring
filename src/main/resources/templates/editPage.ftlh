<!doctype html>
<#import "spring.ftl" as spring/>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <#include "base.ftlh"/>
    <link rel="stylesheet" href="styles/editPage.css">
    <#macro title>Изменение</#macro>
    <style>
        body{
            padding: 0;
            margin: 0;
        }

        .content{
            max-width: 1300px;
            margin: 30px auto;
            border: 1px solid #2B2B5C;
            border-radius: 5px;
        }

        .content form input{
            margin-bottom: 5px;
            border: 1px solid #2B2B5C;
            padding: 8px 15px 8px 15px;
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
</head>
<body>
<#macro content>
    <div class="content">
        <form action="/profile/update" method="post">
            <#assign i18Tooltip><@spring.message code="account.form.placeholder.name"/></#assign>
            <@spring.formInput "userDto.name" "placeholder=${i18Tooltip}"/>
            <@spring.showErrors "<br>" "errors"/>

            <#assign i18Tooltip><@spring.message code="account.form.placeholder.password"/></#assign>
            <@spring.formPasswordInput "userDto.password" "placeholder=${i18Tooltip}"/>
            <@spring.showErrors "<br>" "errors"/>

            <input type="submit" value="Сохранить">
        </form>
    </div>
</#macro>
</body>
</html>