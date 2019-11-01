<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:url var="mainURL" value="/"/>
<jsp:include page="header.jsp"/>


<section class="login-page">
    <form:form method="post" modelAttribute="loginUserDTO">
        <div class="container" style="font-size: 14px">
            <h2><spring:message code="loginPage.headCaption"/></h2>
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
                </div>
            </div>
            <div class="row justify-content-md-center">
                <div class="col col-lg-3 p-3" style="text-align: right">
                    <spring:message code="loginPage.password"/>
                </div>
                <div class="col col-lg-6 p-3">
                    <div class="input-group">
                    <form:password path="password" cssClass="form-control col-lg-7" id="password"/>&nbsp;
                    <a href="${mainURL}users/reset_password" class="btn btn--very-small btn--blue"><spring:message code="loginPage.button.resetPassword"/></a>
                    </div>
                </div>
            </div>
            <div class="row justify-content-md-center">
                <div class="col col-lg-7 p-3 text-center">
                    <button type="submit" class="btn btn--small btn--yellow"><spring:message code="loginPage.button.login"/></button>
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

