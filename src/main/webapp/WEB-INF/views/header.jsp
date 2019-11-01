<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:url value="/" var="mainURL"/>
<!DOCTYPE html>
<html lang="en">
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
                <spring:message code="userMenu.hello"/> ${loggedUser.fullName}
                <ul class="dropdown">
                    <li><a href="${mainURL}users/edit"><spring:message code="userMenu.button.profile"/></a></li>
                    <li><a href="${mainURL}users/donations"><spring:message code="userMenu.button.myDonations"/></a></li>
                    <c:if test="${loggedUser.role.equals('ROLE_ADMIN')}">
                    <li><a href="${mainURL}admin/institutions"><spring:message code="userMenu.button.institutions"/></a></li>
                    <li><a href="${mainURL}admin/users"><spring:message code="userMenu.button.users"/></a></li>
                    </c:if>
                    <li><a href="${mainURL}logout"><i class="fas fa-sign-out-alt"></i> <spring:message code="userMenu.button.signOut"/></a></li>
                </ul>
            </li>
            <li>&nbsp;&nbsp;<img onclick="location.href='${mainURL}?lang=pl'" alt="pl" src="${mainURL}resources/images/icon_pl.svg" height="24" width="24"></li>
            <li><img onclick="location.href='${mainURL}?lang=en'" alt="en" src="${mainURL}resources/images/icon_uk.svg" height="24" width="24"></li>
        </ul>
        </c:if>
            <c:if test="${loggedUser==null}">
                <ul class="nav--actions">
                    <li><a href="${mainURL}users/login" class="btn btn--small btn--without-border"><i class="fas fa-sign-in-alt"></i> <spring:message code="mainMenu.button.signIn"/></a></li>
                    <li><a href="${mainURL}users/register" class="btn btn--small btn--highlighted"><i class="fas fa-user-plus"></i> <spring:message code="mainMenu.button.signUp"/></a></li>
                    <li>&nbsp;&nbsp;<img onclick="location.href='${mainURL}?lang=pl'" alt="pl" src="${mainURL}resources/images/icon_pl.svg" height="24" width="24"></li>
                    <li><img onclick="location.href='${mainURL}?lang=en'" alt="en" src="${mainURL}resources/images/icon_uk.svg" height="24" width="24"></li>
                </ul>
            </c:if>
        <ul>
            <li><a href="${mainURL}" class="btn btn--without-border active"><spring:message code="mainMenu.button.start"/> </a></li>
            <li><a href="${mainURL}#steps" class="btn btn--without-border"><spring:message code="mainMenu.button.description"/></a></li>
            <li><a href="${mainURL}#about-us" class="btn btn--without-border"><spring:message code="mainMenu.button.about"/></a></li>
            <li><a href="${mainURL}#help" class="btn btn--without-border"><spring:message code="mainMenu.button.institutions"/></a></li>
            <li><a href="${mainURL}donations" class="btn btn--without-border"><spring:message code="mainMenu.button.giveDonations"/></a></li>
            <li><a href="${mainURL}#contact" class="btn btn--without-border"><spring:message code="mainMenu.button.contact"/></a></li>
        </ul>
    </nav>