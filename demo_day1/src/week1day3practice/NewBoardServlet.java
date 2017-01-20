package week1day3practice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns={"/newBoard.goods"})
public class NewBoardServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		
		if (session == null) {
			resp.sendRedirect("main.goods?err=err");
		} else if (session != null) {
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head><meta charset='utf-8'/><title>�۾���</title></head>");
			out.println("<body>");
			out.println("<h1>�� �� ���</h1>");
			out.println("<form method='post' action='addBoard.goods'>");
			out.println("������	:<input type='text' name='title'/><br/>");
			out.println("�۳���	:<textarea name='contents' rows='3' cols='40'></textarea><br/>");
			out.println("<button>���</button>");
			out.println("</form>");
			out.println("<p><a href='main.goods'>���ư���</a></p>");
			out.println("</body>");
			out.println("</html>");
		}
	}
}
