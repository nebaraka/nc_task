<%@ page import="java.util.List" %>
<%@ page import="com.nc.model.Departure" %><%--
  Created by IntelliJ IDEA.
  User: nebaraka
  Date: 07.11.2018
  Time: 19:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Departures</title>
</head>
<body>
<a href="airlanes">Airlanes</a>
<a href="arrivals">Arrivals</a>
<a href="departures">Departures</a>
<a href="destinations">Destinations</a>
<a href="planes">Planes</a>
<table>
    <tr>
        <th>ID</th> <th>Number</th> <th>Destination name</th> <th>Departure time</th>
        <th>Arrival time</th><th>Gate</th> <th>Airlane name</th> <th>Plane mark</th>
    </tr>
    <%
        List<Departure> lst = (List<Departure>) request.getAttribute("depLst");
        for (Departure departure:lst) {
    %>
    <form method="post">
        <button type="submit" name="delete" value=<%=String.valueOf(departure.getId())%>>Delete</button>
    </form>
    <tr>
        <td><%=departure.getId()%></td>
        <td><%=departure.getNumber()%></td>
        <td><%=departure.getDestName()%></td>
        <td><%=departure.getDepTime()%></td>
        <td><%=departure.getArrTime()%></td>
        <td><%=departure.getGate()%></td>
        <td><%=departure.getAirlaneName()%></td>
        <td><%=departure.getPlaneMark()%></td>
    </tr>
    <%
        }
    %>
</table>

<form method="post">
    <label>Id:
        <input type="number" name="id"><br />
    </label>

    <label>Number:
        <input type="text" name="number"><br />
    </label>

    <label>Destination name:
        <input type="text" name="dest_name"><br />
    </label>

    <label>Departure time:
        <input type="text" name="dep_time"><br />
    </label>

    <label>Arrival time:
        <input type="text" name="arr_time"><br />
    </label>

    <label>Gate:
        <input type="text" name="gate"><br />
    </label>

    <label>Airlane name:
        <input type="text" name="airlane_name"><br />
    </label>

    <label>Plane mark:
        <input type="text" name="plane_mark"><br />
    </label>

    <button type="submit">Submit</button>
</form>
</body>
</html>
