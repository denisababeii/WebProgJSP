<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 4/28/2021
  Time: 8:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>Quiz</title>
  <style>
    html {
      background: #6C6C6C;
    }

    body {
      background: #DEDEDE;
      box-shadow: 0 0 2px rgba(0, 0, 0, 0.06);
      color: #222;
      font-family: "Century Schoolbook", serif;
      font-size: 16px;
      line-height: 1.5;
      margin: 0 auto;
      max-width: 800px;
      padding: 4em 4em 4em;
    }

    h2 {
      font-size: 30px;
      line-height: 1.1;
      text-align: center;
    }

    a {
      color: #000000;
      text-align: center;
    }

    td, th {
      border: 1px solid black;
      padding: 8px;
    }

    th {
      padding-top: 12px;
      padding-bottom: 12px;
      text-align: center;
      background-color: #B9B9B9;
      color: black;
    }
  </style>
</head>
<body>
<form action="LoginController" method="post">
  Enter username : <input type="text" name="username"> <br>
  Enter password : <input type="password" name="password"> <br>
  <input type="submit" value="Login"/>
</form>
</body></html>
