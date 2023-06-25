<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="pl">
<head>
    <meta charset="utf-8">
    <title>Books</title>
</head>
<body>
<h1>Dodaj książkę</h1>
<form:form action="saveBook2" modelAttribute="bookDTO" method="POST">

    <table>
        <tbody>
        <tr>
            <td><label>nazwa:</label></td>
            <td><form:input path="nazwa" /></td>
        </tr>

        <tr>
            <td><label>wydawnictwo:</label></td>
            <td><form:input path="wydawnictwo" /></td>
        </tr>

        <tr>
            <td><label>cena:</label></td>
            <td><form:input path="cena" /></td>
        </tr>
        <tr>
            <td><label for="categories">kategoria:</label></td>
            <td><form:select path="kategoriaid" id="categories"> <form:options items="${categories}" itemValue="id" itemLabel="nazwa"/></form:select></td>
        </tr>

        <tr>
            <td><label></label></td>
            <td><input type="submit" value="Save" class="save" /></td>
        </tr>


        </tbody>
    </table>


</form:form>


<p>
    <a href="${pageContext.request.contextPath}/books/list "> Powrót  </a>
</p>
</body>
</html>
