package com.nc.servlet;

import com.nc.model.Departure;
import com.nc.DAO.DepartureDAO;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DepartureServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DepartureDAO dao = new DepartureDAO();
        List<Departure> lst = dao.getAll();
        req.setAttribute("depLst", lst);
        getServletContext().getRequestDispatcher("/departures.jsp").forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DepartureDAO dao = new DepartureDAO();
        if (req.getParameter("delete") != null) {
            dao.delete(Integer.parseInt(req.getParameter("delete")));
        } else {
            int id = Integer.parseInt(req.getParameter("id"));
            String number = req.getParameter("number");
            String destName = req.getParameter("dest_name");
            String depTime = req.getParameter("dep_time");
            String arrTime = req.getParameter("arr_time");
            String gate = req.getParameter("gate");
            String airlaneName = req.getParameter("airlane_name");
            String planeMark = req.getParameter("plane_mark");
            dao.insert(new Departure(id, number, destName, depTime, arrTime, gate, airlaneName, planeMark));
        }

        doGet(req, resp);
    }
}
