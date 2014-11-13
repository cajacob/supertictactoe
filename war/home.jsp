<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<html>
  <head>
  	<link rel="stylesheet" type="text/css" href="home.css">
  </head>
  <body>
 	<h1>Super Tic-Tac-Toe</h1>
 <div id="GameDescription">
 <div id="Description">
 <p>Game Description:</p>
 <p1>	You can play this game with two people.</p1>
</div>
  <div id="sideCol">
  	<div id="humanPlay">
				<form id="game" action="gamepage.jsp">    
        			<div><input type="submit" value="Play with Other Players"/> </div>
				</form>
 				<form id="game_action" action="gamepage.jsp">    
        			<div><input type="submit" value="Play with Computer"/></div>
				</form>
 
 </div>
 </div>
  </body>
</html>