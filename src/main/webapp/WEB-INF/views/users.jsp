<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:url value="/" var="mainURL"/>
<jsp:include page="header.jsp"/>

<section class="login-page">
    <h2><spring:message code="usersPage.headCaption"/></h2>
    <table class="table" style="font-size: 12px">
        <thead class="thead-dark">
        <tr>
            <th scope="col">#</th>
            <th scope="col"><spring:message code="usersPage.name"/></th>
            <th scope="col"><spring:message code="usersPage.surname"/></th>
            <th scope="col"><spring:message code="usersPage.email"/></th>
            <th scope="col"><spring:message code="usersPage.access"/></th>
            <th scope="col"><spring:message code="usersPage.active"/></th>
            <th scope="col"><spring:message code="usersPage.action"/></th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${users}" var="user" varStatus="i">
            <tr>
            <th scope="row">${i.count}</th>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.email}</td>
            <td>${user.role}</td>
            <td>${user.available}</td>
            <td>
                <div class="btn-group" role="group" aria-label="Basic example">
                    <a href="${mainURL}admin/users/edit?userId=${user.id}" class="btn btn--very-small btn--green"><spring:message code="usersPage.button.edit"/></a>
                    <a href="#" class="btn btn--very-small btn--red message-btn" data-id="${user.id}"><spring:message code="usersPage.button.delete"/></a>
                </div>
            </td>
            </tr>
        </c:forEach>
<%--            <tr>--%>
<%--                <td colspan="4">--%>
<%--                    <a href="${mainURL}admin/institutions/editAdd" class="btn btn--very-small btn--yellow">Dodaj nową instytucję</a>--%>
<%--                </td>--%>
<%--            </tr>--%>


        </tbody>
    </table>
</section>
</header>

<message>
    <div class="alert modal_alert invisible" id="messageBox">
        <button type="button" class="close" onclick="event.preventDefault(); $('#messageBox').toggleClass('invisible');">
            <span style="font-size: 14px">&times;</span>
        </button><br>
        <p style="text-align: center">
            <span class="messageValue justify-content-center" style="font-size: 14px"><spring:message code="usersPage.message.text"/></span><br>
        <form method="post" class="justify-content-center">
            <input type="hidden" value="" id="elementId" name="elementId">
            <button type="submit" role="button" class="btn btn--very-small btn--green"><spring:message code="usersPage.message.button.delete"/></button>&nbsp;
            <a role="button" class="btn btn--very-small btn--red" href="" onclick="event.preventDefault(); $('#messageBox').toggleClass('invisible');"><spring:message code="usersPage.message.button.cancel"/></a>
        </form>
        </p>
    </div>
</message>
<script src="<c:url value="${mainURL}resources/js/message.js"/>"></script>
<jsp:include page="footer.jsp"/>

