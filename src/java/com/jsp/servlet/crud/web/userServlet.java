package com.jsp.servlet.crud.web;

import com.jsp.servlet.crud.controller.UserDao;
import com.jsp.servlet.crud.model.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class userServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;    
    private UserDao userDao;
    
    public void init(){
        userDao = new UserDao();
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        doGet(request, response);
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try {
            String action = request.getServletPath();
            
            switch (action){
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertUser(request, response);
                    break;
                default:
                    listUser(request, response);
                    break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(userServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    private void listUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
        List<User> listUser = userDao.getAllUser();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
        dispatcher.forward(request, response);
    }
    
    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
        dispatcher.forward(request, response);
    }
    
    private void insertUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User newUser = new User(name, email, country);
        userDao.saveUser(newUser);
        response.sendRedirect("list");
    }
}   
