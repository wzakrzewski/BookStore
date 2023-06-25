<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html lang="pl">
<head>
  <meta charset="utf-8">
    <title>Koszyk</title>
</head>
<body>

<c:forEach var="book" items="${books}">
  <tr>
    <td>${book.nazwa}</td>
    <td>${book.wydawnictwo}</td>
    <td>${book.cena}</td>
    <td>${book.kategoria.nazwa}</td>
    <td>${book.autorzyString}</td>
    <td>
      <form:form action="${pageContext.request.contextPath}/cart/delete">
        <input type="hidden" id="bookId" name="bookId" value="${book.id}"/>
        <button type="submit">Delete</button>
      </form:form>
    </td>
  </tr>
</c:forEach>

<div>
  <p>Do zapłaty: ${totalPrice}</p>
</div>


<div>
    <form:form action="${pageContext.request.contextPath}/orders">
    <input type="hidden" id="bookId" name="bookId"/>
    <button type="submit">Buy</button>
  </form:form>
</div>

<div>
  <a href="/booksklep/orders"><button>Twoje zamówienia</button></a>
</div>

<div>
  <a href="/booksklep/books/list"><button>Powrót</button></a>
</div>

</body>
</html>
