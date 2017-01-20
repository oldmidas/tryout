package week1day1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/sample6"})
public class SampleServlet6 extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String title = req.getParameter("title");
		String author = req.getParameter("author");
		String publisher = req.getParameter("publisher");
		int price = Integer.parseInt(req.getParameter("price"));
		String pubdate = req.getParameter("pubdate");
		
		System.out.println(title + author + publisher + price + pubdate);
		
		BookDAO dao = new BookDAO();
		String message ="";
		try {
			dao.addBook(title, author, publisher, price, pubdate);
			message = "å ����� �Ϸ�Ǿ����ϴ�.";
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			message = "å ��� �� ������ �߻��Ͽ����ϴ�.";
		}
		
		// ������������ Ÿ���� �����Ѵ�.
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head><title>��� �ȳ�</title></head>");
		out.println("<body>");
		out.println("<h1>�� å ��� ���</h1>");
		out.println("<p>"+message+"</p>");
		out.println("</body>");
		out.println("</html>");
	}
}
