package week1day3practice;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns={"/loginProcess.goods"})
public class LoginProcessServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		if ("james".equals(id) && "1234".equals(pw)) {
			HttpSession session = req.getSession(true);
			session.setMaxInactiveInterval(60*1);
			session.setAttribute("userId", id);
			session.setAttribute("userName", "자바창시자");
			
			resp.sendRedirect("main.goods");
		} else {
			resp.sendRedirect("main.goods?err=wrong");
		}
	}
}
