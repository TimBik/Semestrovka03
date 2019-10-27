<%--
  Created by IntelliJ IDEA.
  User: catch_you
  Date: 24.10.2019
  Time: 18:33
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
                    <a href="#" class="nav-link">Главная</a>
                </li>
                <li class="navbar-item">
                    <a href="#" class="nav-link">Профиль</a>
                </li>
                <li class="navbar-item">
                    <a href="#" class="nav-link">Избранное</a>
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
                <!--                    <button type="button" class="btn btn-warning btn-lg">Перейти к рецепту</button>-->
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
        <div class="carousel-item">
            <img src="../img/b3.jpg">
        </div>
        <div class="carousel-item">
            <img src="../img/b4.jpg">
        </div>
        <div class="carousel-item">
            <img src="../img/b5.jpg">
        </div>
        <div class="carousel-item">
            <img src="../img/b6.jpg">
        </div>
        <div class="carousel-item">
            <img src="../img/b7.jpg">
        </div>

    </div>

</div>
<!--основной блок-->
<div class="container-fluid">
    <div class="row jumbotron">
        <div class="col-xs-12 col-sm-12 col-md-9 col-lg-9 col-xl-10">
            <p class="lead">ПОШАГОВЫЙ РЕЦЕПТ ПРИГОТОВЛЕНИЯ</p>
            <p class="lead">Шаг 1:В миске слегка взбить венчиком яйца с сахаром и солью.</p>
            <p class="lead">Шаг 2: Добавить половину молока, перемешать.</p>
            <p class="lead">Шаг 3: Понемногу добавить муку, перемешивая до консистенции однородной густой сметаны..</p>
            <p class="lead">Шаг 4: Добавить остальное молоко и тщательно перемешать. Добавить масло, перемешать и оставить на 10-15 минут..</p>
            <p class="lead">Шаг 5: Нагреть чугунную сковороду, смазать растительным маслом и жарить блины с двух сторон. Выкладывать их стопкой, смазывая маленьким кусочком сливочного масла. Подавайте с вареньем и сметаной.</p>
        </div>
        <div class="col-xs-12 col-sm-12 col-md-3 col-lg-3 col-xl-2">
            <a href="#"><button class="btn btn-success btn-lg" type="button">Найти новый рецепт</button></a>
        </div>
    </div>

</div>
<!--блок с фикс изображением-->
<figure>
    <div class="fixed-wrap">
        <div id="fixed">

        </div>

    </div>

</figure>
<!--блок с характеристиками-->
<div class="container-fluid">
    <div class="row text-center alert">
        <div class="col-12">
            <h1 class="display-4">Приятного аппетита</h1>
        </div>
        <hr>
        <div class="col-12">
            <h1 class="lead">Надеемся вам все понравилось и вы вернетесь к нам за новыми рецептами</h1>
        </div>
    </div>

</div>
</body>
</html>