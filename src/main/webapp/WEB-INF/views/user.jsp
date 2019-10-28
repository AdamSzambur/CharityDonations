<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:url value="/" var="mainURL"/>
<jsp:include page="header.jsp"/>

<section class="login-page">
        <form:form method="post" modelAttribute="userDTO">
            <form:hidden path="id"/>
            <div class="container" style="font-size: 14px">
                <h2>Edycja danych użytkownika</h2>
                <br>
                <div class="row justify-content-md-center">
                    <div class="col col-lg-3 p-3" style="text-align: right">
                        Email
                    </div>
                    <div class="col col-lg-9 p-3">
                        <form:input path="email" cssClass="form-control col-lg-8" id="name" readonly="true"/><br>
                    </div>
                </div>
                <div class="row justify-content-md-center">
                    <div class="col col-lg-3 p-3" style="text-align: right">
                        Imię
                    </div>
                    <div class="col col-lg-9 p-3">
                        <form:input path="firstName" cssClass="form-control col-lg-8" id="description" readonly="true"/><br>
                    </div>
                </div>
                <div class="row justify-content-md-center">
                    <div class="col col-lg-3 p-3" style="text-align: right">
                        Nazwisko
                    </div>
                    <div class="col col-lg-9 p-3">
                        <form:input path="lastName" cssClass="form-control col-lg-8" id="description" readonly="true"/><br>
                    </div>
                </div>
                <div class="row justify-content-md-center">
                    <div class="col col-lg-3 p-3" style="text-align: right">
                        Dostęp uzytkownika
                    </div>
                    <div class="col col-lg-9 p-3">
                        <form:select path="role" cssClass="form-control col-lg-3">
                            <form:options items="${roles}"/>
                        </form:select>
                    </div>
                </div>
                <div class="row justify-content-md-center">
                    <div class="col col-lg-3 p-3" style="text-align: right">
                    </div>
                    <div class="col col-lg-9 p-3">
                        <form:checkbox cssClass="form-check-input" path="available" id="available"/>
                        <label class="form-check-label" for="available">Użytkownik aktywny</label>
                    </div>
                </div>

                <div class="row justify-content-md-center">
                    <div class="col col-lg-12 p-3 text-center">
                        <button type="submit" class="btn btn--small btn--yellow message-btn">Zapisz zmiany</button>
                    </div>
                </div>
            </div>
        </form:form>
</section>
</header>
<footer>
    <div class="bottom-line">
        <span class="bottom-line--copy">Copyright &copy; 2018</span>
        <div class="bottom-line--icons">
            <a href="#" class="btn btn--small"><img src="${mainURL}resources/images/icon-facebook.svg"/></a>
            <a href="#" class="btn btn--small"><img src="${mainURL}resources/images/icon-instagram.svg"/></a>
        </div>
    </div>
</footer>

<jsp:include page="footer.jsp"/>

