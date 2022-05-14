<!doctype html>
<#import "spring.ftl" as spring/>
<html lang="en">
<head>
    <#include "base.ftlh"/>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="styles/signUp.css">
    <#macro title>Регистрация</#macro>
</head>

<body>
<#macro content>
    <div class="form-style-2">
        <div class="form-style-2-heading">
            <@spring.message 'signUp.page.header'/>
        </div>

        <form action="/signUp" method="post">
            <@spring.bind path="signUpForm"/>
            <p class="error">${spring.status.errorMessage}</p>

            <div class="input-field">
                <#assign i18Tooltip><@spring.message code="signUp.form.placeholder.name"/></#assign>
                <@spring.formInput "signUpForm.name" "placeholder=${i18Tooltip}"/>
            </div>
            <@spring.showErrors "<br>" "error"/>

            <div class="input-field">
                <#assign i18Tooltip><@spring.message code="signUp.form.placeholder.email"/></#assign>
                <@spring.formInput "signUpForm.email" "placeholder=${i18Tooltip}"/>
            </div>
            <@spring.showErrors "<br>" "error"/>

            <div class="input-field">
                <#assign i18Tooltip><@spring.message code="signUp.form.placeholder.password"/></#assign>
                <@spring.formPasswordInput "signUpForm.password" "placeholder=${i18Tooltip}"/>
                <br>
            </div>
            <@spring.showErrors "<br>" "error"/>

            <input type="submit" value="Зарегистрироваться" class="submit">
        </form>
    </div>
</#macro>
</body>
</html>
