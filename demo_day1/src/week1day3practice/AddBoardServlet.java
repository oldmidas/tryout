package week1day3practice;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns={"/addBoard.goods"})
public class AddBoardServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		
		if (session == null) {
			resp.sendRedirect("main.goods?err=err");
		} else if (session != null) {
			req.setCharacterEncoding("utf-8");
			
			ProductBoardDAO dao = new ProductBoardDAO();
			try {
				dao.addNewBoard(req.getParameter("title"), (String)session.getAttribute("userName"), req.getParameter("contents"));
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			resp.sendRedirect("main.goods");
		}
	}
}
