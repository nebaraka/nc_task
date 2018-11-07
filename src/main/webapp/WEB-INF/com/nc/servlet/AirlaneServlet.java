package com.nc.servlet;

import com.nc.DAO.AirlaneDAO;
import com.nc.model.Airlane;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AirlaneServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AirlaneDAO dao = new AirlaneDAO();
        List<Airlane> lst = dao.getAll();
        req.setAttribute("lst", lst);
        getServletContext().getRequestDispatcher("/airlanes.jsp").forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AirlaneDAO dao = new AirlaneDAO();
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String country = req.getParameter("country");
        dao.insert(new Airlane(id, name, country));

        doGet(req, resp);
    }
}
