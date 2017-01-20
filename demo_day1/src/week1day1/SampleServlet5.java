package week1day1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/sample5"})
public class SampleServlet5 extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String house = req.getParameter("house");
		String gender = req.getParameter("gender");
		String memo = req.getParameter("memo");
		System.out.println("사  는 곳 : "+house);
		System.out.println("성      별 : "+gender);
		System.out.println("자기소개 : "+memo);
	}
		
}
