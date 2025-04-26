package com.app.controller;

import com.app.dao.DBConnection;
import com.app.dao.GestionUserDAO;
import com.app.dao.IGestionUserDAO;
import com.app.metier.GestionUser;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet({"/login", "/logout"})
public class AuthentificationController extends HttpServlet {
    private GestionUser gestionUser;

    @Override
    public void init() throws ServletException {
        super.init();
        // Initialize the GestionUser instance with the DAO object for DB access
        IGestionUserDAO userDAO = new GestionUserDAO(DBConnection.getConnection());
        gestionUser = new GestionUser(userDAO);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();

        if ("/logout".equals(path)) {
            // Invalidate the session to log the user out
            HttpSession session = request.getSession();
            session.invalidate();
            response.sendRedirect("login.jsp");  // Redirect to the login page
        } else {
            // If the path isn't logout, we could just forward to login page
            response.sendRedirect("login.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();

        if ("/login".equals(path)) {
            // Get login credentials from the form
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            // Authenticate the user
            if (gestionUser.authenticate(username, password)) {
                // Successful login
                HttpSession session = request.getSession();
                session.setAttribute("user", username);  // Store the user info in the session
                response.sendRedirect("home.jsp");  // Redirect to a welcome page
            } else {
                // Login failed, redirect back with an error (error=true)
                response.sendRedirect("login.jsp?error=true");
            }
        }
    }
}


