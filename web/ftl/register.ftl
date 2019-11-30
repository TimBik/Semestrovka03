<#import "base.ftl" as base/>
<!DOCTYPE html>
<html lang="en">
<@base.head value="Registration"/>
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
                    <a href="#" class="nav-link">Регистрация</a>
                </li>
                <li class="navbar-item">
                    <a href="#" class="nav-link">Войти</a>
                </li>
                <li class="navbar-item">
                    <a href="#" class="nav-link">Назад</a>
                </li>
            </ul>
        </div>

    </div>
</nav>
<div class="container-fluid">
    <br>
    <diw class="row">
        <div class="col"></div>
        <div class="col-md-3" align="center">
            <span><h1>Регистрация</h1></span>
            <!--            <span>And improve yourself</span>-->
            <br>
            <br>
            <br>
            <form method="post">
                <div class="form-group">
                    <label for="inputUsername">Username</label>
                    <input type="text" class="form-control" id="inputUsername" placeholder="Enter username"
                           name="username">
                </div>
                <div class="form-group">
                    <label for="inputEmail">Email address</label>
                    <input type="email" class="form-control" id="inputEmail" placeholder="Enter email" name="email">
                </div>
                <div class="form-group">
                    <label for="inputPassword">Password</label>
                    <input type="password" class="form-control" id="inputPassword" placeholder="Password"
                           name="password">
                </div>
                <div class="form-group">
                    <label for="example-date-input">Birth Date</label>
                    <input class="form-control" type="date" id="example-date-input" name="birthDate">
                </div>
                <br>
                <button input type="submit" class="btn btn-primary">Register</button>
            </form>
        </div>
        <div class="col"></div>
    </diw>
</div>
<br>
<!--    <footer id="sticky-footer" class="py-4 bg-dark text-white-50">-->
<!--        <div class="container text-center">-->
<!--            <small>Copyright &copy; Cook yourself</small>-->
<!--        </div>-->
<!--    </footer>-->
</body>
</html>