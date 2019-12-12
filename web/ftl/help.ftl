<#ftl encoding="UTF-8"/>
<#import "base.ftl" as base/>
<#import "slideHeadMain.ftl" as slideHeadMain/>

<!DOCTYPE html>
<html lang="en">
<@base.head value="Help"/>
<body>
<!--шапка-->
<@slideHeadMain.slideHead/>
<hr>
<!--основной блок-->
<div class="container-fluid">
    <div class="row jumbotron">
        <div class="col-xs-12 col-sm-12 col-md-9 col-lg-9 col-xl-10">
            <p class="lead">Если при работе с сайтом у вас возникли проблемы, напишите нам</p>
            <p class="lead">Мы постраемся ответить вам в течение дня.</p>
            <p class="lead">Благодарим за ожидание.</p>

        </div>
        <div class="col-xs-12 col-sm-12 col-md-3 col-lg-3 col-xl-2">
            <button onclick="show('block')" class="btn btn-success btn-lg" type="button">Написать</button>
        </div>
    </div>
</div>

<!--обратная связь-->
<div id="pageForm">
    <div class="pageFormHeader">
        <h3>Форма обратной связи</h3>
        <span class="pageFormClose" onclick="show('none')"></span>
    </div>
    <div class="pageFormContent">
        <label class="pageFormLabel">
            <span class="pageFormTitle">Ваше имя:</span>
            <input type="text" name="" required>
        </label>
        <label class="pageFormLabel">
            <span class="pageFormTitle">Ваш mail:</span>
            <input type="text" name="" placeholder="@" required>
        </label>
        <label class="pageFormLabel">
            <span class="pageFormTitle">Ваш номер телефона:</span>
            <input type="text" name="" required>
        </label>
        <label class="pageFormLabel">
            <span class="pageFormTitle">Сообщение:</span>
            <textarea name="" required></textarea>
        </label>
        <lable class="pageFormLabel">
            <button type="submit" class="pageFormButton">Отправить</button>
        </lable>
    </div>
</div>
<!--Прозрачный фон-->
<div onclick="show('none')" id="grey"></div>

<figure>
    <div class="fixed-wrap">
        <div id="fixedpr">

        </div>

    </div>

</figure>


<hr>

<!--футер-->
<@base.end/>


<script>
    //Функция показа
    function show(state) {
        document.getElementById('pageForm').style.display = state;
        document.getElementById('grey').style.display = state;
    }
</script>

</body>
</html>