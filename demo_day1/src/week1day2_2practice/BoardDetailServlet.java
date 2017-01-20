package week1day2_2practice;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/detail.java"})
public class BoardDetailServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		int no = Integer.parseInt(req.getParameter("bno"));
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head><meta charset='utf-8'><title>Welcome To Java Temple!</title></head>");
		out.println("<body>");
		out.println("<h1>System.out.println(\"Hello, world!\");</h1>");
		out.println("<table width='100%' border='1'>");
		out.println("<tr>");
		BoardDAO dao = new BoardDAO();
		try {			
			BoardVO board = dao.openClikedBoard(no);
			if (board != null) {
				out.println("<th>"+board.getNo()+"</th><th>"+board.getTitle()+"</th><th>"+board.getWriter()+"</th><th>"+board.getDate()+"</th></tr>");
				out.println("<tr>");
				out.println("<th>"+board.getContents()+"</th></tr>");
				out.println("<form action='main.java'><button>목록으로</button></form>");
			} else {
				out.println("<p>글이 존재하지 않습니다.</p>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		out.println("<tr>");
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
	}
}
