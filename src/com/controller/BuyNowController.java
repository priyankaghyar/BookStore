package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.manager.BookDao;
import com.pojo.Book;


@WebServlet("/BuyNowController")
public class BuyNowController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public BuyNowController() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   String b=request.getParameter("bid");
	   int id=Integer.parseInt(b);
	   BookDao bd=new BookDao();
	   Book book=bd.searchById(id);
	   if(book!=null) {
		   HttpSession h=request.getSession();
		   h.setAttribute("book", book);
		   response.sendRedirect("buynow.jsp");
	   }
	}

}
