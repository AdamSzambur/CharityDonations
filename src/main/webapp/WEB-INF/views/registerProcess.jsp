<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:url value="/" var="mainURL"/>
<jsp:include page="header.jsp"/>

<section class="login-page">
        <div class="container" style="font-size: 14px">
            <h2><spring:message code="registerPageProcess.headCaption"/></h2>
            <br>
            <div class="row justify-content-md-center">
                <div class="col col-lg-12 p-3 text-center">
                    <span class="error">${message}</span>
                </div>
            </div>
        </div>
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

