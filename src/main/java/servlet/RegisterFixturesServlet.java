package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FixturesDAO;
import dto.Fixtures;

/**
 * Servlet implementation class RegisterStudentServlet
 */
@WebServlet("/RegisterFixturesServlet")
public class RegisterFixturesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterFixturesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 文字コードの設定
		request.setCharacterEncoding("UTF-8");
		
		// フォーム入力内容の取得
		String fixtures_id = request.getParameter("id");
		String fixtures_name = request.getParameter("fixtures_name");
		String quantity = request.getParameter("quantity");
		String category = request.getParameter("category");
		String content = request.getParameter("content");

		int Fixtures_id = Integer.parseInt(fixtures_id);
		int Quantity = Integer.parseInt(quantity);
		// 入力された情報を元にインスタンスを生成
		Fixtures fix = new Fixtures(Fixtures_id, fixtures_name, Quantity, category, content);
		
		// SQL実行
		int result = FixturesDAO.registerFixtures(fix);
		
		if(result == 1) {
			String view = "WEB-INF/view/success.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
		} else {
			String view = "WEB-INF/view/fail.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
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
