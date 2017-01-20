package week1day3practice;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns={"/deleteBoard.goods"})
public class DeleteBoardServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		req.setCharacterEncoding("utf-8");
		int bno = Integer.parseInt(req.getParameter("bno"));
		int result = 0;
		String userName;
		if (session == null) {
			resp.sendRedirect("main.goods?err=auth");
		} else if (session != null) {
			ProductBoardDAO dao = new ProductBoardDAO();
			try {
				userName = (String)session.getAttribute("userName");
				result = dao.deleteBoard(bno, userName);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (result == 0) {
				resp.sendRedirect("main.goods?err=auth");
			} else if (result == 1) {
				resp.sendRedirect("main.goods");
			}
		}
	}
}
