package week1day2_2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/form.hta"})
public class BoardFormServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head><meta charset='utf-8'/><title>�۾��� ��</title></head>");
		out.println("<body>");
		out.println("<h1>�� �� ��� ��</h1>");
		out.println("<form method='post' action='add.hta'>");
		out.println("������	:<input type='text' name='title'/><br/>");
		out.println("�ۼ���	:<input type='text' name='writer'/><br/>");
		out.println("�۳���	:<textarea name='contents' rows='3' cols='40'></textarea><br/>");
		out.println("<button>���</button>");
		out.println("</form>");
		out.println("<p><a href='list.hta'>���ư���</a></p>");
		out.println("</body>");
		out.println("</html>");
	}
}
