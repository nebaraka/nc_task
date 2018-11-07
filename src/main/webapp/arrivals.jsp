<%@ page import="java.util.List" %>
<%@ page import="com.nc.model.Arrival" %><%--
  Created by IntelliJ IDEA.
  User: nebaraka
  Date: 07.11.2018
  Time: 17:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Arrivals</title>
</head>

<body>
<a href="airlanes">Airlanes</a>
<a href="arrivals">Arrivals</a>
<a href="departures">Departures</a>
<a href="destinations">Destinations</a>
<a href="planes">Planes</a>
<table>
    <tr>
        <th>ID</th> <th>Number</th> <th>Destination name</th> <th>Arrival time</th>
        <th>Departure time</th> <th>Gate</th> <th>Airlane name</th> <th>Plane mark</th>
    </tr>
    <%
        List<Arrival> lst = (List<Arrival>) request.getAttribute("arrLst");
        for (Arrival arrival:lst) {
    %>
    <form method="post">
        <button type="submit" name="delete" value=<%=String.valueOf(arrival.getId())%>>Delete</button>
    </form>
    <tr>
        <td><%=arrival.getId()%></td>
        <td><%=arrival.getNumber()%></td>
        <td><%=arrival.getDestName()%></td>
        <td><%=arrival.getArrTime()%></td>
        <td><%=arrival.getDepTime()%></td>
        <td><%=arrival.getGate()%></td>
        <td><%=arrival.getAirlaneName()%></td>
        <td><%=arrival.getPlaneMark()%></td>
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

    <label>Arrival time:
        <input type="text" name="arr_time"><br />
    </label>

    <label>Departure time:
        <input type="text" name="dep_time"><br />
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