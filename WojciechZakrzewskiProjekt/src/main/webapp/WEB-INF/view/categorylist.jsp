<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="pl">
<head>
    <meta charset="utf-8">
    <title>Lista kategorii</title>
</head>
<body>
<h2>Kategorie:</h2>

<div>
    <table>
        <tr>
            <th>Nazwa</th>
            <th>Edytuj</th>
            <th>Usuń</th>
        </tr>
        <c:forEach var="category" items="${categories}" >
            <tr>
                <td>${category.nazwa}</td>

                <td>
                    <a href="${pageContext.request.contextPath}/categories/updateCategory/${category.id}">Edytuj</a>
                </td>

                <td>
                    <form:form action="${pageContext.request.contextPath}/categories/deleteCategory">
                        <input type="hidden" id="categoryId" name="categoryId" value="${category.id}"/>
                        <button type="submit" >Usuń</button>
                    </form:form>
                </td>

            </tr>
        </c:forEach>
    </table>
</div>


<div>
    <input type="button" value="Dodaj kategorie"
           onclick="window.location.href='addcategory';return false;" />
</div>

<div>
    <a href="/booksklep/books/list"><button>Powrót</button></a>
</div>

</body>
</html>