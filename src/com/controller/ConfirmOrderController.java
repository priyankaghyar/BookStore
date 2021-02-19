package com.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.manager.BookDao;
import com.pojo.Book;
import com.pojo.Order;
import com.pojo.Register;

@WebServlet("/ConfirmOrderController")
public class ConfirmOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ConfirmOrderController() {
        super();
      
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String p=ConfirmOrderController.generateRandomPassword();
		Date d=new Date(0,0,0);
		HttpSession h=request.getSession();
		Register r=(Register) h.getAttribute("user");
		Book b=(Book) h.getAttribute("book");
		Order o=new Order();
		o.setOrderId(p);
		o.setOrderDate(d);
		o.setRegister(r);
		o.setBook(b);
		BookDao bd=new BookDao();
		bd.saveOrder(o);
        response.sendRedirect("successful.jsp");
	}

	private static String generateRandomPassword() {
		return null;
		
	}

}
