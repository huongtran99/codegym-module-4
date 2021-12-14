<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello</title>
</head>
<body>
<h1>Sandwich Condiments</h1>
<form action="save">
    <input type="checkbox" value="lettuce" name="condiment">lettuce
    <input type="checkbox" value="Tomato" name="condiment">Tomato
    <input type="checkbox" value="Mustard" name="condiment">Mustard
    <input type="checkbox" value="Sprouts" name="condiment">Sprouts
    <hr>
    <input type="submit" value="save">
</form>
<p>${c}</p>
</body>
</html>
