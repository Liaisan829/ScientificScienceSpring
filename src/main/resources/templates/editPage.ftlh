<!doctype html>
<#import "spring.ftl" as spring/>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="styles/editPage.css">
    <#include "base.ftlh"/>
    <#macro title>Изменение</#macro>
</head>
<body>
<#macro content>
    <form action="/profile/update" method="post">
        <#assign i18Tooltip><@spring.message code="account.form.placeholder.name"/></#assign>
        <@spring.formInput "userDto.name" "placeholder=${i18Tooltip}"/>
        <@spring.showErrors "<br>" "errors"/>

        <#assign i18Tooltip><@spring.message code="account.form.placeholder.password"/></#assign>
        <@spring.formPasswordInput "userDto.password" "placeholder=${i18Tooltip}"/>
        <@spring.showErrors "<br>" "errors"/>

        <input type="submit" value="Сохранить">
    </form>
</#macro>
</body>
</html>