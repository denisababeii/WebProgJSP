<%--
  Created by IntelliJ IDEA.
  User: forest
  Date: 16.12.2014
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Quiz</title>
    <script src="js/jquery-2.0.3.js"></script>
    <script src="js/scripts.js"></script>
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
<form name="quizForm" action="QuestionController" method="post" onsubmit="return validateForm()">
    Enter total number of questions : <input type="text" name="noQuestions"> <br>
    Enter number of questions per page : <input type="text" name="noQuestionsPerPage"> <br>
    <input type="submit" value="Submit"/>
</form>
</body>
</html>