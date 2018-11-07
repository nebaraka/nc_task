<%@ page import="java.util.List" %>
<%@ page import="com.nc.model.Departure" %><%--
  Created by IntelliJ IDEA.
  User: nebaraka
  Date: 07.11.2018
  Time: 19:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    <style>
        table, th, td {
            border: 1px solid black;
        }
    </style>

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
        <th></th><th>ID</th> <th>Number</th> <th>Destination name</th> <th>Departure time</th>
        <th>Arrival time</th><th>Gate</th> <th>Airlane name</th> <th>Plane mark</th>
    </tr>
    <%
        List<Departure> lst = (List<Departure>) request.getAttribute("depLst");
        for (Departure departure:lst) {
    %>
    <tr>
        <td>
            <form method="post">
                <button type="submit" name="delete" value=<%=String.valueOf(departure.getId())%>>Delete</button>
            </form>
        </td>
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

<div>
<form method="post">
    <table>
        <tr align="center">
            <th>Add new</th>
        </tr>

        <tr align="right">
            <td>
                <label>ID:
                    <input type="text" name="id"><br />
                </label>
            </td>
        </tr>
    <tr align="right">
        <td>
    <label>Number:
        <input type="text" name="number"><br />
    </label>
        </td>
    </tr>

    <tr align="right">
        <td>
    <label>Destination name:
        <input type="text" name="dest_name"><br />
    </label>
        </td>
    </tr>

    <tr align="right">
        <td>
    <label>Departure time:
        <input type="text" name="dep_time"><br />
    </label>
        </td>
    </tr>

    <tr align="right">
        <td>
    <label>Arrival time:
        <input type="text" name="arr_time"><br />
    </label>
        </td>
    </tr>

    <tr align="right">
        <td>
    <label>Gate:
        <input type="text" name="gate"><br />
    </label>
        </td>
    </tr>

    <tr align="right">
        <td>
    <label>Airlane name:
        <input type="text" name="airlane_name"><br />
    </label>
        </td>
    </tr>

    <tr align="right">
        <td>
    <label>Plane mark:
        <input type="text" name="plane_mark"><br />
    </label>
        </td>
    </tr>

    <tr align="right">
        <td>
    <button type="submit">Submit</button>
        </td>
    </tr>

    </table>
</form>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>
