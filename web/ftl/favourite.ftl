<#import "base.ftl" as base/>
<#import "slideHeadMain.ftl" as slideHeadMain/>
<#import "headWelcome.ftl" as headWelcome/>

<!DOCTYPE html>
<html lang="en">
<@headWelcome.head value="Favourite"/>
<body>
<!--шапка-->
<@slideHeadMain.slideHead/>
<hr>
<@base.Recipes/>
<!--
<div class="col-sm-12 col-md-12">
    <div class="carousel slide">
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img src="../img/b1.jpg">
                <div class="carousel-caption">
                    <h1 class="display-4">Домашние тонкие блинчики</h1>
                    <h1 class="display-8">ИНГРЕДИЕНТЫ:</h1>
                    <h6>3 яйца</h6>
                    <h6>1 ст. л. сахара</h6>
                    <h6>1 ч. л. соли</h6>
                    <h6>500 мл молока</h6>
                    <h6>280 г муки</h6>
                    <h6>3 ст. л. растительного масла плюс для жарки</h6>
                    <h6>сливочное масло, сметана, варенье для подачи</h6>
                    <button type="button" class="btn btn-outline-light btn-lg">Перейти к рецепту</button>
                    <button type="button" class="btn btn-warning btn-lg">Удалить из ибранного</button>
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
                    <h1 class="display-4">Домашние тонкие блинчики</h1>
                    <h1 class="display-8">ИНГРЕДИЕНТЫ:</h1>
                    <h6>3 яйца</h6>
                    <h6>1 ст. л. сахара</h6>
                    <h6>1 ч. л. соли</h6>
                    <h6>500 мл молока</h6>
                    <h6>280 г муки</h6>
                    <h6>3 ст. л. растительного масла плюс для жарки</h6>
                    <h6>сливочное масло, сметана, варенье для подачи</h6>
                    <button type="button" class="btn btn-outline-light btn-lg">Перейти к рецепту</button>
                    <button type="button" class="btn btn-warning btn-lg">Удалить из ибранного</button>
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
                    <h1 class="display-4">Домашние тонкие блинчики</h1>
                    <h1 class="display-8">ИНГРЕДИЕНТЫ:</h1>
                    <h6>3 яйца</h6>
                    <h6>1 ст. л. сахара</h6>
                    <h6>1 ч. л. соли</h6>
                    <h6>500 мл молока</h6>
                    <h6>280 г муки</h6>
                    <h6>3 ст. л. растительного масла плюс для жарки</h6>
                    <h6>сливочное масло, сметана, варенье для подачи</h6>
                    <button type="button" class="btn btn-outline-light btn-lg">Перейти к рецепту</button>
                    <button type="button" class="btn btn-warning btn-lg">Удалить из ибранного</button>
                </div>
            </div>
        </div>
    </div>
    <hr>
</div>
-->
<@base.end/>
</body>
</html>