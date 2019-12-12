<#import "base.ftl" as base/>
<#import "slideHeadMain.ftl" as slideHeadMain/>

<!DOCTYPE html>
<html lang="en">
<@base.head value="Recipe"/>

<body>
<!--шапка-->
<@slideHeadMain.slideHead/>
<!--карусель фотографий-->
<@base.Recipes/>

<!--rating-->
<!--<ul class="rating">-->
<!--    <li class="current" style="width: 20%;"><span class="star1" title="Плохо"></span></li>-->
<!--    <li><span class="star2" title="Нормально"></span></li>-->
<!--    <li><span class="star3" title="Средне"></span></li>-->
<!--    <li><span class="star4" title="Хорошо"></span></li>-->
<!--    <li><span class="star5" title="Отлично"></span></li>-->
<!--</ul>-->

<!--основной блок-->
<div class="container-fluid">
    <div class="row jumbotron">
        <ul class="carousel-indicators">
            <li data-target="#slides" data-slide-to="0"></li>
            <li data-target="#slides" data-slide-to="1"></li>
            <li data-target="#slides" data-slide-to="2"></li>
            <li data-target="#slides" data-slide-to="3"></li>
            <li data-target="#slides" data-slide-to="4"></li>
            <li data-target="#slides" data-slide-to="5"></li>
            <li data-target="#slides" data-slide-to="6"></li>
        </ul>

        <div class="col-xs-12 col-sm-12 col-md-9 col-lg-9 col-xl-10">
            <#if ingredients??>
                <p class="lead">ИНГРЕДИЕНТЫ</p>
                <#list ingredients as ingredient>
                    <p class="lead">${ingredient.name} ${ingredient.amount}</p>
                </#list>
            </#if>
            <#if steps??>
                <p class="lead">ПОШАГОВЫЙ РЕЦЕПТ ПРИГОТОВЛЕНИЯ</p>
                <#list steps as step>
                    <p class="lead">${step.text}</p>
                </#list>
            </#if>
        </div>
        <div class="col-xs-12 col-sm-12 col-md-3 col-lg-3 col-xl-2">
            <a href="#">
                <#if id??>
                    <script type="text/javascript">
                        document.write('<input type="button" onclick="vote(${id},\'${recipe.id}\')" class="btn btn-success btn-success btn-lg" value="Добавить в избранное"/>');
                        document.write('<div id="vote_status"></div>');
                    </script>
                </#if>
            </a>
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

    <!--футер-->
    <@base.end/>
</div>
</body>
</html>