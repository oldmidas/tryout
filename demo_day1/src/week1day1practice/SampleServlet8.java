package week1day1practice;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/sample8"})
public class SampleServlet8 extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String name = req.getParameter("name");
		String major = req.getParameter("major");
		int grade = Integer.parseInt(req.getParameter("grade"));
		String phone = req.getParameter("phone");
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		
		StudentVO student = new StudentVO(0, name, major, grade, phone, id, password);
		StudentDAO dao = new StudentDAO();
		String message = "";
		try {
			dao.addStudent(student);
			message = "업데이트 성공";
		} catch (SQLException e) {
			e.printStackTrace();
			message = "업데이트 중 오류 발생";
		}
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.println("<html>");		
		out.println("<head><title>결과 내용</title></head>");
		out.println("<body>");		
		out.println("<h1>등록 결과</h1>");		
		out.println("<p>"+message+"</p>");		
		out.println("</body>");
		out.println("</html>");
	}
}
