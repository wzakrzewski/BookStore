<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="pl">
<head>
    <meta charset="utf-8">
    <title>Lista autorów</title>
</head>
<body>
        <h2>Autorzy:</h2>

        <div>
            <table>
                <tr>
                    <th>Imię</th>
                    <th>Nazwisko</th>
                    <th>Edytuj</th>
                    <th>Usuń</th>
                </tr>
                <c:forEach var="autor" items="${autorzy}" >
                    <tr>
                        <td>${autor.imie}</td>
                        <td>${autor.nazwisko}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/authors/updateAuthor/${autor.id}">Edytuj</a>
                        </td>

                        <td>
                            <form:form action="${pageContext.request.contextPath}/authors/deleteAuthor">
                                <input type="hidden" id="authorId" name="authorId" value="${autor.id}"/>
                                <button type="submit" >Usuń</button>
                            </form:form>
                        </td>

                    </tr>
                </c:forEach>
            </table>
        </div>


        <div>
            <input type="button" value="Dodaj autora"
                   onclick="window.location.href='authorformadd';return false;" />
        </div>

        <div>
            <a href="/booksklep/books/list"><button>Powrót</button></a>
        </div>

</body>
</html>
