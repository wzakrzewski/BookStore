<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="pl">
<head>
    <meta charset="utf-8">
    <title>Autorzy</title>
</head>
<body>
<h1>Dodaj autora</h1>
<form:form action="saveAuthor" modelAttribute="autor" method="POST">

    <table>
        <tbody>
        <tr>
            <td><label>Imie:</label></td>
            <td><form:input path="imie" /></td>
        </tr>

        <tr>
            <td><label>Nazwisko:</label></td>
            <td><form:input path="nazwisko" /></td>
        </tr>

        <tr>
            <td><label></label></td>
            <td><input type="submit" value="Zapisz" class="save" /></td>
        </tr>

        </tbody>
    </table>


</form:form>


<p>
    <a href="${pageContext.request.contextPath}/authors/list "> Powrót  </a>
</p>
</body>
</html>