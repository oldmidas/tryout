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
		//응답 컨텐츠의 타입을 지정한다.
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head><title>결과 안내</title></head>");
		out.println("<body>");
		out.println("<h1>검색 결과</h1>");
		out.println("<ul>");			
		try {
			BookDAO dao = new BookDAO();
			ArrayList<BookVO> books = dao.searchBooksByPubName(pub_name);
			for (BookVO book : books) {			
				out.println("<li> 번호 : "+book.getNo()+"</li>");
				out.println("<li> 제목 : "+book.getTitle()+"</li>");
				out.println("<li> 작가 : "+book.getAuthor()+"</li>");
				out.println("<li> 출판사 : "+book.getPublisher()+"</li>");
				out.println("<li> 가격 : "+book.getPrice()+"</li>");
				out.println("<li> 출판일 : "+book.getDate()+"</li>");
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		out.println("<ul>");
		out.println("</body>");
		out.println("</html>");
	}
}
