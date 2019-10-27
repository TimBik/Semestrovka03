<%--
  Created by IntelliJ IDEA.
  User: catch_you
  Date: 20.10.2019
  Time: 1:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="ie-edge">
    <title>Menu</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="https://use.fontawesome.com/releases/v5.0.8/js/all.js"></script>
    <link rel="stylesheet" href="../css/style.css">
    <title>Welcome</title>
</head>
<body>
<nav class="navbar navbar-expand-md navbar-light bg-light sticky-top">
    <div class="container-fluid">
        <a href="#" class="navbar-brad"><img src="../img/LOGO.png"></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse"
                data-target="#navbarResponsive">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="navbar-item active">
                    <a href="#" class="nav-link">Войти</a>
                </li>
                <li class="navbar-item">
                    <a href="#" class="nav-link">Зарегистрироваться</a>
                </li>
            </ul>
        </div>

    </div>
</nav>

<!--карусель фотографий-->
<div class="carousel slide" data-ride="carousel" id="slides">
    <ul class="carousel-indicators">
        <li data-target="#slides" data-slide-to="0"></li>
        <li data-target="#slides" data-slide-to="1"></li>
        <li data-target="#slides" data-slide-to="2"></li>
    </ul>
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img src="../img/b1.jpg">
            <div class="carousel-caption">
                <h1 class="display-4">Cook Yourself</h1>
                <form action="${pageContext.request.contextPath}/login" method="get">
                    <button input type="submit" class="btn btn-outline-light btn-lg">Войти</button>
                </form>
                <form action="${pageContext.request.contextPath}/register" method="get">
                    <button input type="submit" class="btn btn-warning btn-lg">Зарегстрироваться</button>
                </form>
            </div>
        </div>
        <div class="carousel-item">
            <img src="../img/b9.jpg">
            <div class="carousel-caption">
                <h1 class="display-4">Cook Yourself</h1>
                <form action="/login">
                    <button type="button" class="btn btn-outline-light btn-lg">Войти</button>
                </form>
                <button type="button" class="btn btn-warning btn-lg">Зарегстрироваться</button>
            </div>
        </div>
        <div class="carousel-item">
            <img src="../img/b8.jpg">
            <div class="carousel-caption">
                <h1 class="display-4">Cook Yourself</h1>
                <button type="button" class="btn btn-outline-light btn-lg">Войти</button>
                <button type="button" class="btn btn-warning btn-lg">Зарегстрироваться</button>
            </div>
        </div>


    </div>

</div>

<!--основной блок-->
<div class="container-fluid">
    <div class="row jumbotron">
        <div class="col-xs-12 col-sm-12 col-md-9 col-lg-9 col-xl-10">
            <p class="lead">Всегда мечтали готовить самостоятельно, но не знаете, как к этому приготовиться?</p>
            <p class="lead">Что ж настало время попробовать, что-то новое.</p>
            <p class="lead">Мы уверены, что у нас вы найдете, чтобы приготовить</p>

        </div>
        <div class="col-xs-12 col-sm-12 col-md-3 col-lg-3 col-xl-2">
            <a href="#"><button class="btn btn-success btn-lg" type="button">Зарегистрироваться</button></a>
        </div>
    </div>

</div>
<!--блок с характеристиками-->
<div class="container-fluid">
    <div class="row text-center alert">
        <div class="col-12">
            <h1 class="display-4">Надеемся вам понравится и вы вернетесь к нам за новыми рецептами</h1>
        </div>
        <hr>
        <div class="col-12">
            <h1 class="lead">Приятного аппетита!</h1>
            <h1 class="lead">Bon Appetit!</h1>
            <h1 class="lead">Buon appetito!</h1>
            <h1 class="lead">Bon appétit!</h1>
            <h1 class="lead">祝您好胃口！</h1>
        </div>
    </div>

    <!--блок с описанием языков-->
    <div class="container-fluid padding">
        <div class="row text-center padding">
            <div class="col-xs-12 col-sm-6 col-md-4">
                <i class="fas fa-code"></i>
                <h3>HTML5</h3>
            </div>
            <div class="col-xs-12 col-sm-6 col-md-4">
                <i class="fas fa-bold"></i>
                <h3>Bootstrap</h3>
            </div>
            <div class="col-xs-12 col-sm-6 col-md-4">
                <i class="fab fa-css3"></i>
                <h3>CSS3</h3>
            </div>
        </div>
        <hr>
    </div>
</div>
</body>
</html>