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
		out.println("<head><meta charset='utf-8'/><title>�۾��� ��</title></head>");
		out.println("<body>");
		out.println("<h1>�� ������</h1>");
		
		if (board != null) {
			out.println("<dl>");
			out.println("<dt>��   ȣ</dt><dd>"+board.getNo()+"</dd>");
			out.println("<dt>��   ��</dt><dd>"+board.getTitle()+"</dd>");
			out.println("<dt>�ۼ���</dt><dd>"+board.getWriter()+"</dd>");
			out.println("<dt>��   ��</dt><dd>"+board.getContents()+"</dd>");
			out.println("<dt>�����</dt><dd>"+board.getRegdate()+"</dd>");
			out.println("</dl>");
		} else {
			out.println("<p>��û�Ͻ� ���� �������� �ʽ��ϴ�.</p>");
		}
		out.println("<form action='main.goods'><button>�������</button></form>");
		out.println("<p><a href='deleteBoard.goods?bno="+bno+"'>�����ϱ�</a></p>");
		out.println("</body>");
		out.println("</html>");
	}
}