<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:url value="/" var="mainURL"/>
<jsp:include page="header.jsp"/>

    <div class="slogan container container--90">
        <div class="slogan--item">
            <h1>
                Dodawanie nowego użytkownika do bazy
            </h1>
        </div>
    </div>
</header>

<section id="stats" class="stats">
    <div class="container container--85">
        <form:form method="post" modelAttribute="userFormDTO">
            <div class="form-group">
                <label for="firstName">Imię</label>
                <form:input path="firstName" cssClass="form-control" id="firstName"/>
                <form:errors path="firstName" cssClass="invalid-feedback" element="div" />
            </div>

            <div class="form-group">
                <label for="lastName">Nazwisko</label>
                <form:input path="lastName" cssClass="form-control" id="lastName"/>
                <form:errors path="lastName" cssClass="error" element="div" />
            </div>

            <div class="form-group">
                <label for="email">Adres e-mail</label>
                <form:input path="email" cssClass="form-control" id="email"/>
                <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
                <form:errors path="email" cssClass="error" element="div" />
            </div>
            <div class="form-group">
                <label for="password">Hasło</label>
                <form:password path="password" cssClass="form-control" id="password"/>
                <form:errors path="password" cssClass="error" element="div" />
            </div>

            <div class="form-group">
                <label for="rePassword">Powtórz hasło</label>
                <form:password path="rePassword" cssClass="form-control" id="rePassword"/>
                <form:errors path="rePassword" cssClass="error" element="div" />
            </div>
            <button type="submit" class="btn btn-primary">Zarejestruj użytkownika</button>
        </form:form>

    </div>
</section>
<jsp:include page="footer.jsp"/>

