<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>User Manager Application</title>
</head>
<body>
    <!--Titles and links-->
    <center>
        <h1>Hello World!</h1>
        <h2>
            <a href="new">Add New User</a>
            &nbsp;&nbsp;&nbsp;&nbsp;
            <a href="list">List All Users</a>
        </h2>
    </center>
    
    <!--The Form-->
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Users</h2></caption>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Country</th>
            </tr>
            <c:forEach var="user" items="${listUser}"/>
                <tr>
                    <td><c:out value="${user.id}" /></td>
                    <td><c:out value="${user.name}" /></td>
                    <td><c:out value="${user.email}" /></td>
                    <td><c:out value="${user.country}" /></td>                    
                </tr>
        </table>
    </div> 
</body>
</html>
