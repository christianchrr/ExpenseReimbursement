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
 * Servlet implementation class EmployeeUpdateInformation
 */
public class EmployeeUpdateInformation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeUpdateInformation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsersDAOImpl_postgre dao = new UsersDAOImpl_postgre();
		
	    response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();
	    
	    String first = request.getParameter("first");  
	    String last = request.getParameter("last");
	    String username = request.getParameter("userName");
	    String password = request.getParameter("userPass");
	    
	    HttpSession session = request.getSession();
	    String userName = (String) session.getAttribute("userName");
	    
	    Users user = dao.getUsers(userName);
	    
	    if (dao.updateUsers(user, first, last, username, password)) {
	    	session.setAttribute("userName", username);
	    	user = dao.selectUsersLogin(username, password);
	    	RequestDispatcher rd=request.getRequestDispatcher("ViewInformation");  
	    	rd.forward(request, response);
	    } else {
	        out.print("<div style='color:red;'>Failed To Update</div>");
	        RequestDispatcher rd=request.getRequestDispatcher("/employeeUpdateForm.html");  
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
