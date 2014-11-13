<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>


<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 
<html>
  <head>
  	<link rel="stylesheet" type="text/css" href="home.css">
  </head>
  <body>
 	<h1>Super Tic-Tac-Toe</h1>
	<div id="playerPage">
 	<div id="playerTab">
	<p><input type="radio" name="player" value="Player1">	Player1</input></p>
	<p><input type="radio" name="player" value="Player2"> Player2</input></p>
 	</div>
 
  	<div id="gamePlatform">
		</div>
	  	<div id="gameButtons">
		<input type="button" value = "Quit" </input>

	</div>
 	</div>
  </body>
</html>