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
		// 아이디/비밀번호 가져오기
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		
		// 가입했을때 아이디/ 비밀번호와 일치하는지 체크하기
		if ("james".equals(id) && "1234".equals(pwd)) {
			
			// HttpSession 생성하기
			HttpSession session = req.getSession(true);
			session.setMaxInactiveInterval(60*1);
			System.out.println("세션 아이디: "+session.getId());
			
			// HttpSession 객체에 사용자 신원 정보 저장하기
			session.setAttribute("loginedId", id);
			session.setAttribute("loginedName", "홍길동");
			session.setAttribute("recentLoginedDate", "2017.01.11");
			
			// 사용자 요청을 redirection 시키기
			resp.sendRedirect("login.hta");
		} else {
			resp.sendRedirect("login.hta?err=fail");
		}
	}
}
