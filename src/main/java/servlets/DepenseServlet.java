package servlet;

import DAOobj.*;

import java.io.*;
import java.util.List;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.Date;

import objects.*;

public class DepenseServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {
            int idPrevision = Integer.parseInt(request.getParameter("id"));
            int montant = Integer.parseInt(request.getParameter("montant"));
            Date depense = Date.valueOf(request.getParameter("dateDep"));
            DAOdepense dao = new DAOdepense();
            boolean success = dao.save(idPrevision, montant, depense);

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
            RequestDispatcher dispatch = request.getRequestDispatcher("listEmp.jsp");
            dispatch.forward(request, response);
        } catch (Exception e) {
            throw new ServletException(e.getMessage());
        }

    }
}
