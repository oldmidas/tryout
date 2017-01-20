package week1day1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/sample7"})
public class SampleServlet7 extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String pub_name = req.getParameter("pub_name");
		//���� �������� Ÿ���� �����Ѵ�.
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head><title>��� �ȳ�</title></head>");
		out.println("<body>");
		out.println("<h1>�˻� ���</h1>");
		out.println("<ul>");			
		try {
			BookDAO dao = new BookDAO();
			ArrayList<BookVO> books = dao.searchBooksByPubName(pub_name);
			for (BookVO book : books) {			
				out.println("<li> ��ȣ : "+book.getNo()+"</li>");
				out.println("<li> ���� : "+book.getTitle()+"</li>");
				out.println("<li> �۰� : "+book.getAuthor()+"</li>");
				out.println("<li> ���ǻ� : "+book.getPublisher()+"</li>");
				out.println("<li> ���� : "+book.getPrice()+"</li>");
				out.println("<li> ������ : "+book.getDate()+"</li>");
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		out.println("<ul>");
		out.println("</body>");
		out.println("</html>");
	}
}
