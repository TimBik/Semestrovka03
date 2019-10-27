<%--
  Created by IntelliJ IDEA.
  User: catch_you
  Date: 24.10.2019
  Time: 17:59
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
</head>
<body>
<!--шапка-->
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
                    <a href="main" class="nav-link">Главная</a>
                </li>
                <li class="navbar-item">
                    <a href="profile" class="nav-link">Профиль</a>
                </li>
                <li class="navbar-item">
                    <a href="#" class="nav-link">Избранное</a>
                </li>
                <li class="navbar-item">
                    <a href="#" class="nav-link">Мои рецепты</a>
                </li>
                <li class="navbar-item">
                    <a href="#" class="nav-link">Форум</a>
                </li>
                <li class="navbar-item">
                    <a href="#" class="nav-link">Помощь</a>
                </li>
            </ul>
        </div>

    </div>
</nav>

<!--поиск-->
<form class="d1" >
    <input type="text" placeholder="Искать здесь...">
    <button type="submit"></button>
</form>

<!--карусель фотографий-->
<div class="carousel slide" data-ride="carousel" id="slides1">
    <ul class="carousel-indicators">
        <li data-target="#slides1" data-slide-to="0"></li>
        <li data-target="#slides1" data-slide-to="1"></li>
        <li data-target="#slides1" data-slide-to="2"></li>
        <li data-target="#slides1" data-slide-to="3"></li>
        <li data-target="#slides1" data-slide-to="4"></li>
        <li data-target="#slides1" data-slide-to="5"></li>
        <li data-target="#slides1" data-slide-to="6"></li>
    </ul>
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img src="../img/b1.jpg">
            <div class="carousel-caption">
                <h1 class="display-4">Домашние тонкие блинчики</h1>
                <button type="button" class="btn btn-outline-light btn-lg">Добавить в избранное</button>
                <button type="button" class="btn btn-warning btn-lg">Перейти к рецепту</button>
            </div>
        </div>
        <div class="carousel-item">
            <img src="../img/b2.jpg">
            <div class="carousel-caption">
                <h1 class="display-4">ИНГРЕДИЕНТЫ</h1>
                <h6>3 яйца</h6>
                <h6>1 ст. л. сахара</h6>
                <h6>1 ч. л. соли</h6>
                <h6>500 мл молока</h6>
                <h6>280 г муки</h6>
                <h6>3 ст. л. растительного масла плюс для жарки</h6>
                <h6>сливочное масло, сметана, варенье для подачи</h6>
            </div>
        </div>

    </div>

</div>
<hr>
<!--карусель фотографий-->
<div class="carousel slide" data-ride="carousel" id="slides">
    <ul class="carousel-indicators">
        <li data-target="#slides" data-slide-to="0"></li>
        <li data-target="#slides" data-slide-to="1"></li>
        <li data-target="#slides" data-slide-to="2"></li>
        <li data-target="#slides" data-slide-to="3"></li>
        <li data-target="#slides" data-slide-to="4"></li>
        <li data-target="#slides" data-slide-to="5"></li>
        <li data-target="#slides" data-slide-to="6"></li>
    </ul>
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img src="../img/b1.jpg">
            <div class="carousel-caption">
                <h1 class="display-4">Домашние тонкие блинчики</h1>
                <button type="button" class="btn btn-outline-light btn-lg">Добавить в избранное</button>
                <button type="button" class="btn btn-warning btn-lg">Перейти к рецепту</button>
            </div>
        </div>
        <div class="carousel-item">
            <img src="../img/b2.jpg">
            <div class="carousel-caption">
                <h1 class="display-4">ИНГРЕДИЕНТЫ</h1>
                <h6>3 яйца</h6>
                <h6>1 ст. л. сахара</h6>
                <h6>1 ч. л. соли</h6>
                <h6>500 мл молока</h6>
                <h6>280 г муки</h6>
                <h6>3 ст. л. растительного масла плюс для жарки</h6>
                <h6>сливочное масло, сметана, варенье для подачи</h6>
            </div>
        </div>

    </div>

</div>
<!--основной блок-->

<!--блок с характеристиками-->
<div class="container-fluid">
    <div class="row text-center alert">
        <div class="col-12">
            <h1 class="display-4">Если вам не удалось найти желаемый рецепт, напишите нам!</h1>
        </div>
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
<!--футер-->
<footer class="container-fluid">
    <div class="container-fluid">
        <div class="row padding text-center">
            <div class="col-12">
                <h2>Наши контакты</h2>
            </div>
            <div class="col-12 social padding">
                <a href="#"><i class="fab fa-instagram"></i></a>
                <a href="#"><i class="fab fa-facebook"></i></a>
                <a href="#"><i class="fab fa-google-plus-g"></i></a>
                <a href="#"><i class="fab fa-whatsapp"></i></a>
                <a href="#"><i class="fab fa-vk"></i></a>
            </div>
        </div>
    </div>
</footer>


</body>
</html>