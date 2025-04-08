package servlet;

import java.io.*;
import java.util.List;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import DAOobj.DAOprevision;
import java.sql.Date;
import objects.Prevision;

public class PrevisionServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            if (request.getParameter("montant") != null) {
                String nom = request.getParameter("nom");
                int montant = Integer.parseInt(request.getParameter("montant"));
                Date debut = Date.valueOf(request.getParameter("dateDebut"));
                Date fin = Date.valueOf(request.getParameter("dateFin"));
                DAOprevision dao = new DAOprevision();
                boolean success = dao.save(nom, montant, debut, fin);

                DAOprevision daoPrevs = new DAOprevision();
                List<Prevision> prevs = daoPrevs.getAll();
                request.setAttribute("prevs", prevs);
            } else {
                DAOprevision daoPrevs = new DAOprevision();
                List<Prevision> prevs = daoPrevs.getAll();
                request.setAttribute("prevs", prevs);
            }
            RequestDispatcher dispatch = request.getRequestDispatcher("home.jsp");
            dispatch.forward(request, response);
        } catch (Exception e) {
            throw new ServletException(e.getMessage());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            DAOprevision dao = new DAOprevision();
            List<Prevision> prevs = dao.getAll();
            request.setAttribute("prevs", prevs);
            RequestDispatcher dispatch = request.getRequestDispatcher("home.jsp");
            dispatch.forward(request, response);
        } catch (Exception e) {
            throw new ServletException(e.getMessage());
        }
    }
}
