<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:url value="/" var="mainURL"/>
<jsp:include page="header.jsp"/>

<section class="login-page">
    <h2>List wszystkich instytucji</h2>
    <table class="table" style="font-size: 12px">
        <thead class="thead-dark">
        <tr>
            <th scope="col">#</th>
            <th scope="col">Nazwa instytucji</th>
            <th scope="col">Opis instytucji</th>
            <th scope="col">Akcja</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${institutions}" var="institution" varStatus="i">
            <tr>
            <th scope="row">${i.count}</th>
            <td>${institution.name}</td>
            <td>${institution.description}</td>
            <td>
                <div class="btn-group" role="group" aria-label="Basic example">
                    <a href="${mainURL}admin/institutions/editAdd?institutionId=${institution.id}" class="btn btn--very-small btn--green">Edytuj</a>
                    <a href="#" class="btn btn--very-small btn--red message-btn" data-id="${institution.id}">Usuń</a>
                </div>
            </td>
            </tr>
        </c:forEach>
            <tr>
                <td colspan="4">
                    <a href="${mainURL}admin/institutions/editAdd" class="btn btn--very-small btn--yellow">Dodaj nową instytucję</a>
                </td>
            </tr>


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
            <span class="messageValue justify-content-center" style="font-size: 14px">Czy napewno chcesz usunąć instytucję z listy ?<br>Usuwając instytucję, usuwasz również<br>dary do niej przypisane.</span><br>
        <form method="post" class="justify-content-center">
            <input type="hidden" value="" id="elementId" name="elementId">
            <button type="submit" role="button" class="btn btn--very-small btn--green">Usuń instytucję</button>&nbsp;
            <a role="button" class="btn btn--very-small btn--red" href="" onclick="event.preventDefault(); $('#messageBox').toggleClass('invisible');">Anuluj</a>
        </form>
        </p>
    </div>
</message>
<script src="<c:url value="${mainURL}resources/js/message.js"/>"></script>
<jsp:include page="footer.jsp"/>

