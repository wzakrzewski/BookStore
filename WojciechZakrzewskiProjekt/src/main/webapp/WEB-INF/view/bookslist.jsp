<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

    <html lang="pl">
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <title>Lista książek</title>
</head>
<body>
        <h2>Książki:</h2>

        <div>
            <table>
                <tr>
                    <th>Nazwa</th>
                    <th>Wydawnictwo</th>
                    <th>Cena</th>
                    <th>Kategoria</th>
                    <sec:authorize access="hasRole('USER')">
                        <th>Do koszyka</th>
                    </sec:authorize>
                    <sec:authorize access="hasRole('ADMIN')">
                        <th>Edytuj</th>
                    </sec:authorize>
                    <sec:authorize access="hasRole('ADMIN')">
                        <th>Usuń</th>
                    </sec:authorize>

                </tr>
                <c:forEach var="books" items="${books}" >
                    <tr>
                        <td>${books.nazwa}</td>
                        <td>${books.wydawnictwo}</td>
                        <td>${books.cena}</td>
                        <td>${books.kategoria.nazwa}</td>
                        <sec:authorize access="hasRole('USER')">
                            <td>
                                <form:form action="${pageContext.request.contextPath}/cart/add">
                                    <input type="hidden" id="bookId" name="bookId" value="${books.id}"/>
                                    <button type="submit" >Do koszyka</button>
                                </form:form>
                            </td>
                        </sec:authorize>
                        <sec:authorize access="hasRole('ADMIN')">
                            <td>
                                <a href="${pageContext.request.contextPath}/books/updateBook/${books.id}">Edytuj</a>
                                    <%--<c:url var="update" value="/books/updateBookForm">
                                        <c:param name="bookId" value="${book.id}"/>
                                    </c:url>--%>
                            </td>
                        </sec:authorize>
                        <sec:authorize access="hasRole('ADMIN')">
                            <td>
                                <form:form action="${pageContext.request.contextPath}/books/deleteBook">
                                    <input type="hidden" id="bookId" name="bookId" value="${books.id}"/>
                                    <button type="submit" >Usuń</button>
                                </form:form>
                            </td>
                        </sec:authorize>
                    </tr>
                </c:forEach>


            </table>
        </div>

        <sec:authorize access="hasRole('ADMIN')">
        <div>
            <input type="button" value="Dodaj książkę"
                   onclick="window.location.href='formadd2';return false;" />
        </div>
        </sec:authorize>

        <sec:authorize access="hasRole('USER')">
            <div>
                <a href="/booksklep/cart"><button>Koszyk</button></a>
            </div>
        </sec:authorize>

        <sec:authorize access="hasRole('ADMIN')">
            <div>
                <a href="/booksklep/allorders"><button>Wszystkie zamówienia</button></a>
            </div>
        </sec:authorize>

        <sec:authorize access="hasRole('ADMIN')">
            <div>
                <a href="/booksklep/authors/list"><button>Autorzy</button></a>
            </div>
        </sec:authorize>

        <sec:authorize access="hasRole('ADMIN')">
            <div>
                <a href="/booksklep/categories/list"><button>Kategorie</button></a>
            </div>
        </sec:authorize>

</body>
</html>
