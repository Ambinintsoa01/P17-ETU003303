package servlet;

import DAOobj.*;

import java.io.*;
import java.util.List;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.Date;

import objects.*;

public class EtatServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            DAOprevision daoPrevs = new DAOprevision();
            List<Prevision> prevs = daoPrevs.getAll();
            request.setAttribute("prevs", prevs);
            RequestDispatcher dispatch = request.getRequestDispatcher("home.jsp");
            dispatch.forward(request, response);
        } catch (Exception e) {
            throw new ServletException(e.getMessage());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            DAOetat daoEtat = new DAOetat();
            List<Etat> deps = daoEtat.getAll();
            request.setAttribute("deps", deps);
            RequestDispatcher dispatch = request.getRequestDispatcher("listEmp.jsp");
            dispatch.forward(request, response);
        } catch (Exception e) {
            throw new ServletException(e.getMessage());
        }
    }
}
