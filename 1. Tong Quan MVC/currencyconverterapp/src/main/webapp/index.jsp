<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="index" method="post">
    <label>USD</label>
    <input type="text" name="usd" value="${result/23000}">
    <p>VND : ${result}</p>
    <button>Change</button>
  </form>
  </body>
</html>
