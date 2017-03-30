<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8"%>
<div class="section-header">

    <!-- start: Container -->
    <div class="container">

        <h2>Создайте свой аккаунт</h2>

    </div>
    <!-- end: Container -->

</div>
<!-- end: Section Header -->

<!--start: Container -->
<div class="container">

    <!--start: Row-->
    <div class="row-fluid">

        <div class="lr-page span4 offset4">

            <!--start: Register Box-->
            <div id="register-box">

                <!-- start: Row -->
                <div class="row-fluid">

                    <div id="login-form" class="span12">

                        <h4 style="text-align: center">Введите данные для своего аккаунта</h4>

                        <form:form method="post" action="/registration" modelattribute="user" commandName="user">

                            <div class="row-fluid">

                                <form:input path="login" class="span12" id="user" type="text" value="" placeholder="login"/>

                                <input class="span12" id="pass" name="password" type="password" value="" placeholder="password"/>

                                <form:input path="password" class="span12" id="confpass" name="confpassword" type="password" value="" placeholder="confirm password"/>

                                <form:input path="name" class="span12" id="name" name="name" type="text" value="" placeholder="name"/>

                                <form:input path="email"  class="span12" id="email" name="email" type="text" value="" placeholder="email"/>

                                <form:input path="phone" class="span12" id="phone" name="phone" type="text" value="" placeholder="+7(XXX)-XXX-XX-XX"/>

                            </div>
                            <div class="actions">
                                <button type="submit" class="btn btn-large btn-success span12">Create Account!</button>
                            </div>
                        </form:form>

                    </div>

                </div>
                <!-- end: Row -->

            </div>
            <!--end: Register Box-->

        </div>

    </div>
    <!--end: Row -->

</div>
<!--end: Container-->