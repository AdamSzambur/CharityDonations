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
            Oddaj rzeczy, których już nie chcesz<br />
            <span class="uppercase">potrzebującym</span>
        </h1>

        <div class="slogan--steps">
            <div class="slogan--steps-title">Wystarczą 4 proste kroki:</div>
            <ul class="slogan--steps-boxes">
                <li>
                    <div><em>1</em><span>Wybierz rzeczy</span></div>
                </li>
                <li>
                    <div><em>2</em><span>Spakuj je w worki</span></div>
                </li>
                <li>
                    <div><em>3</em><span>Wybierz fundację</span></div>
                </li>
                <li>
                    <div><em>4</em><span>Zamów kuriera</span></div>
                </li>
            </ul>
        </div>
    </div>
</div>
</header>

<section class="form--steps">
    <div class="form--steps-instructions">
        <div class="form--steps-container">
            <h3>Ważne!</h3>
            <p data-step="1" class="active">
                Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy
                wiedzieć komu najlepiej je przekazać.
            </p>
            <p data-step="2">
                Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy
                wiedzieć komu najlepiej je przekazać.
            </p>
            <p data-step="3">
                Wybierz jedną, do
                której trafi Twoja przesyłka.
            </p>
            <p data-step="4">Podaj adres oraz termin odbioru rzeczy.</p>
        </div>
    </div>

    <div class="form--steps-container">
        <div class="form--steps-counter">Krok <span>1</span>/4</div>


<%--        <form:form modelAttribute="donation">--%>
<%--        <div data-step="1" class="active">--%>
<%--            <h3>Zaznacz co chcesz oddać:</h3>--%>

<%--            <c:forEach items="${categories}" var="category">--%>
<%--                <div class="form-group form-group--checkbox">--%>
<%--                    <label>--%>
<%--                        <form:checkbox path="categories" value="${category.name}"/>--%>
<%--&lt;%&ndash;                        <input type="checkbox" value="${category.name}" class="category">&ndash;%&gt;--%>
<%--                        <span class="checkbox"></span>--%>
<%--                        <span class="description">${category.name}</span>--%>
<%--                    </label>--%>
<%--                </div>--%>
<%--            </c:forEach>--%>
<%--            <span class="error"></span>--%>
<%--            <div class="form-group form-group--buttons">--%>
<%--                <button type="button" class="btn next-step">Dalej</button>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        </form:form>--%>


        <form:form modelAttribute="donation" method="post" enctype="multipart/form-data">
            <!-- STEP 1: class .active is switching steps -->
            <div data-step="1" class="active">
                <h3>Zaznacz co chcesz oddać:</h3>

                <c:forEach items="${categories}" var="category">
                <div class="form-group form-group--checkbox">
                    <label>
                        <form:checkbox path="categories" value="${category.id}" cssClass="category" data-name="${category.name}"/>
<%--                        <input type="checkbox" value="${category.name}" class="category">--%>
                        <span class="checkbox"></span>
                        <span class="description">${category.name}</span>
                    </label>
                </div>
                </c:forEach>
                <span class="error"></span>
                <div class="form-group form-group--buttons">
                    <button type="button" class="btn next-step">Dalej</button>
                </div>
            </div>

            <!-- STEP 2 -->
            <div data-step="2">
                <h3>Podaj liczbę 60l worków, w które spakowałeś/aś rzeczy:</h3>

                <div class="form-group form-group--inline">
                    <label>
                        Liczba 60l worków:
                        <form:input path="quantity" cssClass="quantity" type="number" step="1" min="1"/>
<%--                        <input type="number" name="quantity" step="1" min="1" class="quantity"/>--%>
                    </label>
                </div>
                <span class="error"></span>
                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step">Wstecz</button>
                    <button type="button" class="btn next-step">Dalej</button>
                </div>
            </div>



            <!-- STEP 3 -->
            <div data-step="3">
                <h3>Wybierz organizacje, której chcesz pomóc:</h3>

                <c:forEach items="${institutions}" var="institution">
                <div class="form-group form-group--checkbox">
                    <label>
                        <form:radiobutton path="institution" value="${institution.id}" cssClass="institution" data-name="${institution.name}"/>
