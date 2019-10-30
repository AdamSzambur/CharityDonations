<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:url value="/" var="mainURL"/>
<jsp:include page="header.jsp"/>

<section class="login-page">
    <form method="post">
        <div class="container" style="font-size: 14px">
            <h2>Resetowanie hasła</h2>
            <br>

            <c:if test="${message==null}">
            <div class="row justify-content-md-center">
                <div class="col col-lg-6 p-3" style="text-align: right">
                    Podaj email na który mamy wysłać link do resetowania hasła
                </div>

                <div class="col col-lg-6 p-3">
                    <div class="input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text" id="inputGroupPrepend">@</span>
                        </div>
                        <input type="email" name="email">
                        <span class="error"><br>${error}</span>
                    </div>
                </div>
            </div>
            <div class="row justify-content-md-center">
                <div class="col col-lg-12 p-3 text-center">
                    <button type="submit" class="btn btn--small btn--yellow">Wyślij</button>
                </div>
            </div>
            </c:if>
            <c:if test="${message!=null}">
                <div class="row justify-content-md-center">
                    <div class="col col-lg-12 p-3" style="text-align: right">
                        <span class="error">${message}</span>
                    </div>
                </div>
            </c:if>
        </div>
    </form>
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

