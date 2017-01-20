package week1day2_2;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/list.hta"})
public class BoardListServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head><meta charset='utf-8'><title>�� �� �� �� ��</title></head>");
		out.println("<body>");
		out.println("<h1>���� �Խ���</h1>");
		out.println("<table width='100%' border='1'>");
		out.println("<tr>");
		out.println("<th>��ȣ</th><th>����</th><th>�ۼ���</th><td>����</td>");
		BoardDAO dao = new BoardDAO();
		try {
			ArrayList<BoardVO> boards = dao.getAllBoards();
			for (BoardVO board : boards) {
				int no = board.getNo();
				String title = board.getTitle();
				Date regdate = board.getRegdate();
				out.println("<tr>");
				out.println("<th>"+no+"</th>");
				out.println("<th><a href='detail.hta?bno="+no+"'>"+title+"</a></th>");
				out.println("<th>"+regdate+"</th>");
				out.println("<td><a href='del.hta?bno="+no+"'>����</a></td>");
				out.println("</tr>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		out.println("</tr>");
		out.println("</table>");
		out.println("<p><a href='form.hta'>�۾���</a></p>");
		out.println("</body>");		
		out.println("</html>");
	}
}
