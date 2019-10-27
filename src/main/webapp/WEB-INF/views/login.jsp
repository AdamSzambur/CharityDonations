<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:url value="/" var="mainURL"/>
<jsp:include page="header.jsp"/>


<section class="login-page">
    <h2>Logowanie użytkownika</h2>
    <div class="container" style="font-size: 14px">
        <br>
        <div class="row justify-content-md-center">
            <div class="col col-lg-3">
                <form:form method="post" modelAttribute="loginUserDTO">
                    <div class="form-group">
                        <label for="exampleInputEmail1">Adres email</label>
                        <form:input path="email" cssClass="form-control" id="exampleInputEmail1" placeholder="Enter email"/>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">Hasło</label>
                        <form:password path="password" cssClass="form-control" id="exampleInputPassword1"/>
                        <br><a class="btn btn--very-small btn--blue" href="#">Przypomnij hasło</a>
                    </div>
                    <div class="form-group text-center">
                    <button type="submit" class="btn btn--small btn--yellow message-btn">Zaloguj użytkownika</button>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</section>
</header>
<jsp:include page="footer.jsp"/>

