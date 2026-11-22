package example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import example.beans.User;
import example.beans.UserValidator;

/**
 * Servlet implementation class ValidationServlet
 */
@WebServlet("/doValidate")
public class ValidationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		//capturing user parameters
		String userName = request.getParameter("uid");
		String userPassword = request.getParameter("password");
		
		User currentUser = new User(userName, userPassword);
		UserValidator.isValid(currentUser);
		boolean success = UserValidator.isValid(currentUser);
		
		String responseText = "<h3 color='red'>Authentication Failed. </h3>";
		if (success) responseText ="<h3 color='green'>Authentication Successful. </h3>";
		
		
		out.println(responseText);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
