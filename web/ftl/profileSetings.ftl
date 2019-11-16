<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="ie-edge">
    <title>Profile</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="https://use.fontawesome.com/releases/v5.0.8/js/all.js"></script>
    <link rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="../css/rating.css">
    <meta charset="UTF-8">
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
                <li class="navbar-item">
                    <a href="#" class="nav-link">Главная</a>
                </li>
                <li class="navbar-item active">
                    <a href="#" class="nav-link">Профиль</a>
                </li>
                <li class="navbar-item">
                    <a href="#" class="nav-link">Избранное</a>
                </li>
                <li class="navbar-item">
                    <a href="#" class="nav-link">Чат</a>
                </li>
                <li class="navbar-item">
                    <a href="#" class="nav-link">Помощь</a>
                </li>
            </ul>
        </div>

    </div>
</nav>
<hr>

<div class="container-fluid">
    <div class="row">
        <div class="col-xs-0 col-sm-1 col-md-2"></div>
        <div class="col-md-8">
            <span><h3>Профиль</h3></span>
            <div class="row">
                <div class="col-xs-4 col-sm-12 col-md-10 col-lg-4">
                    <a href="#" class="profile"><img src="../img/cook.jpg" style=""></a>
                    <hr>
                    <!--rating-->
                    <ul class="rating">
                        <li class="current" style="width: 0%;"><span class="star1" title="Плохо"></span></li>
                        <li><span class="star2" title="Нормально"></span></li>
                        <li><span class="star3" title="Средне"></span></li>
                        <li><span class="star4" title="Хорошо"></span></li>
                        <li><span class="star5" title="Отлично"></span></li>
                    </ul>
                    <hr>
                    <div class="text-center">
                        <button type="button" id="recBtn" class="btn btn-primary text-center" data-toggle="collapse"
                                data-target="#myRecipe" color="#0909FF">Мои рецепты
                        </button>
                    </div>
                    <div class="text-center">
                        <button type="button" id="recBtn2" class="btn btn-primary text-center" data-toggle="collapse"
                                data-target="#myRecipe" color="#0909FF">Добавить рецепт
                        </button>
                    </div>
                </div>
                <div class="col-xs-12 col-sm-12 col-md-10 col-lg-8">

                    <form method="post">
                        <div class="form-group">
                            <label for="inputUsername">Имя пользователя</label>
                            <input type="text" class="form-control" id="inputUsername" placeholder="Enter username"
                                   name="username" value=${name}>
                        </div>
                        <div class="form-group">
                            <label for="inputEmail">Почта</label>
                            <input type="email" class="form-control" id="inputEmail" placeholder="Enter email"
                                   name="email" value=${email}>
                        </div>
                        <div class="form-group">
                            <label for="example-date-input">Дата рождения</label>
                            <input class="form-control" type="date" id="example-date-input" name="birthDate"
                                   value="${age}">
                        </div>
                        <div class="form-group">
                            <label for="example-date-input">О себе</label>
                            <input class="form-control" type="date" id="example-date-input" name="info"
                                   value="${info}">
                        </div>
                        <hr>
                        <input type="submit" class="btn btn-primary" name="saveSettings" value="Сохранить изменения">
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>


<!--Закрытая секция-->
<!--    <div class="text-center">-->
<!--        <button type="button" id="recBtn" class="btn btn-primary text-center" data-toggle="collapse"-->
<!--         data-target="#myRecipe" color="#0909FF">Мои рецепты</button>-->
<!--    </div>-->
<div id="myRecipe" class="collapse">
    <div class="container-fluid padding">
        <div class="row text-center">
            <div class="col-sm-12 col-md-12">
                <div class="carousel slide">
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <img src="../img/b1.jpg">
                            <div class="carousel-caption">
                                <h3 class="display-4">Домашние тонкие блинчики</h3>
                                <h4 class="display-8">ИНГРЕДИЕНТЫ:</h4>
                                <h6>3 яйца</h6>
                                <h6>1 ст. л. сахара</h6>
                                <h6>1 ч. л. соли</h6>
                                <h6>...</h6>

                                <button type="button" class="btn btn-outline-light btn-lg">Перейти к рецепту</button>
                            </div>
                        </div>
                    </div>
                </div>
                <hr>
                <div class="carousel slide">
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <img src="../img/b1.jpg">
                            <div class="carousel-caption">
                                <h3 class="display-4">Домашние тонкие блинчики</h3>
                                <h4 class="display-8">ИНГРЕДИЕНТЫ:</h4>
                                <h6>3 яйца</h6>
                                <h6>1 ст. л. сахара</h6>
                                <h6>1 ч. л. соли</h6>
                                <h6>...</h6>
                                <button type="button" class="btn btn-outline-light btn-lg">Перейти к рецепту</button>
                            </div>
                        </div>
                    </div>
                </div>
                <hr>
                <div class="carousel slide">
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <img src="../img/b1.jpg">
                            <div class="carousel-caption">
                                <h3 class="display-4">Домашние тонкие блинчики</h3>
                                <h4 class="display-8">ИНГРЕДИЕНТЫ:</h4>
                                <h6>3 яйца</h6>
                                <h6>1 ст. л. сахара</h6>
                                <h6>1 ч. л. соли</h6>
                                <h6>...</h6>
                                <button type="button" class="btn btn-outline-light btn-lg">Перейти к рецепту</button>
                            </div>
                        </div>
                    </div>
                </div>
                <hr>
            </div>

        </div>
    </div>
</div>
</div>

<figure>
    <div class="fixed-wrap">
        <div id="fixedpr">

        </div>

    </div>

</figure>
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