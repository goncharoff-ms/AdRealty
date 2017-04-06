<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8"%>

<div class="container mtb">
    <div class="row">
        <div class="col-lg-8">
            <h4>Просто введите свои данные</h4>
                <div class="hline"></div>
                <p>Используйте логин и пароль которые вы указывали при регистрации</p>
                <form role="form" action="/login" method="post">
                    <div class="form-group">
                        <label for="exampleInputEmail1">Login: </label>
                        <input type="text" name="login" class="form-control" id="exampleInputEmail1">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputEmail2">Password: </label>
                        <input type="password" name="password" class="form-control" id="exampleInputEmail2">
                    </div>
                    <button type="submit" class="btn btn-theme">Войти</button>
                </form>
        </div><! --/col-lg-8 -->
    </div><! --/row -->
    <div class="row"><a class="btn btn-primary btn-lg">Нет аккаунта?</a></div>
</div><! --/container -->

