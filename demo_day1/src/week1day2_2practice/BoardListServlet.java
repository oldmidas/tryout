package week1day2_2practice;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/main.java"})
public class BoardListServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head><meta charset='utf-8'><title>Welcome To Java Temple!</title></head>");
		out.println("<body>");
		out.println("<h1>System.out.println(\"Hello, world!\");</h1>");
		out.println("<table width='100%' border='1'>");
		out.println("<tr>");
		out.println("<th>번호</th><th>제목</th><th>작성자</th>");

		BoardDAO dao = new BoardDAO();
		try {
			ArrayList<BoardVO> boards = dao.listAllBoard();
			if (boards != null) {
				for (BoardVO board : boards) {				
					out.println("<tr>");
					out.println("<th>"+board.getNo()+"</th><th><a href='detail.java?bno="+board.getNo()+"'>"+board.getTitle()+"</a></th><th>"+board.getWriter()+"</th>");
				}
			}			
		} catch(SQLException e) {
			e.printStackTrace();
			out.println("<p>오류 발생</p>");
		}
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		
	}
}
