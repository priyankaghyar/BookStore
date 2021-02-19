package com.manager;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.pojo.Admin;
import com.pojo.Book;
import com.pojo.Order;
import com.pojo.Register;

public class BookDao {

	SessionFactory sf=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

	public void saveUser(Register r) {
     Session s=sf.openSession();
     Transaction t=s.beginTransaction();
     s.save(r);
     t.commit();
	    
	}
	
    public void saveBook(Book b) {
    	 Session s=sf.openSession();
         Transaction t=s.beginTransaction();
         s.save(b);
         t.commit();
	}

	public Register searchUser(String em, String pass) {
		 Session s=sf.openSession();
         Transaction t=s.beginTransaction();
         Criteria c=s.createCriteria(Register.class);
         
         c.add(Restrictions.eq("email",em));
         c.add(Restrictions.eq("password",pass));
         
         Register r=(Register) c.uniqueResult();

		return r;
	}

	public Admin searchAdminUser(String em, String pass) {
		Session s=sf.openSession();
        Transaction t=s.beginTransaction();
        Criteria c=s.createCriteria(Admin.class);
        c.add(Restrictions.eq("email", em));
        c.add(Restrictions.eq("password", pass));
        Admin r=(Admin)c.uniqueResult();
		return r;
	}
	

    public List<Book> showBooks(){
    	 Session s=sf.openSession();
         Transaction t=s.beginTransaction();
    	Criteria c=s.createCriteria(Book.class);
    	List<Book> l=c.list();
		return l;
    	
    }
	public Book searchById(int id) {
		Session s=sf.openSession();
        Transaction t=s.beginTransaction();
        Criteria c=s.createCriteria(Book.class);
        c.add(Restrictions.eq("bid", id));
        Book a=(Book) c.uniqueResult();
		return a;
		
	}

	public void saveOrder(Order o) {
		Session s=sf.openSession();
        Transaction t=s.beginTransaction();
        s.save(o);
        t.commit();
	}


}
