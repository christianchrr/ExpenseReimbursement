package com.revature.christian.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.christian.dao.UsersDAOImpl_postgre;
import com.revature.christian.model.Users;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		UsersDAOImpl_postgre dao = new UsersDAOImpl_postgre();
		
	    response.setContentType("text/html");  
	    PrintWriter out = response.getWriter(); 
	          
	    String n = request.getParameter("userName");  
	    String p = request.getParameter("userPass");
	    
	    session.setAttribute("userName", n);
	    
	    Users user = new Users();
	    user = dao.selectUsersLogin(n, p);
	          
	    if(user != null && user.getUser_type().equals("Employee")){  
	        RequestDispatcher rd=request.getRequestDispatcher("/employeeHome.html");  
	        rd.forward(request, response);
	    } else if(user != null && user.getUser_type().equals("Manager")) {
	    	RequestDispatcher rd=request.getRequestDispatcher("/managerHome.html");  
	        rd.forward(request, response);
	    } else{ 
	        out.print("<div style='color:red;'>Incorrect User Name or Password</div>");
	        RequestDispatcher rd=request.getRequestDispatcher("/index.html");  
	        rd.include(request, response);           
	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
