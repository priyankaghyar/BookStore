package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manager.BookDao;
import com.pojo.Register;

@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RegisterController() {
        
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String name=request.getParameter("name");
	String email=request.getParameter("email");
	String password=request.getParameter("password");
	String address=request.getParameter("address");
	
	Register r=new Register();
	
	r.setName(name);
	r.setEmail(email);
	r.setPassword(password);
	r.setAddress(address);
	
	BookDao bd=new BookDao();
	bd.saveUser(r);


	}

}
