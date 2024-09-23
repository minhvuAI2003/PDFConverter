package controller;

import model.BO_Converter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

/**
 * Servlet implementation class register
 */
@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private User user;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public register() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String name = request.getParameter("username");
		BO_Converter t = new BO_Converter();
		if (!t.checkemail(email)) {
			t.insert(email, password, name);
			user = new User(email, password, name);
			request.setAttribute("User", user);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		} else {
			PrintWriter out = response.getWriter();
			out.print("<p style=\"margin-top: 16px; color: red;\">Email already existed.\r\n"
					+ "			Please sign-up again</p>");
			request.getRequestDispatcher("/registration.jsp").include(request, response);

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
