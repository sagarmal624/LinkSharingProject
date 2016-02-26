<%--
  Created by IntelliJ IDEA.
  User: sagar
  Date: 2/25/16
  Time: 2:57 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
</head>

<body>
<div class="pagination">
    <table>
        <th>Name</th>
        <th>id</th>
        <g:each in="${users}" var="user">
            <tr>
                <td>${users.firstname}</td>
                <td>${users.id}</td>
            </tr>
        </g:each>
    </table>
    <g:paginate next="Forward" prev="Back"
                maxsteps="0" controller="user"
                action="show" total="${userCount}"/>
</body>
</html>