package com.jolopezp.botfluencer.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jolopezp.botfluencer.Application;

/**
 * Servlet implementation class StartWorkflowServlet
 */
@WebServlet("/startWorkflow")
public class StartWorkflowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StartWorkflowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		boolean unfollow = Boolean.valueOf(request.getParameter("unfollow"));
		boolean privatedUsers = Boolean.valueOf(request.getParameter("privatedUsers"));
		
		List<String> targets = new ArrayList<>();
		targets.add(request.getParameter("target1"));
		targets.add(request.getParameter("target2"));
		targets.add(request.getParameter("target3"));
		targets.add(request.getParameter("target4"));
		targets.add(request.getParameter("target5"));
		targets.add(request.getParameter("target6"));
		targets.add(request.getParameter("target7"));
		targets.add(request.getParameter("target8"));
		targets.add(request.getParameter("target9"));
		
		Application.setApplication(unfollow,privatedUsers, targets);
		response.sendRedirect("working.jsp");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
