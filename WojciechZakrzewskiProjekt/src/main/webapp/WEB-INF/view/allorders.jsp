<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<html lang="pl">
<head>
  <meta charset="utf-8">
  <title>Wszystkie zamówienia</title>
</head>
<body>


<sec:authorize access="hasRole('ADMIN')">
  <div>
    <c:forEach var="order" items="${orders}">
      <tr>
        <td>${order.date}</td>
        <td>${order.price}</td>
        <td>${order.status}</td>
        <%--<td>${order.ksiazkiString}</td>--%>

        <td>
          <form:form action="${pageContext.request.contextPath}/orders/complete">
            <input type="hidden" id="orderId" name="orderId" value="${order.id}"/>
            <button type="submit">Zmień status na zrealizowane</button>
          </form:form>
        </td>
      </tr>
    </c:forEach>
  </div>
</sec:authorize>



<div>
  <a href="/booksklep/books/list"><button>Powrót</button></a>
</div>

</body>
</html>
