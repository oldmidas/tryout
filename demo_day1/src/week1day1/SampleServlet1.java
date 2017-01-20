package week1day1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/sample"})
public class SampleServlet1 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("SampleServlet의 doGet() 메소드가 실행됨...");
		
		// 클라이언트로 html 컨텐츠 제공하기
		Date now = new Date();
		
		//클라이언트로 컨텐츠를 출력(전송)하는 스트림 얻기
		PrintWriter out = resp.getWriter();
		//스트림을 화룡ㅇ해서 클라이언트로 데이터 내보내기
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Current Time</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Current Time is "+now+"</h1>");
		out.println("</body>");
		out.println("</html>");
	}
}
