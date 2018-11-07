<%@ page import="java.util.List" %>
<%@ page import="com.nc.model.Airlane" %><%--
  Created by IntelliJ IDEA.
  User: nebaraka
  Date: 06.11.2018
  Time: 23:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Airlanes</title>
  </head>

  <body>
    <table>
        <tr>
            <th>ID</th> <th>Name</th> <th>Country</th>
        </tr>
                <%
                    List<Airlane> lst = (List<Airlane>) request.getAttribute("lst");
                    for (Airlane airlane:lst) {
                %>
                <form method="">
                    <button type="delete">Delete</button>
                </form>
                <tr>
                    <td><%airlane.getId();%></td>
                    <td><%airlane.getName();%></td>
                    <td><%airlane.getCountry();%></td>
                </tr>
                <%
                    }
                %>
    </table>

    <form method="post">
        <label>Id:
            <input type="number" name="id"><br />
        </label>

        <label>Name:
            <input type="text" name="name"><br />
        </label>

        <label>Country:
            <input type="text" name="country"><br />
        </label>

        <button type="submit">Submit</button>
    </form>
  </body>
</html>
