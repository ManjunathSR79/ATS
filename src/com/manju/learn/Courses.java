package com.manju.learn;
 

import javax.swing.JOptionPane;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.paango.dao.AssignCustomers;
import com.paango.dao.CoursesDAO;
import com.paango.dao.Requirements;
import com.paango.dao.Customers;
import com.paango.dao.Ratings;


/** 
 * Servlet implementation class Courses
 */
@WebServlet("/Courses")
@MultipartConfig(maxFileSize = 21665)

public class Courses extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpServletResponse response;
	/**
	 * Default constructor.
	 */

	public Courses() {
		
 // TODO Auto-generated constructor stub
	}
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String type=(String)request.getParameter("type");
		
		 
	 switch(type)
	 {
	 case "projects" :
		
		 CoursesDAO course=new  CoursesDAO();
		 
		course.setProjectId(request.getParameter("pid"));
		course.setProjectDescription(request.getParameter("pdesc"));
		course.setProjectName(request.getParameter("pname"));
		course.setProjectMail(request.getParameter("pmail"));
		course.setProjectDate(request.getParameter("pdate"));
		
		 
		 
		
		 int res=0;
		 res=course.check("jdbc:mysql://localhost:3306/paango?autoReconnect=true");
		if(res==1){
			course.insert("jdbc:mysql://localhost:3306/paango?autoReconnect=true");}
				else
		{
			 
			System.out.println ("<html><body><script>alert('Duplicate ID');</script></body></html>");
		}
		RequestDispatcher dispatcher=request.getRequestDispatcher("/mainPage.jsp");
		dispatcher.forward(request, response);
		break;
		case "requirements" :
		
		Requirements req=new  Requirements();
		 
		req.setRId(request.getParameter("rid"));
		req.setRequirement(request.getParameter("rreq"));
		 
		req.setRMail(request.getParameter("rmail"));
		req.setRDate(request.getParameter("rdate"));
		 
		 
		 
		

		   res=0;
		 res=req.check("jdbc:mysql://localhost:3306/paango?autoReconnect=true");
		if(res==1){
			req.insert("jdbc:mysql://localhost:3306/paango?autoReconnect=true");}
				else
		{
			 
			System.out.println ("<html><body><script>alert('Duplicate ID');</script></body></html>");
		}
		  dispatcher=request.getRequestDispatcher("/mainPage.jsp");
		dispatcher.forward(request, response);
		
		
		
		
		
		
		
		break;
		case "customers" :
		
		 Customers c=new  Customers();
		 
			c.setId(request.getParameter("cid"));
			c.setName(request.getParameter("cname"));
			c.setMail(request.getParameter("cmail"));
			c.setPhone(request.getParameter("cphone"));
			c.setTitle(request.getParameter("ctitle"));
			c.setCompany(request.getParameter("ccompany"));
			c.setNotes(request.getParameter("cnotes"));
			c.setPicture(request.getParameter("cpicture"));
			c.setLinkedin(request.getParameter("clinkedin"));
			c.setFacebook(request.getParameter("cfacebook"));
			c.setTwitter(request.getParameter("ctwitter"));
			 
			
			  res=0;
			 res=c.check("jdbc:mysql://localhost:3306/paango?autoReconnect=true");
			if(res==1){
				c.insert("jdbc:mysql://localhost:3306/paango?autoReconnect=true");}
					else
			{
				 
				System.out.println ("<html><body><script>alert('Duplicate ID');</script></body></html>");
			}
			dispatcher=request.getRequestDispatcher("/mainPage.jsp");
			dispatcher.forward(request, response);
			
		
		break;
		case "ratings" :
		Ratings r=new Ratings();
		r.setRate(request.getParameter("rating"));
		
		
		r.insert("jdbc:mysql://localhost:3306/paango?autoReconnect=true");
		
		break;
		case "assigncustomers" :
			
			AssignCustomers a=new AssignCustomers();
			a.setPId(request.getParameter("pid"));
			a.setCId(request.getParameter("cid"));
			a.insert("jdbc:mysql://localhost:3306/paango?autoReconnect=true");
			 
			dispatcher=request.getRequestDispatcher("/mainPage.jsp");
			dispatcher.forward(request, response);
			 
			 
		
		default :
			dispatcher=request.getRequestDispatcher("/mainPage.jsp");
			dispatcher.forward(request, response);
		
		
	 }
		 

		
		
	}
	
	 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}
		
	
		
		
	/** 
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	 
		
 
	}





	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	}
}
