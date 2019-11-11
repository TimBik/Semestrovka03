<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="ie-edge">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="https://use.fontawesome.com/releases/v5.0.8/js/all.js"></script>
    <link rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="../css/lr.css">
    <title>Login</title>
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
                    <a href="#" class="nav-link">Регистрация</a>
                </li>
                <li class="navbar-item active">
                    <a href="#" class="nav-link">Войти</a>
                </li>
                <li class="navbar-item">
                    <a href="#" class="nav-link">Назад</a>
                </li>
            </ul>
        </div>

    </div>
</nav>


<div class="panel panel-default container-fluid">
    <br>
    <diw class="row">
        <div class="col"></div>
        <div class="col-md-3" align="center">
            <span><h1>Login</h1></span>
            <span>And improve yourself</span>
            <br>
            <br>
            <br>
            <form method="post">
                <div class="form-group">
                    <label for="exampleInputEmail1">Email address</label>
                    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email" name="email">
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">Password</label>
                    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" name="password">
                </div>
                <div class="form-group form-check">
                    <input type="checkbox" class="form-check-input" id="exampleCheck1" name="rememberMe">
                    <label class="form-check-label" for="exampleCheck1">Check me out</label>
                </div>
                <button input type="submit" class="btn btn-primary">Login</button>
            </form>
        </div>
        <div class="col"></div>
    </diw>
</div>
<br>
<!--<footer id="sticky-footer" class="py-4 bg-dark text-white-50">-->
<!--    <div class="container text-center">-->
<!--        <small>Copyright &copy; Cook yourself</small>-->
<!--    </div>-->
<!--</footer>-->
</body>
</html>