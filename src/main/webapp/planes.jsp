<%@ page import="java.util.List" %>
<%@ page import="com.nc.model.Plane" %><%--
  Created by IntelliJ IDEA.
  User: nebaraka
  Date: 07.11.2018
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Planes</title>
</head>

<body>
<a href="airlanes">Airlanes</a>
<a href="arrivals">Arrivals</a>
<a href="departures">Departures</a>
<a href="destinations">Destinations</a>
<a href="planes">Planes</a>
<table>
    <tr>
        <th>ID</th> <th>Name</th> <th>Country</th>
    </tr>
    <%
        List<Plane> lst = (List<Plane>) request.getAttribute("plnLst");
        for (Plane plane:lst) {
    %>
    <form method="post">
        <button type="submit" name="delete" value=<%=String.valueOf(plane.getId())%>>Delete</button>
    </form>
    <tr>
        <td><%=plane.getId()%></td>
        <td><%=plane.getModelName()%></td>
        <td><%=plane.getSeatsAmount()%></td>
        <td><%=plane.getMark()%></td>
        <td><%=plane.getAirlane()%></td>
        <td><%=plane.getRadius()%></td>
    </tr>
    <%
        }
    %>
</table>

<form method="post">
    <label>Id:
        <input type="number" name="id"><br />
    </label>

    <label>Model name:
        <input type="text" name="model_name"><br />
    </label>

    <label>Seats amount:
        <input type="text" name="seats_amount"><br />
    </label>

    <label>Mark:
        <input type="text" name="mark"><br />
    </label>

    <label>Airlane:
        <input type="text" name="airlane"><br />
    </label>

    <label>Radius:
        <input type="text" name="radius"><br />
    </label>

    <button type="submit">Submit</button>
</form>
</body>
</html>
