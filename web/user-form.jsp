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
        <form action="insert" method="POST">
            <table cellpadding="5">
                <tr>
                    <th>User Name: </th>
                    <td>
                        <input type="text" name="name" size="35" value="<c:out value='${user.name}'/>">
                    </td>
                </tr>
                <tr>
                    <th>User Email: </th>
                    <td>
                        <input type="text" name="email" size="35" value="<c:out value='${user.email}'/>">
                    </td>
                </tr>
                <tr>
                    <th>User Country: </th>
                    <td>
                        <input type="text" name="country" size="35" value="<c:out value='${user.country}'/>">
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Save">
                    </td>
                </tr>
            </table>
        </form>
    </div>    
</body>
</html>
