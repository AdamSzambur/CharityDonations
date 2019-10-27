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
                Logowanie użytkownika

                <form:form method="post" modelAttribute="loginUserDTO">
                    <div class="form-group form-group--inline" align="center">
                        <label>
                            <table>
                                <tr>
                                    <td align="right">email :</td>
                                    <td><form:input path="email" cssClass="form-control" id="email"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td align="right">Hasło :</td>
                                    <td><form:password path="password" cssClass="form-control" id="password"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="2">
                                        <span class="error_small">${errorMsg}</span>
                                    </td>
                                </tr>

                            </table>
                        </label>
                    </div>
                    <div class="form-group form-group--inline">
                    <div class="form-group form-group--inline">
                        <button type="submit" class="btn btn-primary">Zaloguj</button>
                    </div>
                </form:form>
            </h1>
        </div>
    </div>
</header>
<footer>
<jsp:include page="footer.jsp"/>

