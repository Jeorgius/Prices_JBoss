<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
    <title>Prices_JBoss</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div class="content">

    <div class="addGoods">
        <h3>New product</h3>
        <form action="api/createproduct" method="post" enctype="application/x-www-form-urlencoded">
            Price:
            <input type="number" name="value" placeholder="price"><br/>
            Date Begin:
            <input type="date" name="date_begin" placeholder="from"><br/>
            Date End:
            <input type="date" name="date_end" placeholder="to"><br/>
            Product ID:
            <input type="number" name="product_id" placeholder="password"><br/>
            <input type="submit" value="Add product with price"><br/>
        </form>
    </div>

    <div class="addPrices">
        <h3>Import new prices</h3>
        <form action="api/importprices" method="post" id="price" <%--enctype="application/x-www-form-urlencoded"--%>>
            Price: <input type="number" name="value" value="1337"><br/>
            Date begin: <input type="datetime-local" name="date_begin" step="1"><br/>
            Date End:<input type="datetime-local" name="date_end" step="1"><br/>
            <input type="button" id="addPrice" value="+ Add one more price"><br/>
            <input type="submit" value="Import new prices"><br/>
        </form>
    </div>
</div>
<h1>Goods</h1>
<script src="js/inputs.js"></script>
</body>
</html>
