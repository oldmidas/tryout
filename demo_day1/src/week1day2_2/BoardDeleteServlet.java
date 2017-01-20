package week1day2_2;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(urlPatterns={"/del.hta"})
public class BoardDeleteServlet extends HttpServlet {
	
	public BoardDeleteServlet() {
		System.out.println("BaordDeleteServlet 생성자 실행");
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("BoardDeleteServlet 초기화 함수 실행");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		int bno = Integer.parseInt(req.getParameter("bno"));
		
		resp.setContentType("text/http;charset=utf8");
		BoardDAO dao = new BoardDAO();
		try {
			dao.deleteBoard(bno);		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		resp.sendRedirect("/list.hta");
	}
}
