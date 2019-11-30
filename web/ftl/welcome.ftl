<#import "base.ftl" as base/>

<!DOCTYPE html>
<html lang="en">
<@base.head value="Welcome"/>
<body>

<@base.slideHead/>

<!--карусель фотографий-->
<@base.carousel_with_input/>

<!--основной блок-->
<div class="container-fluid">
    <div class="row jumbotron">
        <div class="col-xs-12 col-sm-12 col-md-9 col-lg-9 col-xl-10">
            <p class="lead">Всегда мечтали готовить самостоятельно, но не знаете, как к этому приготовиться?</p>
            <p class="lead">Что ж настало время попробовать, что-то новое.</p>
            <p class="lead">Мы уверены, что у нас вы найдете, чтобы приготовить</p>

        </div>
        <div class="col-xs-12 col-sm-12 col-md-3 col-lg-3 col-xl-2">
            <a href="#">
                <button class="btn btn-success btn-lg" type="button">Зарегистрироваться</button>
            </a>
        </div>
    </div>

</div>
<!--блок с характеристиками-->
<div class="container-fluid">
    <div class="row text-center alert">
        <div class="col-12">
            <h1 class="display-4">Надеемся вам понравится и вы вернетесь к нам за новыми рецептами</h1>
        </div>
        <hr>
        <div class="col-12">
            <h1 class="lead">Приятного аппетита!</h1>
            <h1 class="lead">Bon Appetit!</h1>
            <h1 class="lead">Buon appetito!</h1>
            <h1 class="lead">Bon appétit!</h1>
            <h1 class="lead">祝您好胃口！</h1>
        </div>
    </div>
</div>
<!--блок с описанием языков-->
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