<%--                        <input type="radio" name="institution" value="${institution.name}" class="institution"/>--%>
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
                    <button type="button" class="btn prev-step">Wstecz</button>
                    <button type="button" class="btn next-step">Dalej</button>
                </div>
            </div>

            <!-- STEP 4 -->
            <div data-step="4">
                <h3>Podaj adres oraz termin odbioru rzecz przez kuriera:</h3>

                <div class="form-section form-section--columns">
                    <div class="form-section--column">
                        <h4>Adres odbioru</h4>
                        <div class="form-group form-group--inline">
                            <label> Ulica
                                <form:input path="street" cssClass="street"/>
<%--                                <input type="text" name="address" class="street"/>--%>
                            </label><br>
                            <span class="error"></span>
                        </div>

                        <div class="form-group form-group--inline">

                            <label> Miasto
                                <form:input path="city" cssClass="city"/>
<%--                                <input type="text" name="city" class="city"/> --%>
                            </label><br>
                            <span class="error"></span>
                        </div>

                        <div class="form-group form-group--inline">
                            <label>Kod pocztowy
                                <form:input path="zipCode" cssClass="zipCode"/>
<%--                                <input type="text" name="postcode" class="zipCode"/>--%>
                            </label><br>
                            <span class="error"></span>
                        </div>

                        <div class="form-group form-group--inline">
                            <label>Numer telefonu
                                <form:input path="phone" cssClass="phone"/>
<%--                                <input type="phone" name="phone" class="phone"/>--%>
                            </label><br>
                            <span class="error"></span>
                        </div>
                    </div>

                    <div class="form-section--column">
                        <h4>Termin odbioru</h4>
                        <div class="form-group form-group--inline">

                            <label> Data
                                <form:input path="pickUpDate" cssClass="date" type="date" value="${actualDate}"/>
<%--                                <input type="date" name="data" class="date"/> --%>
                            </label><br>
                            <span class="error"></span>
                        </div>


                        <div class="form-group form-group--inline">
                            <label> Godzina
                                <form:input path="pickUpTime" cssClass="time" type="time"/>
<%--                                <input type="time" name="time" class="time"/> --%>
                            </label><br>
                            <span class="error"></span>
                        </div>


                        <div class="form-group form-group--inline">
                            <label>Uwagi dla kuriera
                                <form:textarea path="pickUpComment" cssClass="comment" rows="5"/>
<%--                                <textarea name="more_info" rows="5" class="comment"></textarea>--%>
                            </label><br>
                            <span class="error"></span>
                        </div>

                    </div>
                </div>
                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step">Wstecz</button>
                    <button type="button" class="btn next-step">Dalej</button>
                </div>
            </div>

            <!-- STEP 5 -->
            <div data-step="5">
                <h3>Podsumowanie Twojej darowizny</h3>

                <div class="summary">
                    <div class="form-section">
                        <h4>Oddajesz:</h4>
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
                            <h4>Adres odbioru:</h4>
                            <ul>
                                <li id="summaryStreet">Prosta 51</li>
                                <li id="summaryCity">Warszawa</li>
                                <li id="summaryZipCode">99-098</li>
                                <li id="summaryPhone">123 456 789</li>
                            </ul>
                        </div>

                        <div class="form-section--column">
                            <h4>Termin odbioru:</h4>
                            <ul>
                                <li id="summaryDate">13/12/2018</li>
                                <li id="summaryTime">15:40</li>
                                <li id="summaryComment">Brak uwag</li>
                            </ul>
                        </div>
                    </div>
                </div>

                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step">Wstecz</button>
                    <button type="submit" class="btn">Potwierdzam</button>
                </div>
            </div>
        </form:form>
    </div>
</section>

<jsp:include page="footer.jsp"/>
