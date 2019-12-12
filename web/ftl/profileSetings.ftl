<#import "base.ftl" as base/>
<#import "slideHeadMain.ftl" as slideHeadMain/>

<!DOCTYPE html>
<html lang="en">
<@base.head value="Setings"/>
<body>
<!--шапка-->
<@slideHeadMain.slideHead/>
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
                            <input class="form-control" type="text"  name="info"
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
<figure>
    <div class="fixed-wrap">
        <div id="fixedpr">

        </div>

    </div>

</figure>
<!--футер-->
<@end/>


</body>
</html>