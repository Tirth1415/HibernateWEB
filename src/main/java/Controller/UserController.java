package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.UserDao;
import Model.User;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserController() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("Register")) {
			User u = new User();
			u.setName(request.getParameter("Name"));
			u.setContact(Long.parseLong(request.getParameter("Contact")));
			u.setAddress(request.getParameter("Address"));
			u.setEmail(request.getParameter("Email"));
			u.setPassword(request.getParameter("Password"));
			System.out.println(u);

			new UserDao().insertUser(u);
			request.setAttribute("msg", "Account Registered Succesfully");
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}

		else if (action.equalsIgnoreCase("Login")) {
			User u = new User();
			u.setEmail(request.getParameter("Email"));
			u.setPassword(request.getParameter("Password"));

			User u1 = new UserDao().userLogin(u);
			if (u1 == null) {
				request.setAttribute("msg1", "Password is Incorrect");
				request.getRequestDispatcher("Login.jsp").forward(request, response);
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("data", u1);
				request.getRequestDispatcher("Home.jsp").forward(request, response);
			}
		}
	}

}
