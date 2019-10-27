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
                Dziękujemy za przesłanie formularza Na maila prześlemy wszelkie
                informacje o odbiorze
            </h1>
        </div>
    </div>
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

