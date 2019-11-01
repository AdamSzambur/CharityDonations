<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:url var="mainURL" value="/"/>
<jsp:include page="header.jsp"/>

<section class="login-page">
        <form:form method="post" modelAttribute="institutionDTO">
            <form:hidden path="id" value="${institutionDTO.id}"/>
            <div class="container" style="font-size: 14px">
                <h2>${title}</h2>
                <br>
                <div class="row justify-content-md-center">
                    <div class="col col-lg-3 p-3" style="text-align: right">
                        <spring:message code="institutionEditPage.name"/>
                    </div>
                    <div class="col col-lg-9 p-3">
                        <form:input path="name" cssClass="form-control" id="name"/><br>
                        <form:errors path="name" cssClass="error_small" element="div" />
                    </div>
                </div>
                <div class="row justify-content-md-center">
                    <div class="col col-lg-3 p-3" style="text-align: right">
                        <spring:message code="institutionEditPage.description"/>
                    </div>
                    <div class="col col-lg-9 p-3">
                        <form:input path="description" cssClass="form-control" id="description"/><br>
                        <form:errors path="description" cssClass="error_small" element="div" />
                    </div>
                </div>
                <div class="row justify-content-md-center">
                    <div class="col col-lg-12 p-3 text-center">
                        <button type="submit" class="btn btn--small btn--yellow message-btn"><spring:message code="institutionEditPage.button.save"/></button>
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

