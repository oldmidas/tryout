package week1day3practice;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/detail.goods"})
public class ProductDetailServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		int bno = Integer.parseInt(req.getParameter("bno"));
		ProductBoardDAO dao = new ProductBoardDAO();
		ProductBoardVO board = null;
		try {
			board = dao.viewBoardDetail(bno);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head><meta charset='utf-8'/><title>글쓰기 폼</title></head>");
		out.println("<body>");
		out.println("<h1>글 상세정보</h1>");
		
		if (board != null) {
			out.println("<dl>");
			out.println("<dt>번   호</dt><dd>"+board.getNo()+"</dd>");
			out.println("<dt>제   목</dt><dd>"+board.getTitle()+"</dd>");
			out.println("<dt>작성자</dt><dd>"+board.getWriter()+"</dd>");
			out.println("<dt>내   용</dt><dd>"+board.getContents()+"</dd>");
			out.println("<dt>등록일</dt><dd>"+board.getRegdate()+"</dd>");
			out.println("</dl>");
		} else {
			out.println("<p>요청하신 글이 존재하지 않습니다.</p>");
		}
		out.println("<form action='main.goods'><button>목록으로</button></form>");
		out.println("<p><a href='deleteBoard.goods?bno="+bno+"'>삭제하기</a></p>");
		out.println("</body>");
		out.println("</html>");
	}
}