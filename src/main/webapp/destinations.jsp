<%@ page import="java.util.List" %>
<%@ page import="com.nc.model.Destination" %><%--
  Created by IntelliJ IDEA.
  User: nebaraka
  Date: 07.11.2018
  Time: 19:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Destinations</title>
</head>

<body>
<a href="airlanes">Airlanes</a>
<a href="arrivals">Arrivals</a>
<a href="departures">Departures</a>
<a href="destinations">Destinations</a>
<a href="planes">Planes</a>
<table>
    <tr>
        <th>ID</th> <th>City</th> <th>Country</th> <th>Distance</th>
    </tr>
    <%
        List<Destination> lst = (List<Destination>) request.getAttribute("desLst");
        for (Destination destination:lst) {
    %>
    <form method="post">
        <button type="submit" name="delete" value=<%=String.valueOf(destination.getId())%>>Delete</button>
    </form>
    <tr>
        <td><%=destination.getId()%></td>
        <td><%=destination.getCity()%></td>
        <td><%=destination.getCountry()%></td>
        <td><%=destination.getDistance()%></td>
    </tr>
    <%
        }
    %>
</table>

<form method="post">
    <label>Id:
        <input type="number" name="id"><br />
    </label>

    <label>City:
        <input type="text" name="name"><br />
    </label>

    <label>Country:
        <input type="text" name="country"><br />
    </label>

    <label>Distance:
        <input type="number" name="distance"><br />
    </label>

    <button type="submit">Submit</button>
</form>
</body>
</html>
