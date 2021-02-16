<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Manipulation Page</title>
<style>
.error {
    color: #ff0000;
    font-style: italic;
    font-weight: bold;
}
</style>

 <style type="text/css">
        body {
            font-family: verdana;
            font-size: 12px;
            margin: 40px;
        }
        .bookTable, .bookTable td {
            border-collapse: collapse;
            border: 1px solid #aaa;
            margin: 2px;
            padding: 2px 2px 2px 10px;
            font-size: 12px;
        }
        .bookTable th {
            font-weight: bold;
            font-size: 12px;
            background-color: #5C82FF;
            color: white;
        }
        .bookLabel {
            font-family: verdana;
            font-size: 12px;
            font-weight: bold;
        }
        a, a:AFTER {
            color: blue;
        }
    </style>
</head>
<body>
<div align="center">
<h2>Book Store - SpringMVC-Hibernate CRUD Application</h2>
<c:url var="action" value="/book/add.html" ></c:url>
<form:form action="${action}"  commandName="book" method="POST">
<%-- <form:form action="book/add.html"  commandName="book" method="POST"> --%>

<table>
<c:if test="${!empty book.id}">
<tr>
         <td><font face="verdana" size="2px">Book Id</font></td>
    <td>:</td>
        <td>
            <form:input path="id" readonly="true" size="8"  disabled="true" />
            <form:hidden path="id" /><%-- To hide the book id--%>
        </td>
    </tr>
    </c:if>

<tr>
    <td><font face="verdana" size="2px">Book Name</font></td>
    <td>:</td>
    <td>
    <font face="verdana" size="2">
    <form:input path="bookName" /> 
    <form:errors path="bookName" cssClass="error"></form:errors>
    </font>
    </td>
</tr>
<tr>
    <td><font face="verdana" size="2px">Author Name</font></td>
    <td>:</td>
    <td>
    <font face="verdana" size="2">
    <form:input path="author" /> 
    <form:errors path="author" cssClass="error"></form:errors>
    </font>
    </td>
</tr>

<tr>
    <td><font face="verdana" size="2px">Price</font></td>
    <td>:</td>
    <td>
    <font face="verdana" size="2">
    <form:input path="price" /> 
    <form:errors path="price" cssClass="error"></form:errors>
    </font>
    </td>
</tr>
<tr>
    <td><font face="verdana" size="2px">Quantity</font></td>
    <td>:</td>
    <td>
    <font face="verdana" size="2">
    <form:input path="quantity" /> 
    <form:errors path="quantity" cssClass="error"></form:errors>
    </font>
    </td>
</tr>
<tr>
        <td colspan="2">
            <c:if test="${!empty book.id}">
                <input type="submit" value="Edit" />
            </c:if>
            <c:if test="${empty book.id}">
                <input type="submit" value="Add Book" />
            </c:if>
        </td>
    </tr>
</table>
</form:form>
<h3>List of Books in Library</h3>
<c:if test="${!empty bookList}">
    <table class="bookTable">
    <tr>
        <th width="180">Book Name</th>
        <th width="160">Author Name</th>
        <th width="60">Price</th>
        <th width="80">Quantity</th>
        <th width="60" colspan="2">Action</th>
       
    </tr>
 <c:forEach items="${bookList}" var="book">
        <tr>
        <td>${book.id}</td>
            <td>${book.bookName}</td>
            <td>${book.author}</td>
            <td>${book.price}</td>
            <td>${book.quantity}</td>
             <td><a href="<c:url value='/edit/${book.id}' />" >Edit</a></td>
            <td><a href="<c:url value='/delete/${book.id}' />" >Delete</a></td>
        </tr>
    </c:forEach>
    </table>
</c:if>
</div>
</body>
</html>