<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8"%>

<div class="container mtb">
    <div class="row">
        <div class="col-lg-8">
            <h4>Создание нового аккаунта</h4>
                <div class="hline"></div>
                <br>
                <form:form role="form" action="/registration" method="post" modelAttribute="user" commandName="user">
                    <div class="form-group">
                        <label for="exampleInputEmail1">Логин: </label>
                        <form:input path="login" type="text" min="5" max="15" maxlength="15" class="form-control" id="exampleInputEmail1"/>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputEmail2">Пароль: </label>
                        <form:input path="password" type="password" class="form-control" id="exampleInputEmail2"/>
                    </div>

                    <div class="form-group">
                        <label for="exampleInputEmail1">Имя: </label>
                        <form:input path="name" type="text" class="form-control" id="exampleInputEmail1"/>
                    </div>

                    <div class="form-group">
                        <label for="exampleInputEmail1">Почта: </label>
                        <form:input path="email" type="email" class="form-control" id="exampleInputEmail1"/>
                    </div>

                    <div class="form-group">
                        <label for="exampleInputEmail1">Телефон: </label>
                        <form:input path="phone" type="tel" class="form-control" id="exampleInputEmail1"/>
                    </div>

                    <button type="submit" class="btn btn-theme">Создать</button>
                </form:form>
        </div>


    </div><! --/row -->
</div><! --/container -->

