<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8"%>
<!--end: Header-->
<!-- start: Section Header -->
<div class="section-header">
    <!-- start: Container -->
    <div class="container">
        <h2>Войдите в свой аккаунт</h2>
    </div>
    <!-- end: Container -->
</div>
<!-- end: Section Header -->
<!--start: Container -->
<div class="container">
    <!-- start: Login Box-->
    <div class="row-fluid">
        <div class="lr-page span4 offset4">
            <div id="login-box">
                <!-- start: Row -->
                <div class="row-fluid">
                    <div id="login-form" class="span12">
                        <h4 style="text-align: center">Используйте свой аккаунт</h4>
                        <!--
                        <div class="form-group ${error != null ? 'has-error' : ''}">
                            <span>${message}</span>
                            <input name="login" type="text" class="form-control" placeholder="Login"
                                   autofocus="true"/>
                            <input name="password" type="password" class="form-control" placeholder="Password"/>
                            <span>${error}</span>
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                            <button class="btn btn-lg btn-primary btn-block" type="submit">Войти</button>
                            <h4 class="text-center"><a href="${contextPath}/registration">Создать аккаунт</a></h4>
                        </div>
                        -->
                        <form method="post" action="${contextPath}/login">
                            <div class="row-fluid">
                                <input class="span12" id="login" name="login" type="text" value="" placeholder="login"/>
                                <input class="span12" id="password" name="password" type="password" value="" placeholder="password"/>
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            </div>
                            <div class="row-fluid">
                                <div class="remember">
                                    <input id="remember" name="remember" type="checkbox" value="1"/> Запомнить меня!
                                </div>
                                <div class="forgot">
                                    <a href="#">Забыли пароль?</a>
                                </div>
                            </div>
                            <div class="actions">
                                <button type="submit" class="btn btn-large btn-success span12">Войти!</button>
                            </div>
                        </form>
                    </div>
                </div>
                <!-- end: Row -->
            </div>
            <!-- end: Login Box  -->
        </div>
    </div>
</div>
<!--end: Container-->


