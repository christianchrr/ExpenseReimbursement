package com.revature.christian.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.christian.dao.UsersDAOImpl_postgre;
import com.revature.christian.model.Users;

/**
 * Servlet implementation class ViewInformation
 */
public class ViewInformation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewInformation() {
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
	    
	    HttpSession session = request.getSession();
	    String userName = (String) session.getAttribute("userName");
	    
	    Users user = dao.getUsers(userName);
	    
	    String first = user.getUser_first();
	    String last = user.getUser_last();
	    String username = user.getUser_username();
	    String type = user.getUser_type();
	    
//	    out.print("<head><link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6\" crossorigin=\"anonymous\"></head>");
	    out.print("<h1>Info</h1>");
	    out.print(
	    		"<p><u><b>Name:</b></u></p>" 
	    		+ first + " " + last 
	    		+ "<br>" 
	    		+ "<p><u><b>User Name:</b></u></p>" 
	    		+ username 
	    		+ "<br>" 
	    		+ "<p><u><b>Title:</b></u></p>" 
	    		+ type
	    );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
