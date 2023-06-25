<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<html lang="pl">
<head>
    <meta charset="utf-8">
    <title>Zamówienia</title>
</head>
<body>
<sec:authorize access="hasRole('USER')">
    <div>
        <c:forEach var="order" items="${orders}">
            <tr>
                <td>${order.date} </td>
                <td>${order.price} </td>
                <td>${order.status} </td>
                <%--<td>${order.ksiazkiString}</td>--%>

            </tr>
        </c:forEach>
    </div>
</sec:authorize>




<div>
    <a href="/booksklep/books/list"><button>Powrót</button></a>
</div>

</body>
</html>
