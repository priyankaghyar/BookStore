package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manager.BookDao;
import com.pojo.Book;


@WebServlet("/AddBookController")
public class AddBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public AddBookController() {
        super();
        
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String bookid=request.getParameter("bookid");	
	    String bookname=request.getParameter("bookname");	
	    String bookauthor=request.getParameter("bookauthor");	
	    String bookprice=request.getParameter("bookprice");	
	    
	    double price=Double.parseDouble(bookprice);
	    Book b=new Book();
	    
	    b.setBookId(bookid);
	    b.setBookName(bookname);
	    b.setAuthor(bookauthor);
	    b.setPrice(price);
	    BookDao bd=new BookDao();
	    bd.saveBook(b);

	}

}
