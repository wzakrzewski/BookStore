<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html lang="pl">
<head>
 <meta charset="utf-8">
 <title>Rejestracja</title>
</head>
<body>
<nav>
 <div >
 <a href="${pageContext.request.contextPath}">Strona główna</a>
 </div>
</nav>
<h3>Rejestracja</h3>
<c:if test="${not empty validator}"><p><c:out value="${validator}"/></p></c:if>
<form:form method="post" modelAttribute="user">
 <table>
 <tbody>
 <tr>
 <td><label for="username">Nazwa:</label></td>
 <td><form:input path="username" id="username" class="form-control"/>
 </td>
 </tr>
 <tr>
 <td><label for="password">Hasło:</label></td>
 <td><form:password path="password" id="password" class="formcontrol"/></td>
 </tr>
 <tr>
 <td>
 <button type="submit">Zarejestruj</button>
 </td>
 </tr>
 </tbody>
 </table>
</form:form>
</body>
</html>