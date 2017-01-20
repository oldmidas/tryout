package week1day2_2;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/detail.hta"})
public class BoardDetailServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ������������� Ŭ���� �Խñ��� ��ȣ �˾Ƴ���
		int bno = Integer.parseInt(req.getParameter("bno"));
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head><meta charset='utf-8'/><title>�۾��� ��</title></head>");
		out.println("<body>");
		out.println("<h1>�� ������</h1>");		
		BoardDAO dao = new BoardDAO();
		try {
			BoardVO board = dao.getBoardByNo(bno);
			if (board != null) {
				out.println("<dl>");
				out.println("<dt>��   ȣ</dt><dd>"+board.getNo()+"</dd>");
				out.println("<dt>��   ��</dt><dd>"+board.getTitle()+"</dd>");
				out.println("<dt>�ۼ���</dt><dd>"+board.getWriter()+"</dd>");
				out.println("<dt>��õ��</dt><dd>"+board.getLikes()+"</dd>");
				out.println("<dt>��   ��</dt><dd>"+board.getContents()+"</dd>");
				out.println("<dt>�����</dt><dd>"+board.getRegdate()+"</dd>");
				out.println("<dt>������</dt><dd>"+board.getIp()+"</dd>");
				out.println("</dl>");
			} else {
				out.println("<p>��û�Ͻ� ���� �������� �ʽ��ϴ�.</p>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		out.println("<button>���</button>");
		out.println("</form>");
		out.println("<p><a href='list.hta'>���ư���</a></p>");
		out.println("</body>");
		out.println("</html>");
	}
}
