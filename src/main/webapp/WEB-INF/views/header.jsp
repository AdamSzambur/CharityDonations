<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:url value="/" var="mainURL"/>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <title><spring:message code="app.titles"/></title>
    <script src="https://kit.fontawesome.com/da6d9e6874.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="${mainURL}resources/css/style.css"/>
</head>
<body>
<header class="header--${headerClass}-page">
    <nav class="container container--70">

        <c:if test="${loggedUser!=null}">
        <ul class="nav--actions">
            <li class="logged-user">
                Witaj ${loggedUser.fullName}
                <ul class="dropdown">
                    <li><a href="${mainURL}users/edit">Profil</a></li>
                    <li><a href="${mainURL}users/donations">Moje zbiórki</a></li>
                    <c:if test="${loggedUser.role.equals('ROLE_ADMIN')}">
                    <li><a href="${mainURL}admin/institutions">Instutucje</a></li>
                    <li><a href="${mainURL}admin/users">Użytkownicy</a></li>
                    </c:if>
                    <li><a href="${mainURL}logout">Wyloguj</a></li>
                </ul>
            </li>
        </ul>
        </c:if>
            <c:if test="${loggedUser==null}">
                <ul class="nav--actions">
                    <li><a href="${mainURL}users/login" class="btn btn--small btn--without-border">Zaloguj</a></li>
                    <li><a href="${mainURL}users/register" class="btn btn--small btn--highlighted">Załóż konto</a></li>
                </ul>
            </c:if>



        <ul>
            <li><a href="${mainURL}" class="btn btn--without-border active">Start</a></li>
            <li><a href="${mainURL}#steps" class="btn btn--without-border">O co chodzi?</a></li>
            <li><a href="${mainURL}#about-us" class="btn btn--without-border">O nas</a></li>
            <li><a href="${mainURL}#help" class="btn btn--without-border">Fundacje i organizacje</a></li>
            <li><a href="${mainURL}donations" class="btn btn--without-border">Przekaż dary</a></li>
            <li><a href="${mainURL}#contact" class="btn btn--without-border">Kontakt</a></li>
        </ul>
    </nav>