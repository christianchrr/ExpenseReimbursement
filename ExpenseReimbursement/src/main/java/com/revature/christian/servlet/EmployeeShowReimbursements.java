package com.revature.christian.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.christian.dao.ReimbursementsDAOImpl_postgre;
import com.revature.christian.dao.UsersDAOImpl_postgre;
import com.revature.christian.model.Reimbursements;
import com.revature.christian.model.Users;

/**
 * Servlet implementation class EmployeeShowReimbursements
 */
public class EmployeeShowReimbursements extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeShowReimbursements() {
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
	    
	    List<Reimbursements> reimbursements = rdao.getAllReimbursementsById(id);
	    
//	    out.print("<head><link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6\" crossorigin=\"anonymous\"></head>");
	    out.print("<h1>Reimbursements</h1>");
	    reimbursements.forEach((reimbursement) -> out.print(
	    		"<p><u><b>Amount:</b></u></p>"
	    		+ "$" + reimbursement.getAmount()
	    		+ "<br>" 
	    		+ "<p><u><b>Reason:</b></u></p>"  
	    		+ reimbursement.getReason()
	    		+ "<br>" 
	    		+ "<p><u><b>Status:</b></u></p>" 
	    		+ reimbursement.getStatus()
	    		+ "<br>"
	    		+ "<b>====================</b>"
	    		+ "<br>")
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
