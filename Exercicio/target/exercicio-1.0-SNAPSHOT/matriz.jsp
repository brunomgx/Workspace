<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.google.appengine.api.users.User" %>
<%@ page import="com.google.appengine.api.users.UserService" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>
<%@ page import="com.googlecode.objectify.Key" %>
<%@ page import="com.googlecode.objectify.ObjectifyService" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link type="text/css" rel="stylesheet" href="/stylesheets/main.css"/>
</head>
<body>

<%
    UserService userService = UserServiceFactory.getUserService();
    User user = userService.getCurrentUser();
    if (user != null) {
        pageContext.setAttribute("user", user);
    }
%>
<table>
	<tr> 
		<td><a href="matriz.jsp">Matriz</a></td>
		<td><a href="<%= userService.createLogoutURL(request.getRequestURI()) %>">Logout</a></td>
	</tr> 
</table>
<hr />
<h3>Matriz</h3>
<hr />

<form action="/matriz" method="post" accept-charset="utf-8" enctype="multipart/form-data">
  <table>
    <tr>
      <td><label for="arquivo">Arquivo:</label></td>
      <td><input type="file" name="arquivo" id="arquivo" size="25"/></td>
    </tr>
    
    <tr>
      <td><input type="submit" value="Pesquisar Matriz"/></td>
    </tr>
  </table>
  
</form>

<hr />

</body>
</html>