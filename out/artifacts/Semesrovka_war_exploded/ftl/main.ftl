<#ftl encoding="UTF-8"/>
<#import "base.ftl" as base/>
<#import "slideHeadMain.ftl" as slideHeadMain/>
<#import "headWelcome.ftl" as headWelcome/>
<!DOCTYPE html>
<html lang="en">
<@headWelcome.head value="Main"/>
<body>
<!--шапка-->
<@slideHeadMain.slideHead/>

<!--поиск-->
<form method="get" class="d1">
    <input type="text" name="finder" placeholder="Искать здесь...">
    <button input type="submit"></button>
</form>

<!--карусель фотографий-->
<@base.Recipes/>
<!--основной блок-->

<!--    &lt;!&ndash;блок с характеристиками&ndash;&gt;-->
<!--    <div class="container-fluid">-->
<!--    <div class="row text-center alert">-->
<!--        <div class="col-12">-->
<!--            <h1 class="display-4">Если вам не удалось найти желаемый рецепт, напишите нам!</h1>-->
<!--        </div>-->
<!--    </div>-->
<!--</div>-->
<!--    &lt;!&ndash;блок с описанием языков&ndash;&gt;-->
<!--    <div class="container-fluid padding">-->
<!--        <div class="row text-center padding">-->
<!--            <div class="col-xs-12 col-sm-6 col-md-4">-->
<!--                <i class="fas fa-code"></i>-->
<!--                <h3>HTML5</h3>-->
<!--            </div>-->
<!--            <div class="col-xs-12 col-sm-6 col-md-4">-->
<!--                <i class="fas fa-bold"></i>-->
<!--                <h3>Bootstrap</h3>-->
<!--            </div>-->
<!--            <div class="col-xs-12 col-sm-6 col-md-4">-->
<!--                <i class="fab fa-css3"></i>-->
<!--                <h3>CSS3</h3>-->
<!--            </div>-->
<!--        </div>-->
<!--        <hr>-->
<!--    </div>-->
<!--футер-->
<@base.end/>


</body>
</html>