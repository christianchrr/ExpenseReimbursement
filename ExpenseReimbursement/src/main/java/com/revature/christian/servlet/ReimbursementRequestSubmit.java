package com.revature.christian.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.christian.dao.ReimbursementsDAOImpl_postgre;
import com.revature.christian.dao.UsersDAOImpl_postgre;
import com.revature.christian.model.Users;

/**
 * Servlet implementation class ReimbursementRequestSubmit
 */
public class ReimbursementRequestSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReimbursementRequestSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsersDAOImpl_postgre udao = new UsersDAOImpl_postgre();
		ReimbursementsDAOImpl_postgre rdao = new ReimbursementsDAOImpl_postgre();
		
	    response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();
	    
	    HttpSession session = request.getSession();
	    String userName = (String) session.getAttribute("userName");
	    
	    Users user = udao.getUsers(userName);
	    Integer id = user.getUser_id();
	    
	    String status = "Pending";
	    
	    String reason = request.getParameter("reason");  
	    Double amount = Double.parseDouble(request.getParameter("amount"));
	    
	    rdao.insertIntoReimbursements(user, reason, amount, status);
	    
	    RequestDispatcher rd=request.getRequestDispatcher("EmployeeShowReimbursements");  
    	rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
