package week1day2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/res"})
public class ResponseDemoServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		���� �������� Ÿ�԰� �������ڵ���� �����ϱ�
//		resp.setContentType("text/plain;charset=utf-8");
//		PrintWriter out = resp.getWriter();
//		out.println("�ȳ� ������");

		//���������� ������ �ٽ� ��û�� url�� ����������
		resp.sendRedirect("res2");
		
	}
}