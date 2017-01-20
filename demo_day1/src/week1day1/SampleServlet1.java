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
		System.out.println("SampleServlet�� doGet() �޼ҵ尡 �����...");
		
		// Ŭ���̾�Ʈ�� html ������ �����ϱ�
		Date now = new Date();
		
		//Ŭ���̾�Ʈ�� �������� ���(����)�ϴ� ��Ʈ�� ���
		PrintWriter out = resp.getWriter();
		//��Ʈ���� ȭ�椷�ؼ� Ŭ���̾�Ʈ�� ������ ��������
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
