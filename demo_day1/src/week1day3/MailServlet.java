package week1day3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns={"/mail.hta"})
public class MailServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ��û��ü�� ����ִ� ���� ���̵�� ���ǰ�ü ã��
		HttpSession session = req.getSession(false);
		
		if (session == null) {
			//System.out.println("���� ����� �α��ε� ����ڸ� ���� �ֽ��ϴ�.");
			resp.sendRedirect("login.hta?err=deny");
		} else {
			String userid = (String) session.getAttribute("loginedId");
			String username = (String) session.getAttribute("loginedName");
			
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			
			out.println("<!DOCTYPE html>");
			out.println("<html lang='kor'>");
			out.println("<head><meta charset='utf-8'><title>����</title></head>");
			out.println("<body>");
			out.println("<h1>"+username+" ("+userid+")���� ���� ����Ʈ</h1>");
			out.println("<p>10���� ���� ���� ������ �ֽ��ϴ�.</p>");
			out.println("</body>");
			out.println("</html>");
			
		}
		
	}
}
