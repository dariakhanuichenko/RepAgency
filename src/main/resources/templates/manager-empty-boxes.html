<!DOCTYPE html>
<html xmlns:th="http://www.w3.org/1999/xhtml"
>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Manager</title>
    <link rel="stylesheet" href="/assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lora">
    <link rel="stylesheet" href="/assets/css/styles4.min.css">
    <link rel="stylesheet" href="/assets/css/style.css">
</head>

<body>
<nav class="navbar navbar-light navbar-expand-md navigation-clean-button">
    <div class="container"><a class="navbar-brand" href="#"><span
            style="color: red; font-size:20pt; font-family: 'Arial Black'">My</span> machine</a>
        <button class="navbar-toggler" data-toggle="collapse" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span
                class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse">

            <span class="navbar-text actions"> <a class="login" th:href="@{/logout}" th:text="#{nav.logout}"></a></span>
            <button class="btn" type="button"
                    value="uk"
                    id="locales2"
                    style="height: 20px;background-image: url(&quot;/assets/img/ua.jpg&quot;);background-position: center;margin-right: 2px;margin-left: 15px;"></button>
            <button
                    value="en"
                    class="btn" type="button" id="locales"
                    style="height: 20px;background-image: url(&quot;/assets/img/en.jpg&quot;);background-position: center;background-size: cover;background-repeat: no-repeat;padding-right: 12px;margin: 6px;margin-top: 6px;margin-right: -27px;margin-left: 1px;"></button>
        </div>
    </div>
</nav>
</div>
<!--<div data-bs-parallax-bg="true"-->
<!--     style="height: 500px;background-image: url(&quot;/assets/img/background.png&quot;);background-position: center;background-size: cover;"></div>-->

<div id="line"></div>
<div th:if="${param.error}">
    <div class="alert alert-danger" th:text="#{empty.value}">
        <h2 name="${error}" th:text="#{empty.value}"></h2>
    </div>
    <div th:if="${param.logout}">
        <div class="alert alert-info">
        </div>
    </div>
    <h2 th:if="${error}" th:text="${error}"></h2>
</div>

<div style="margin-left:20%; margin-right: 15%; margin-top: 2%" class="row">
    <div class="col">
        <div class="table-responsive">
            <table class="table">
                <thead>
                <tr>
                    <th>Product name</th>
                    <th> Total capasity</th>
                </tr>
                </thead>
                <tbody>

                <div th:each="box: ${boxes}">
                    <tr>
                        <td th:text="${box.name}"></td>
                        <td th:text="${box.totalCapasity}"></td>

                        <td>
                            <form th:action="@{/manager/add-product?(id=${box.id})}"
                                  method="post" th:object="${boxDTO}">
                                <input
                                        th:field="*{quantity}"
                                        pattern="[0-9]+">
                                <input th:value="${box.id}" th:field="*{id}" type="hidden"/>
                                <button type="submit" id="buttonCansel"><span th:text="#{add}"></span></button>
                            </form>

                        </td>
                    </tr>
                </div>


                </tbody>
            </table>
        </div>
    </div>
    <div>
        <a id="buttonBuy" href="/manager/get-revenue" onclick="getRevenue()" type="submit"><span
                th:text="#{get.revenue}"></span></a>
    </div>
</div>

<div id="return" style="display:none;" class="alert alert-primary" role="alert">
    <span th:text="#{returned}"></span> <span th:text="${returnMoney}"></span> <span th:text="#{money}"></span>
</div>
<script>
    function getRevenue() {
        document.getElementById("return").style.display = "block";
    }
</script>
<script src="/assets/js/jquery.min.js"></script>
<script src="/assets/bootstrap/js/bootstrap.min.js"></script>
<script src="/assets/js/script.min.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        $("#locales").click(function () {
            var selectedOption = $('#locales').val();
            if (selectedOption != '') {
                window.location.replace('?lang=' + selectedOption);
            }
        });
    });
</script>
<script type="text/javascript">
    $(document).ready(function () {
        $("#locales2").click(function () {
            var selectedOption = $('#locales2').val();
            if (selectedOption != '') {
                window.location.replace('?lang=' + selectedOption);
            }
        });
    });
</script>
</body>

</html>