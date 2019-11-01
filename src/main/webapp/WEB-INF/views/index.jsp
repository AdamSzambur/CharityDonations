<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:url var="mainURL" value="/"/>
<jsp:include page="header.jsp"/>

    <div class="slogan container container--90">
        <div class="slogan--item">
            <h1>
                <spring:message code="mainPage.startHelp"/>
            </h1>
        </div>
    </div>
</header>

<section id="stats" class="stats">
    <div class="container container--85">
        <div class="stats--item">
            <em>${sumOfQuantity}</em>
            <h3><spring:message code="mainPage.sacksNumber"/></h3>
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Eius est beatae, quod accusamus illum
                tempora!</p>
        </div>

        <div class="stats--item">
            <em>${sumDonatedInstitutions}</em>
            <h3><spring:message code="mainPage.supportedOrganizations"/></h3>
            <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Laboriosam magnam, sint nihil cupiditate quas
                quam.</p>
        </div>

    </div>
</section>

<section id="steps" class="steps">
    <h2><spring:message code="mainPage.fourSteps"/></h2>

    <div class="steps--container">
        <div class="steps--item">
            <span class="icon icon--hands"></span>
            <h3><spring:message code="mainPage.chooseThings"/></h3>
            <p><spring:message code="mainPage.chooseThings.desctiption"/></p>
        </div>
        <div class="steps--item">
            <span class="icon icon--arrow"></span>
            <h3><spring:message code="mainPage.pack"/></h3>
            <p><spring:message code="mainPage.pack.description"/></p>
        </div>
        <div class="steps--item">
            <span class="icon icon--glasses"></span>
            <h3><spring:message code="mainPage.whichHelp"/></h3>
            <p><spring:message code="mainPage.whichHelp.desctiption"/></p>
        </div>
        <div class="steps--item">
            <span class="icon icon--courier"></span>
            <h3><spring:message code="mainPage.curier"/></h3>
            <p><spring:message code="mainPage.curier.description"/></p>
        </div>
    </div>

    <a href="${mainURL}users/register" class="btn btn--large"><spring:message code="mainPage.button.signUp"/></a>
</section>

<section id="about-us" class="about-us">
    <div class="about-us--text">
        <h2><spring:message code="mainPage.aboutUs"/></h2>
        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Voluptas vitae animi rem pariatur incidunt libero
            optio esse quisquam illo omnis.</p>
        <img src="${mainURL}resources/images/signature.svg" class="about-us--text-signature" alt="Signature"/>
    </div>
    <div class="about-us--image"><img src="${mainURL}resources/images/about-us.jpg" alt="People in circle"/>
    </div>
</section>

<section id="help" class="help">
    <h2><spring:message code="mainPage.whichHelp"/></h2>

    <!-- SLIDE 1 -->
    <div class="help--slides active" data-id="1">
        <p><spring:message code="mainPage.whichHelp.desctiption"/></p>

        <ul class="help--slides-items">
            <c:forEach items="${institutions}" var="institution" varStatus="i">
            <c:if test="${(i.index+1)%2>0}"><li></c:if>
                <div class="col">
                    <div class="title">${institution.name}</div>
                    <div class="subtitle">${institution.description}</div>
                </div>
            <c:if test="${(i.index+1)%2==0}"><li></c:if>
            </c:forEach>
        </ul>
    </div>

</section>
<footer>
    <br><br><br>
    <div id="contact" class="contact">
        <h2><spring:message code="mainPage.contactForm.contactWithUs"/></h2>
        <h3><spring:message code="mainPage.contactForm.caption"/></h3>

        <form:form modelAttribute="messageDTO" method="post" cssClass="form--contact">
            <form:hidden path="email"/>
            <div class="form-group form-group--50">
                <form:input path="firstName" placeholder="${name}"/>
                <form:errors path="firstName" cssClass="error_small" element="div" />
            </div>
            <div class="form-group form-group--50">
                <form:input path="lastName" placeholder="${surname}"/>
                <form:errors path="lastName" cssClass="error_small" element="div" />
            </div>

            <div class="form-group">
                <form:textarea path="message" placeholder="${message}" rows="1"/>
                <form:errors path="message" cssClass="error_small" element="div" />
            </div>

            <button class="btn" type="submit"><spring:message code="mainPage.contactForm.button.send"/></button>
        </form:form>
        <br><br><br><br><br><br>
    </div>
    <div class="bottom-line">
        <span class="bottom-line--copy">Copyright &copy; 2018</span>
        <div class="bottom-line--icons">
            <a href="#" class="btn btn--small"><img src="${mainURL}resources/images/icon-facebook.svg"/></a>
            <a href="#" class="btn btn--small"><img src="${mainURL}resources/images/icon-instagram.svg"/></a>
        </div>
    </div>
</footer>
<jsp:include page="footer.jsp"/>

