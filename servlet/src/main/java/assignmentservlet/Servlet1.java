package assignmentservlet;


import java.io.*;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
	protected void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		out.println("<h2>Name: " + name + "</h2>");
		out.println("<h2>Password: " + password + "</h2>");
	}

}
