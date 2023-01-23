package login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AccountDAO;
import dto.Account;
import util.GenerateHashedPw;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		request.getParameter("UTF-8");

		String mail = request.getParameter("mail");
		String pw = request.getParameter("pw");

		// 入力されたIDをもとにソルトを取得する。
		String salt = AccountDAO.getSalt(mail);

		// 取得したソルトがnullの場合は対象のユーザがいないので、Errorでログイン画面に戻す
		if (salt == null) {
			String view = "./?error=1";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
			return;
		}
		String hashedPw = GenerateHashedPw.getSafetyPassword(pw, salt);

		Account parent = AccountDAO.login(mail, hashedPw);

		// 取得したソルトがnullの場合は対象のユーザがいないので、Errorでログイン画面に戻す
		if (parent == null) {
			String view = "./?error=1";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);

		} else if (parent.getMail().equals("admin@g.com")) {

			HttpSession session = request.getSession();
			session.setAttribute("admin", parent);
			String view = "WEB-INF/view/parent-menu.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);

		} else {
			HttpSession session = request.getSession();
			session.setAttribute("user", parent);
			String view = "WEB-INF/view/main-menu.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}