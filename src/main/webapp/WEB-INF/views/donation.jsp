<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:url value="/" var="mainURL"/>
<jsp:include page="header.jsp"/>

<section class="login-page">


    <h2><spring:message code="donationPage.headCaption"/></h2>
    <br>
    <div class="container" style="font-size: 14px">

        <div class="row justify-content-md-center">
            <div class="col col-lg-6 p-3 border-bottom" style="text-align: right">
                <b><h3><spring:message code="donationPage.youGave"/> :</h3></b>
            </div>
        </div>
        <br>
        <div class="row justify-content-md-center">
            <div class="col col-lg-3 p-3" style="text-align: right">
                <spring:message code="donationPage.quantityBags"/> &nbsp;&nbsp;<i class="fas fa-luggage-cart"></i>
            </div>
            <div class="col col-lg-3 p-3">
                ${donation.quantity}
            </div>
        </div>
        <div class="row justify-content-md-center">
            <div class="col col-lg-3 p-3" style="text-align: right">
                <spring:message code="donationPage.institution"/> &nbsp;&nbsp;<i class="fas fa-university"></i>
            </div>
            <div class="col col-lg-3 p-3">
                ${donation.institution.name}
            </div>
        </div>
        <div class="row justify-content-md-center">
            <div class="col col-lg-3 p-3" style="text-align: right">
                <spring:message code="donationPage.kindOfDonation"/> &nbsp;&nbsp;<i class="fas fa-tshirt"></i>
            </div>
            <div class="col col-lg-3 p-3">
                <c:forEach items="${donation.categories}" var="category">
                    ${category.name}<br>
                </c:forEach>
            </div>
        </div>
        <br>
        <div class="row justify-content-md-center">
            <div class="col col-lg-6 p-3 border-bottom" style="text-align: right">
                <b><h3><spring:message code="donationPage.addressDateTime"/> :</h3></b>
            </div>
        </div>
        <div class="row justify-content-md-center">
            <div class="col col-lg-3 p-3" style="text-align: right">
                <spring:message code="donationPage.address"/>
            </div>
            <div class="col col-lg-3 p-3">
                ${donation.street}, ${donation.zipCode} ${donation.city}
            </div>
        </div>
        <div class="row justify-content-md-center">
            <div class="col col-lg-3 p-3" style="text-align: right">
                <spring:message code="donationPage.dateAndTime"/>
            </div>
            <div class="col col-lg-3 p-3">
                ${donation.plannedPickUpDate.format(formater)}, godz : ${donation.pickUpTime}
            </div>
        </div>
        <div class="row justify-content-md-center">
            <div class="col col-lg-3 p-3" style="text-align: right">
                <spring:message code="donationPage.phoneNumber"/>
            </div>
            <div class="col col-lg-3 p-3">
                ${donation.phone}
            </div>
        </div>
        <div class="row justify-content-md-center">
            <div class="col col-lg-3 p-3" style="text-align: right">
                <spring:message code="donationPage.info"/>
            </div>
            <div class="col col-lg-3 p-3">
                ${donation.pickUpComment}
            </div>
        </div>
        <div class="row justify-content-md-center">
            <div class="col col-lg-6 p-3 border-bottom" style="text-align: right">
                <b><h3><spring:message code="donationPage.statusAndDate"/> :</h3></b>
            </div>
        </div>
        <div class="row justify-content-md-center">
            <div class="col col-lg-3 p-3" style="text-align: right">
                <spring:message code="donationsPage.status"/>
            </div>
            <div class="col col-lg-3 p-3">
                ${donation.status}
                    <c:if test="${donation.status.equals('nieodebrane')}">
                    <br><br>
                    <a href="#" class="btn btn--very-small btn--yellow message-btn" data-id="${donation.id}"><spring:message code="donationPage.button.Status"/></a>
                    </c:if>
            </div>
        </div>
        <c:if test="${donation.pickUpDate!=null}">
        <div class="row justify-content-md-center">
            <div class="col col-lg-3 p-3" style="text-align: right">
                <spring:message code="donationsPage.pickupDate"/>
            </div>
            <div class="col col-lg-3 p-3">
                ${donation.pickUpDate}
            </div>
        </div>
        </c:if>
    </div>


</section>
<message>
    <div class="alert modal_alert invisible" id="messageBox">
        <button type="button" class="close" onclick="event.preventDefault(); $('#messageBox').toggleClass('invisible');">
            <span style="font-size: 14px">&times;</span>
        </button><br>
        <p style="text-align: center">
            <span class="messageValue justify-content-center" style="font-size: 14px"><spring:message code="donationPage.message.text"/></span><br>
        <form method="post" class="justify-content-center">
            <input type="hidden" value="" id="elementId" name="elementId">
            <button type="submit" role="button" class="btn btn--very-small btn--green"><spring:message code="donationPage.message.button.ok"/></button>&nbsp;
            <a role="button" class="btn btn--very-small btn--red" href="" onclick="event.preventDefault(); $('#messageBox').toggleClass('invisible');"><spring:message code="donationPage.message.button.cancel"/></a>
        </form>
        </p>
    </div>
</message>

</header>
<script src="<c:url value="${mainURL}resources/js/message.js"/>"></script>
<jsp:include page="footer.jsp"/>

