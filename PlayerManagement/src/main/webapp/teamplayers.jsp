<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    %>
 <%@ page import="com.playermanagement.model.Player" %>
  <%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1><%=request.getAttribute("team") %> Team Players Data</h1>
<table border=1>
<tr><th>playerId</th><th>player Name</th><th>player age</th><th>player gender</th><th>player team</th></tr>
<%
List<Player> players =(List<Player>)request.getAttribute("players");
for(Player player : players){

 %>
 <tr><td><%=player.getId() %></td><td><%=player.getName() %></td><td><%=player.getAge() %></td><td><%=player.getGender() %></td>
 <td><%=player.getTeam() %></td></tr>
<%} %>
</table>
</body>
</html>