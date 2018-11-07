package com.nc.servlet;

import com.nc.DAO.PlaneDAO;
import com.nc.model.Plane;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PlaneServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PlaneDAO dao = new PlaneDAO();
        List<Plane> lst = dao.getAll();
        req.setAttribute("plnLst", lst);
        getServletContext().getRequestDispatcher("/planes.jsp").forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PlaneDAO dao = new PlaneDAO();
        if (req.getParameter("delete") != null) {
            dao.delete(Integer.parseInt(req.getParameter("delete")));
        } else {
            int id = Integer.parseInt(req.getParameter("id"));
            String modelName = req.getParameter("model_name");
            int seatsAmount = Integer.parseInt(req.getParameter("seats_amount"));
            String mark = req.getParameter("mark");
            String airlane = req.getParameter("airlane");
            int radius = Integer.parseInt(req.getParameter("radius"));
            dao.insert(new Plane(id, modelName, seatsAmount, mark, airlane, radius));
        }

        doGet(req, resp);
    }
}
