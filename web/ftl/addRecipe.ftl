<#import "base.ftl" as base/>
<!DOCTYPE html>
<html lang="en">
<@base.head value="addRecipe"/>
<body>
<!--шапка-->
<@base.slideHead/>
<hr>
<!--<div id="pageAdd">-->
<form method="post" enctype="multipart/form-data" class="container-fluid row jumbotron">
    <div class="col-xs-12 col-sm-12 col-md-9 col-lg-9 col-xl-10">
        <div class="pageAddHeader">
            <h1>Добавление рецепта</h1>
        </div>
        <div class="pageAddContent">
            <label class="pageAddLabel">
                <span class="pageAddTitle">Название:</span>
                <input type="text" name="nameRecipe" required>
                <td><input type="file" name="photoRecipe">
                <td>
            </label>
            <br>
            <table class="table information_json">
                <span class="pageAddTitle">Ингридиенты:</span>
                <tr>
                    <th>Название ингридиента</th>
                    <th>Необходимое кол-во</th>
                    <th></th>
                </tr>
                <tr class="information_json_plus">
                    <td></td>
                    <td></td>
                    <td><span class="btn btn-primary plus pull-right">+</span></td>
                </tr>
            </table>

            <table class="table information_json">
                <span class="pageAddTitle">Шаги:</span>
                <tr>
                    <th>Номер</th>
                    <th>Что необходимо сделать</th>
                    <th></th>
                </tr>
                <tr class="information_json_plus3">
                    <td></td>
                    <td></td>
                    <td><span class="btn btn-primary plus3 pull-right">+</span></td>
                </tr>
            </table>


        </div>
    </div>
    <div class="col-xs-12 col-sm-12 col-md-3 col-lg-3 col-xl-2">
        <input class="btn5 btn-primary btn-lg" type="submit" name="saveNewRecipe" value="Сохранить">
    </div>
</form>

<!--</div>-->

<!--футер-->
<@base.end/>
<script>
    var quantityIngredient = 0;
    jQuery('.plus').click(function () {
        jQuery('.information_json_plus').before(
            '<tr>' +
            '<td><input type="text" class="form-control" id="information_json_name[]" name="nameIngredient' + quantityIngredient + '" placeholder="Название"></td>' +
            '<td><input type="text" class="form-control" id="information_json_val[]"  name="amountIngredient' + quantityIngredient + '" placeholder="Количество"></td>' +
            '<td><span class="btn btn-danger minus pull-right">&ndash;</span></td>' +
            '</tr>'
        );
        quantityIngredient += 1;
    });
    // on - так как элемент динамически создан и обычный обработчик с ним не работает
    jQuery(document).on('click', '.minus', function () {
        jQuery(this).closest('tr').remove(); // удаление строки с полями
        quantityIngredient -= 1;
    });
</script>
<form method="post" enctype="multipart/form-data">
</form>
<script>
    var quantityStep = 0;
    jQuery('.plus3').click(function () {
        jQuery('.information_json_plus3').before(
            '<tr>' +
            '<td><input type="text" class="form-control" id="information_json_name[]" name="textStep' + quantityStep + '"  placeholder="Название"></td>' +
            '<td><input type="file" id="information_json_photo[]"  name="photoStep' + quantityStep + '"></td>' +
            '<td><span class="btn btn-danger minus pull-right">&ndash;</span></td>' +
            '</tr>'
        );
        quantityStep += 1;
    });
    // on - так как элемент динамически создан и обычный обработчик с ним не работает
    jQuery(document).on('click', '.minus', function () {
        jQuery(this).closest('tr').remove(); // удаление строки с полями
        quantityStep -= 1;
    });
</script>

</body>
</html>