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
            <spring:message code="donationAddPage.headCaption"/>
        </h1>

        <div class="slogan--steps">
            <div class="slogan--steps-title"><spring:message code="donationAddPage.headCaption2"/></div>
            <ul class="slogan--steps-boxes">
                <li>
                    <div><em>1</em><span><spring:message code="donationAddPage.headCaption2_1"/></span></div>
                </li>
                <li>
                    <div><em>2</em><span><spring:message code="donationAddPage.headCaption2_2"/></span></div>
                </li>
                <li>
                    <div><em>3</em><span><spring:message code="donationAddPage.headCaption2_3"/></span></div>
                </li>
                <li>
                    <div><em>4</em><span><spring:message code="donationAddPage.headCaption2_4"/></span></div>
                </li>
            </ul>
        </div>
    </div>
</div>
</header>

<section class="form--steps">
    <div class="form--steps-instructions">
        <div class="form--steps-container">
            <h3><spring:message code="donationAddPage.important"/></h3>
            <p data-step="1" class="active">
                <spring:message code="donationAddPage.step1.caption"/>
            </p>
            <p data-step="2">
                <spring:message code="donationAddPage.step2.caption"/>
            </p>
            <p data-step="3">
                <spring:message code="donationAddPage.step3.caption"/>
            </p>
            <p data-step="4"><spring:message code="donationAddPage.step4.caption"/></p>
        </div>
    </div>

    <div class="form--steps-container">
        <div class="form--steps-counter"><spring:message code="donationAddPage.step"/> <span>1</span>/4</div>

        <form:form modelAttribute="donation" method="post" enctype="multipart/form-data">
            <form:hidden path="user"/>
            <!-- STEP 1: class .active is switching steps -->
            <div data-step="1" class="active">
                <h3><spring:message code="donationAddPage.step1.caption2"/></h3>

                <c:forEach items="${categories}" var="category">
                <div class="form-group form-group--checkbox">
                    <label>
                        <form:checkbox path="categories" value="${category.id}" cssClass="category" data-name="${category.name}"/>
                        <span class="checkbox"></span>
                        <span class="description">${category.name}</span>
                    </label>
                </div>
                </c:forEach>
                <span class="error"></span>
                <div class="form-group form-group--buttons">
                    <button type="button" class="btn next-step"><spring:message code="donationAddPage.button.next"/></button>
                </div>
            </div>

            <!-- STEP 2 -->
            <div data-step="2">
                <h3><spring:message code="donationAddPage.step2.caption2"/></h3>

                <div class="form-group form-group--inline">
                    <label>
                        <spring:message code="donationAddPage.step2.input"/>
                        <form:input path="quantity" cssClass="quantity" type="number" step="1" min="1"/>
                    </label>
                </div>
                <span class="error"></span>
                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step"><spring:message code="donationAddPage.button.previous"/></button>
                    <button type="button" class="btn next-step"><spring:message code="donationAddPage.button.next"/></button>
                </div>
            </div>



            <!-- STEP 3 -->
            <div data-step="3">
                <h3><spring:message code="donationAddPage.step3.caption2"/></h3>

                <c:forEach items="${institutions}" var="institution">
                <div class="form-group form-group--checkbox">
                    <label>
                        <form:radiobutton path="institution" value="${institution.id}" cssClass="institution" data-name="${institution.name}"/>
                        <span class="checkbox radio"></span>
                        <span class="description">
                  <div class="title">${institution.name}</div>
                  <div class="subtitle">
                    ${institution.description}
                  </div>
                </span>
                    </label>
                </div>
                </c:forEach>
                <span class="error"></span>
                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step"><spring:message code="donationAddPage.button.previous"/></button>
                    <button type="button" class="btn next-step"><spring:message code="donationAddPage.button.next"/></button>
                </div>
            </div>

            <!-- STEP 4 -->
            <div data-step="4">
                <h3><spring:message code="donationAddPage.step4.caption2"/></h3>

                <div class="form-section form-section--columns">
                    <div class="form-section--column">
                        <h4><spring:message code="donationAddPage.address"/></h4>
                        <div class="form-group form-group--inline">
                            <label> <spring:message code="donationAddPage.street"/>
                                <form:input path="street" cssClass="street"/>
                            </label><br>
                            <span class="error"></span>
                        </div>

                        <div class="form-group form-group--inline">

                            <label> <spring:message code="donationAddPage.city"/>
                                <form:input path="city" cssClass="city"/>
                            </label><br>
                            <span class="error"></span>
                        </div>

                        <div class="form-group form-group--inline">
                            <label><spring:message code="donationAddPage.zipCode"/>
                                <form:input path="zipCode" cssClass="zipCode"/>
                            </label><br>
                            <span class="error"></span>
                        </div>

                        <div class="form-group form-group--inline">
                            <label><spring:message code="donationAddPage.phone"/>
                                <form:input path="phone" cssClass="phone"/>
                            </label><br>
                            <span class="error"></span>
                        </div>
                    </div>

                    <div class="form-section--column">
                        <h4><spring:message code="donationAddPage.dateTime"/></h4>
                        <div class="form-group form-group--inline">

                            <label> <spring:message code="donationAddPage.date"/>
                                <form:input path="plannedPickUpDate" cssClass="date" type="date" value="${actualDate}"/>
                            </label><br>
                            <span class="error"></span>
                        </div>


                        <div class="form-group form-group--inline">
                            <label> <spring:message code="donationAddPage.hour"/>
                                <form:input path="pickUpTime" cssClass="time" type="time"/>
                            </label><br>
                            <span class="error"></span>
                        </div>


                        <div class="form-group form-group--inline">
                            <label><spring:message code="donationAddPage.info"/>
                                <form:textarea path="pickUpComment" cssClass="comment" rows="5"/>
                            </label><br>
                            <span class="error"></span>
                        </div>

                    </div>
                </div>
                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step"><spring:message code="donationAddPage.button.previous"/></button>
                    <button type="button" class="btn next-step"><spring:message code="donationAddPage.button.next"/></button>
                </div>
            </div>

            <!-- STEP 5 -->
            <div data-step="5">
                <h3><spring:message code="donationAddPage.summary.caption"/></h3>

                <div class="summary">
                    <div class="form-section">
                        <h4><spring:message code="donationAddPage.summary.youGive"/></h4>
                        <ul>
                            <li>
                                <span class="icon icon-bag"></span>
                                <span class="summary--text" id="summaryQuantityAndCategories">4 worki ubrań w dobrym stanie dla dzieci</span>
                            </li>

                            <li>
                                <span class="icon icon-hand"></span>
                                <span class="summary--text" id="summaryInstitution">Dla fundacji "Mam marzenie" w Warszawie</span>
                            </li>
                        </ul>
                    </div>

                    <div class="form-section form-section--columns">
                        <div class="form-section--column">
                            <h4><spring:message code="donationAddPage.summary.address"/></h4>
                            <ul>
                                <li id="summaryStreet">Prosta 51</li>
                                <li id="summaryCity">Warszawa</li>
                                <li id="summaryZipCode">99-098</li>
                                <li id="summaryPhone">123 456 789</li>
                            </ul>
                        </div>

                        <div class="form-section--column">
                            <h4><spring:message code="donationAddPage.summary.date"/></h4>
                            <ul>
                                <li id="summaryDate">13/12/2018</li>
                                <li id="summaryTime">15:40</li>
                                <li id="summaryComment">Brak uwag</li>
                            </ul>
                        </div>
                    </div>
                </div>

                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step"><spring:message code="donationAddPage.button.previous"/></button>
                    <button type="submit" class="btn"><spring:message code="donationAddPage.button.accept"/></button>
                </div>
            </div>
        </form:form>
    </div>
</section>
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
