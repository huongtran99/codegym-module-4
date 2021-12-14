<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Calc</title>
  </head>
  <body>
  <h1>Calculator</h1>
  <form action="calc" method="post">
    <input type="text" name="value" value="${value1}">
    <input type="text" name="value" value="${value2}">
    <button name="calculation" value="Add">Add(+)</button>
    <button name="calculation" value="Sub">Sub(-)</button>
    <button name="calculation" value="Mul">Mul(x)</button>
    <button name="calculation" value="Div">Div(/)</button>
  </form>
  <p>Result ${calc} : ${result}</p>
  </body>
</html>
