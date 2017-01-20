package week1day3;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns={"/loginprocess.hta"})
public class LoginProcessServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ���̵�/��й�ȣ ��������
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		
		// ���������� ���̵�/ ��й�ȣ�� ��ġ�ϴ��� üũ�ϱ�
		if ("james".equals(id) && "1234".equals(pwd)) {
			
			// HttpSession �����ϱ�
			HttpSession session = req.getSession(true);
			session.setMaxInactiveInterval(60*1);
			System.out.println("���� ���̵�: "+session.getId());
			
			// HttpSession ��ü�� ����� �ſ� ���� �����ϱ�
			session.setAttribute("loginedId", id);
			session.setAttribute("loginedName", "ȫ�浿");
			session.setAttribute("recentLoginedDate", "2017.01.11");
			
			// ����� ��û�� redirection ��Ű��
			resp.sendRedirect("login.hta");
		} else {
			resp.sendRedirect("login.hta?err=fail");
		}
	}
}
