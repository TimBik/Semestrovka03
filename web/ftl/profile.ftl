<#ftl encoding="UTF-8"/>
<#import "base.ftl" as base/>
<#import "slideHeadMain.ftl" as slideHeadMain/>

<@base.head value="Profile"/>
<body>
<@slideHeadMain.slideHead/>
<hr>

<div class="container-fluid">
    <div class="row">
        <div class="col-xs-0 col-sm-1 col-md-2"></div>
        <div class="col-md-8">
            <span><h3>Профиль</h3></span>

            <div class="row">
                <div class="col-xs-4 col-sm-12 col-md-10 col-lg-4">
                    <div class="profile"><img src="../img/cook.jpg" style=""></div>
                    <hr>
                    <!--rating-->
<#--                    <ul class="rating">-->
<#--                        <li class="current" style="width: 0%;"><span class="star1" title="Плохо"></span></li>-->
<#--                        <li><span class="star2" title="Нормально"></span></li>-->
<#--                        <li><span class="star3" title="Средне"></span></li>-->
<#--                        <li><span class="star4" title="Хорошо"></span></li>-->
<#--                        <li><span class="star5" title="Отлично"></span></li>-->
<#--                    </ul>-->
<#--                    <hr>-->
                       <div class="text-center">
                        <button type="button" id="recBtn" class="btn btn-primary text-center" data-toggle="collapse"
                                data-target="#myRecipe" color="#0909FF">Мои рецепты
                        </button>
                    </div>
                    <div class="text-center">
                        <a href="addRecipe">
                            <button type="button" id="recBtn2" class="btn btn-primary text-center"
                                    data-toggle="collapse"
                                    data-target="#myRecipe" color="#0909FF">Добавить рецепт
                            </button>
                        </a>
                    </div>
                </div>
                <div class="col-xs-12 col-sm-12 col-md-10 col-lg-8">

                    <form method="post" action="/profile">
                        <div class="form-group">
                            <label for="inputUsername">Имя пользователя</label>
                            <h3>${name}</h3>
                        </div>
                        <div class="form-group">
                            <label for="inputEmail">Почта</label>
                            <h3>${email}</h3>
                        </div>
                        <div class="form-group">
                            <label for="example-date-input">Дата рождения</label>
                            <h3>${age}</h3>
                        </div>
                        <div class="form-group">
                            <label>О себе</label>
                            <h3>${info}</h3>
                        </div>
                        <hr>
                        <a href="profileSetings">
                            <input type="button" class="btn btn-primary" name="save"
                                   value="Настройки">
                        </a>
                    </form>

                </div>
            </div>
        </div>
    </div>
</div>

<div id="myRecipe" class="collapse">
    <div class="container-fluid padding">
        <div class="row text-center">
            <div class="col-sm-12 col-md-12">
                <@base.Recipes/>
            </div>
            <hr>
        </div>
    </div>
</div>
</div>

<figure>
    <div class="fixed-wrap">
        <div id="fixedpr"></div>
    </div>

</figure>

<@base.end/>
</body>