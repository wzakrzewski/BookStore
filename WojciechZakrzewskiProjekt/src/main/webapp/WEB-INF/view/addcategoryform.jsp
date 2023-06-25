<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="pl">
<head>
    <meta charset="utf-8">
    <title>Kategorie</title>
</head>
<body>
<h1>Dodaj kategorie</h1>
<form:form action="saveCategory" modelAttribute="category" method="POST">

    <table>
        <tbody>
        <tr>
            <td><label>Nazwa:</label></td>
            <td><form:input path="nazwa" /></td>
        </tr>


        <tr>
            <td><label></label></td>
            <td><input type="submit" value="Zapisz" class="save" /></td>
        </tr>

        </tbody>
    </table>


</form:form>


<p>
    <a href="${pageContext.request.contextPath}/categories/list "> Powrót  </a>
</p>
</body>
</html>