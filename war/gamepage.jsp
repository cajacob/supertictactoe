<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>


<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 
<html>
  <head>
  	<link rel="stylesheet" type="text/css" href="home.css">
  	<script src="board.js"></script>
  </head>
  <body onLoad=initialize()>

 	<h1>Super Tic-Tac-Toe</h1>
	<div id="playerPage">
 	<div id="playerTab">
	<p><input type="radio" name="player" value="Player1">	Player1</input></p>
	<p><input type="radio" name="player" value="Player2"> Player2</input></p>
 	</div>
 
  	<div id="gamePlatform">
  	    <canvas id="canvas_1" width="476" height="476">
			Canvas Tag not supported
		</canvas>
    
  	
		</div>
	  	<div id="gameButtons">
		<input type="button" value = "Quit" </input>

	</div>
 	</div>
 	<img id="tic-tac-x" src="images/tic-tac-x.png" alt="Tic-Tac-X" width="40" height="40" hidden="true">
    <img id="tic-tac-o" src="images/tic-tac-o.png" alt="Tic-Tac-O" width="40" height="40" hidden="true">
     <img id="big-x" src="images/big-x.png" alt="Big-X" width="100" height="100" hidden="true">
    <img id="big-o" src="images/big-o.png" alt="Big-O" width="100" height="100" hidden="true">
    
  </body>
</html>