package servlet;

import DAOobj.*;

import java.io.*;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.util.List;

import objects.*;

public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            RequestDispatcher dispatch;
            String email = request.getParameter("nom");
            String mdp = request.getParameter("mdp");

            if ("example@gmail.com".equals(email) && "example123!".equals(mdp)) {
                DAOprevision daoPrevs = new DAOprevision();
                List<Prevision> prevs = daoPrevs.getAll();
                request.setAttribute("prevs", prevs);
                dispatch = request.getRequestDispatcher("home.jsp");
            } else {
                dispatch = request.getRequestDispatcher("login.jsp");
            }
            dispatch.forward(request, response);
        } catch (Exception e) {
            throw new ServletException(e.getMessage());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            RequestDispatcher dispatch = request.getRequestDispatcher("login.jsp");
            dispatch.forward(request, response);
        } catch (Exception e) {
            throw new ServletException(e.getMessage());
        }
    }
}
