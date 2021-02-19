<%@page import="com.manager.BookDao"%>
<%@page import="com.pojo.Book"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<c:out value="${user.name}"></c:out>

<% BookDao bd=new BookDao();
List<Book> lb=bd.showBooks();
HttpSession h=request.getSession();
h.setAttribute("book", lb);
%>

<table border="2px">
<tr>
<th>Book Id</th>
<th>Book Name</th>
<th>Book Author</th>
<th>Book Price</th>
</tr>

<c:forEach var="i" items="${book }">
<tr>
<td><c:out value="${i.bookId }"></c:out></td>
<td><c:out value="${i.bookName }"></c:out></td>
<td><c:out value="${i.author }"></c:out></td>
<td><c:out value="${i.price }"></c:out></td>
<td><a href="BuyNowController?bid=${i.bid }">Buy</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>