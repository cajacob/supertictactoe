<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>


<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 
<html>
  <head>
  	<link rel="stylesheet" type="text/css" href="home.css">
  </head>
  <body>

 	<h1>Super Tic-Tac-Toe</h1>
	<div id="playerWin">
 
     <% 
     String userId =  request.getParameter("user").toString();
     %>
          <p>Player <%=userId %> is the Winner! Yay! </p>
 	</div>

  </body>
</html>