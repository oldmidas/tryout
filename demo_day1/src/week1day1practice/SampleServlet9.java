package week1day1practice;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/sample9"})
public class SampleServlet9 extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		int no = Integer.parseInt(req.getParameter("no"));
		String message = "";
		
		StudentDAO dao = new StudentDAO();
		try {
			ArrayList<StudentVO> students = dao.searchStudentByNO(no);
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out = resp.getWriter();
			message = "�˻� �Ϸ�";
			out.println("<html>");
			out.println("<head><title>�˻� ���</title></head>");
			out.println("<body>");
			out.println("<h1>"+message+"</h1>");
			for(StudentVO student : students) {
				out.println("<ul>");
				out.println("<li>�й�: "+student.getNo()+"</li>");
				out.println("<li>�̸�: "+student.getName()+"</li>");
				out.println("<li>����: "+student.getMajor()+"</li>");
				out.println("<li>�г�: "+student.getGrade()+"</li>");
				out.println("<li>����ó: "+student.getPhone()+"</li>");
				out.println("<li>���̵�: "+student.getId()+"</li>");
				out.println("<li>��й�ȣ: "+student.getPassword()+"</li>");
				out.println("</ul>");
			}
			out.println("</html>");
		} catch (SQLException e) {
			e.printStackTrace();
			message = "�˻� �� �����߻�";	
		}
	}
}
