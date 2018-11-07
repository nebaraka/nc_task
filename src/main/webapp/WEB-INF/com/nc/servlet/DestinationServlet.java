package com.nc.servlet;

import com.nc.DAO.DestinationDAO;
import com.nc.model.Destination;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DestinationServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DestinationDAO dao = new DestinationDAO();
        List<Destination> lst = dao.getAll();
        req.setAttribute("desLst", lst);
        getServletContext().getRequestDispatcher("/destinations.jsp").forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DestinationDAO dao = new DestinationDAO();
        if (req.getParameter("delete") != null) {
            dao.delete(Integer.parseInt(req.getParameter("delete")));
        } else {
            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("name");
            String country = req.getParameter("country");
            int distance = Integer.parseInt(req.getParameter("distance"));
            dao.insert(new Destination(id, name, country, distance));
        }

        doGet(req, resp);
    }
}
