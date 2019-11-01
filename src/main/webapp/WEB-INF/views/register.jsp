<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:url value="/" var="mainURL"/>
<jsp:include page="header.jsp"/>

<section class="login-page">
    <form:form method="post" modelAttribute="userFormDTO">
        <form:hidden path="available"/>
        <form:hidden path="role"/>

        <div class="container" style="font-size: 14px">
            <h2><spring:message code="registerPage.headCaption"/></h2>
            <br>
            <div class="row justify-content-md-center">
                <div class="col col-lg-3 p-3" style="text-align: right">
                    Email
                </div>

                <div class="col col-lg-6 p-3">
                    <div class="input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text" id="inputGroupPrepend">@</span>
                        </div>
                        <form:input path="email" cssClass="form-control" id="email"/>
                    </div>
                    <form:errors path="email" cssClass="error_small" element="div" />
                </div>
            </div>
            <div class="row justify-content-md-center">
                <div class="col col-lg-3 p-3" style="text-align: right">
                    <spring:message code="registerPage.name"/>
                </div>
                <div class="col col-lg-6 p-3">
                    <form:input path="firstName" cssClass="form-control" id="firstName"/>
                    <form:errors path="firstName" cssClass="error_small" element="div" />
                </div>
            </div>
            <div class="row justify-content-md-center">
                <div class="col col-lg-3 p-3" style="text-align: right">
                    <spring:message code="registerPage.surname"/>
                </div>
                <div class="col col-lg-6 p-3">
                    <form:input path="lastName" cssClass="form-control" id="lastName"/>
                    <form:errors path="lastName" cssClass="error_small" element="div" />
                </div>
            </div>
            <div class="row justify-content-md-center">
                <div class="col col-lg-3 p-3" style="text-align: right">
                    <spring:message code="registerPage.password"/>
                </div>
                <div class="col col-lg-6 p-3">
                    <form:password path="password" cssClass="form-control col-lg-6" id="password"/>
                    <form:errors path="password" cssClass="error_small" element="div" />
                </div>
            </div>
            <div class="row justify-content-md-center">
                <div class="col col-lg-3 p-3" style="text-align: right">
                    <spring:message code="registerPage.repassword"/>
                </div>
                <div class="col col-lg-6 p-3">
                    <form:password path="rePassword" cssClass="form-control col-lg-6" id="rePassword"/>
                    <form:errors path="rePassword" cssClass="error_small" element="div" />
                </div>
            </div>
            <div class="row justify-content-md-center">
                <div class="col col-lg-7 p-3 text-center">
                    <button type="submit" class="btn btn--small btn--yellow"><spring:message code="registerPage.button.add"/></button>
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

