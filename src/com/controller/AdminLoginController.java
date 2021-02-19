package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manager.BookDao;
import com.pojo.Admin;
import com.pojo.Register;


@WebServlet("/AdminLoginController")
public class AdminLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AdminLoginController() {
        super();
       
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		BookDao bd=new BookDao();
        Admin a=bd.searchAdminUser(email,password);
	}

}