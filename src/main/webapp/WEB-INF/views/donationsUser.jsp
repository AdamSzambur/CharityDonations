<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:url var="mainURL" value="/"/>
<jsp:include page="header.jsp"/>

<section class="login-page">
    <h2><spring:message code="donationsPage.headCaption"/></h2>
    <table class="table" style="font-size: 12px">
        <thead class="thead-dark">
        <tr>
            <th scope="col">#</th>
            <th scope="col"><spring:message code="donationsPage.dateCreated"/> </th>
            <th scope="col"><spring:message code="donationsPage.institutionName"/></th>
            <th scope="col"><spring:message code="donationsPage.quantity"/></th>
            <th scope="col"><spring:message code="donationsPage.pickupDatePlanned"/></th>
            <th scope="col"><spring:message code="donationsPage.pickupDate"/></th>
            <th scope="col"><spring:message code="donationsPage.status"/></th>
            <th scope="col"><spring:message code="donationsPage.action"/></th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${donations}" var="donation" varStatus="i">
            <tr <c:if test="${donation.status.equals('odebrane')}"> class="table-success"</c:if>>
            <th scope="row">${i.count}</th>
            <td>${donation.created.format(formater)}</td>
            <td>${donation.institution.name}</td>
            <td>${donation.quantity}</td>
            <td>${donation.plannedPickUpDate}</td>
            <td>${donation.pickUpDate}</td>
            <td>${donation.status}</td>
            <td>
                <div class="btn-group" role="group" aria-label="Basic example">
                    <a href="${mainURL}users/donations/details?donationId=${donation.id}" class="btn btn--very-small btn--green"><spring:message code="donationsPage.button"/></a>
                </div>
            </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</section>
</header>
<jsp:include page="footer.jsp"/>

