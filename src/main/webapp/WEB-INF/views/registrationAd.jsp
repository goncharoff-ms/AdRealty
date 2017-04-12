<%@ page session="false" language="java" contentType="text/html; charset=utf-8"
         isELIgnored="false" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<div class="container mtb">
    <div class="row">
        <div class="col-lg-8">
            <h4>Создание объявления</h4>
            <div class="hline"></div>
            <br>

            <form:form  role="form" action="/ad/new" method="post" modelAttribute="ad" enctype="multipart/form-data">
                <div class="form-group">
                    <label for="1">Название объявления: </label>
                    <form:input path="name" type="text" class="form-control" id="1"/>
                </div>
                <div class="form-group">
                    <label for="2">Выбирете тип недвижимости: </label>
                    <form:select path="realty" class="form-control" id="2">
                        <form:option value="КВАРТИРА">Квартира</form:option>
                        <form:option value="ЧАСТНЫЙ_ДОМ">Дом, дача, коттедж</form:option>
                        <form:option value="УЧАСТОК">Земельный участок</form:option>
                        <form:option value="КОММЕРЧЕСКАЯ_НЕДВИЖИМОСТЬ">Коммерческая неджвидимость</form:option>
                    </form:select>
                </div>

                <div class="form-group">
                    <label for="5">Выбирете тип объявления: </label>
                    <form:select path="typeAd" class="form-control" id="5">
                        <form:option value="ПРОДАЖА">Продам</form:option>
                        <form:option value="КУПЛЯ">Куплю</form:option>
                    </form:select>
                </div>


                <div class="form-group">
                    <label for="6">Город: </label>
                    <form:input path="sity" type="text" class="form-control" id="6"/>
                </div>


                <div id="streetBox" class="form-group">
                    <label for="7">Улица: </label>
                    <form:input path="street" type="text" class="form-control" id="7"/>
                </div>


                <div id="numberHouseBox" class="form-group">
                    <label for="8">Номер дома(квартира) :</label>
                    <form:input path="houseNumber" type="text" class="form-control" id="8"/>
                </div>

                <div class="form-group">
                    <label for="9">Площадь(кв.м) :</label>
                    <form:input path="sqare" type="text" class="form-control" id="9"/>
                </div>

                <div class="form-group">
                    <label for="3">Описание: </label>
                    <form:textarea path="info" class="form-control" id="3"/>
                </div>

                <div class="form-group">
                    <label for="4">Цена: </label>
                    <form:input path="price" type="text" class="form-control" id="4"/>
                </div>


                <div id="imageBox" class="form-group">
                    <label for="10">Фото: </label>
                    <input name="image" type="file" class="form-control btn btn-theme" id="10"/>
                </div>

                <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>

                <button type="submit" class="btn btn-theme">Создать</button>
            </form:form>
        </div>


    </div><! --/row -->
</div><! --/container -->

