package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manager.BookDao;
import com.pojo.Register;


@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginController() {
        super();
       
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		BookDao bd=new BookDao();
        Register r=bd.searchUser(email,password);
        
        if(r!=null) {
        	response.sendRedirect("index.jsp");
        }else {
        	response.sendRedirect("login.jsp");
        }
	}

}
