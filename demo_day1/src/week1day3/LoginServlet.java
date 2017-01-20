package week1day3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns={"/login.hta"})
public class LoginServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ��û��ü�� ������ �ִ� seesionId�� �ش��ϴ� HttpSession��ü�� ã�Ƽ� ��ȯ�Ѵ�.
		// ù �湮�̰ų� �α������� ���� ������� ��û�̶�� seesion�� ���� null�̴�.
		HttpSession session = req.getSession(false);
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html lang='kor'>");
		out.println("<head><meta charset='utf-8'><title>�α���</title></head>");
		out.println("<body>");
		
		out.println("<h1>�α���</h1>");
		
		if (session == null) {
			
			String err = req.getParameter("err");
			if (err != null) {
				if ("deny".equals(err)) {
					out.println("<p style='color:red;'>�α����� �ʿ��� �����Դϴ�.</p>");
				} else if ("fail".equals(err)) {
					out.println("<p style='color:red;'>���̵� Ȥ�� ��й�ȣ�� ��ġ���� �ʽ��ϴ�.</p>");
				}
			}
			
			// �α��� ���� �����
			out.println("<form method='post' action='loginprocess.hta'>");
			out.println("���̵�:<br/><input type='text' name='id'/><br/>");
			out.println("��й�ȣ:<br/><input type='password' name='pw'/><br/>");
			out.println("<input type='submit' value='�α���'/>");
			out.println("</form>");
	
		} else {
			// �α��� ���� �����
			String userid = (String) session.getAttribute("loginedId");
			String username = (String) session.getAttribute("loginedName");
			String recentDate = (String) session.getAttribute("recentLoginedDate");
			out.println("<p>[ "+userid+" ]�� ȯ���մϴ�.</p>");
			// session�� ����� �� ������
			out.println("<p>�ֱ� �α��� ��¥ : "+recentDate+"</p>");
			out.println("<li><a href='mail.hta'>�����б�</a></li>");
			out.println("<p><a href='logout.hta'>�α׾ƿ�</a></p>");
		}
		out.println("</body>");
		out.println("</html>");	
	}
}
