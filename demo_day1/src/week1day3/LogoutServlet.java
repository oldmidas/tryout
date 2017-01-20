package week1day3;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns={"/logout.hta"})
public class LogoutServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		// ��û ��ü�� ����� ���Ǿ��̵� �ش��ϴ� ���ǰ�ü ã��
		HttpSession session = req.getSession(false);
		
		if (session != null) {
			// �˻��� ���ǰ�ü�� ��ȿȭ��Ų��.
			session.invalidate();
		}
		resp.sendRedirect("day3.html");
	}
}
