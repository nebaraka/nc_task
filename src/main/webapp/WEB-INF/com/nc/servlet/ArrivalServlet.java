package com.nc.servlet;

import com.nc.model.Arrival;
import com.nc.DAO.ArrivalDAO;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ArrivalServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrivalDAO dao = new ArrivalDAO();
        List<Arrival> lst = dao.getAll();
        req.setAttribute("arrLst", lst);
        getServletContext().getRequestDispatcher("/arrivals.jsp").forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrivalDAO dao = new ArrivalDAO();
        if (req.getParameter("delete") != null) {
            dao.delete(Integer.parseInt(req.getParameter("delete")));
        } else {
            int id = Integer.parseInt(req.getParameter("id"));
            String number = req.getParameter("number");
            String destName = req.getParameter("dest_name");
            String arrTime = req.getParameter("arr_time");
            String depTime = req.getParameter("dep_time");
            String gate = req.getParameter("gate");
            String airlaneName = req.getParameter("airlane_name");
            String planeMark = req.getParameter("plane_mark");
            dao.insert(new Arrival(id, number, destName, arrTime, depTime, gate, airlaneName, planeMark));
        }

        doGet(req, resp);
    }
}
