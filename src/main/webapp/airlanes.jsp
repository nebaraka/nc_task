<%@ page import="java.util.List" %>
<%@ page import="com.nc.model.Airlane" %><%--
  Created by IntelliJ IDEA.
  User: nebaraka
  Date: 06.11.2018
  Time: 23:55
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

      <title>Airlanes</title>
  </head>

  <body>
<a href="airlanes">Airlanes</a>
<a href="arrivals">Arrivals</a>
<a href="departures">Departures</a>
<a href="destinations">Destinations</a>
<a href="planes">Planes</a>
<table>
    <tr>
        <th></th><th>ID</th> <th>Name</th> <th>Country</th>
    </tr>
    <%
        List<Airlane> lst = (List<Airlane>) request.getAttribute("airLst");
        for (Airlane airlane:lst) {
    %>
    <tr>
        <td>
            <form method="post">
                <button type="submit" name="delete" value=<%=String.valueOf(airlane.getId())%>>Delete</button>
            </form>
        </td>
        <td><%=airlane.getId()%></td>
        <td><%=airlane.getName()%></td>
        <td><%=airlane.getCountry()%></td>
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
                <label>Name:
                <input type="text" name="name"><br />
                </label>
            </td>
        </tr>

        <tr align="right">
            <td>
                <label>Country:
                <input type="text" name="country"><br />
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
