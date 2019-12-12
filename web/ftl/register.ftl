<#import "base.ftl" as base/>
<#import "slideHeadWelcome.ftl" as slideHeadWelcome/>

<!DOCTYPE html>
<html lang="en">
<@base.head value="Registration"/>
<body>
<!--шапка-->
<@slideHeadWelcome.slideHead/>

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