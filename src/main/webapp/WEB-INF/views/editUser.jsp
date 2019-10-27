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
                Dane użytkownika

                <form:form method="post" modelAttribute="userFormDTO">
                <form:hidden path="available"/>
                <form:hidden path="role"/>
                    <div class="form-group form-group--inline" align="center">
                        <label>
                            <table>
                                <tr>
                                    <td align="right">Imię :</td>
                                    <td><form:input path="firstName" cssClass="form-control" id="firstName" value="${userFormDTO.firstName}"/><br>
                                        <form:errors path="firstName" cssClass="error_small" element="div" />
                                    </td>
                                </tr>
                                <tr>
                                    <td align="right">Nazwisko :</td>
                                    <td><form:input path="lastName" cssClass="form-control" id="lastName" value="${userFormDTO.lastName}"/><br>
                                        <form:errors path="lastName" cssClass="error_small" element="div" />
                                    </td>
                                </tr>
                                <tr>
                                    <td align="right">email :</td>
                                    <td><form:input path="email" cssClass="form-control" id="email" readonly="true" value="${userFormDTO.email}"/><br>
                                        <form:errors path="email" cssClass="error_small" element="div" />
                                    </td>
                                </tr>
                                <tr>
                                    <td align="right">Hasło :</td>
                                    <td><form:password path="password" cssClass="form-control" id="password"/><br>
                                        <form:errors path="password" cssClass="error_small" element="div"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td align="right">Powtórz hasło :</td>
                                    <td><form:password path="rePassword" cssClass="form-control" id="rePassword"/><br>
                                        <form:errors path="rePassword" cssClass="error_small" element="div" />
                                    </td>
                                </tr>
                            </table>
                        </label>
                    </div>
                    <div class="form-group form-group--inline">
                    <div class="form-group form-group--inline">
                        <button type="submit" class="btn btn-primary">Zmień dane użytkownika</button>
                    </div>
                </form:form>
            </h1>
        </div>
    </div>
</header>
<footer>

<jsp:include page="footer.jsp"/>

