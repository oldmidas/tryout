package week1day3practice;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns={"/main.goods"})
public class MainServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html lang='kor'>");
		out.println("<head><meta charset='utf-8'><title>�α���</title></head>");
		out.println("<body>");
		
		if (session == null) {
			if ("wrong".equals(req.getParameter("err"))) {
				out.println("<h6 style='color:red;'>���̵� Ȥ�� ��й�ȣ�� Ʋ���ϴ�.</h6>");	
			} else if ("err".equals(req.getParameter("err"))) {
				out.println("<h6 style='color:red;'>�α����� �ʿ��մϴ�.</h6>");					
			} else if ("auth".equals(req.getParameter("err"))) {
				out.println("<h6 style='color:red;'>�α����� �ʿ��մϴ�.</h6>");									
			}
			out.println("<h1>�α���</h1>");
			out.println("<form method='post' action='loginProcess.goods'>");
			out.println("���̵�:<br/><input type='text' name='id'/><br/>");
			out.println("��й�ȣ:<br/><input type='password' name='pw'/><br/>");
			out.println("<input type='submit' value='�α���'/>");
			out.println("</form>");
			out.println("<h2>�ŸŰԽ���</h2>");
			out.println("<table width='100%' border='1'>");			
			out.println("<tr>");
			out.println("<td>��ȣ</td><td>����</td><td>�ۼ���</td>");
			ProductBoardDAO dao = new ProductBoardDAO();
			try {
				ArrayList<ProductBoardVO> boards = dao.showAllList();
				for (ProductBoardVO board : boards) {
					out.println("<tr>");
					out.println("<td>"+board.getNo()+"</td><td><a href='detail.goods?bno="+board.getNo()+"'>"+board.getTitle()+"</a></td><td>"+board.getWriter()+"</td>");
				}				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			out.println("</table>");
			out.println("<div>");
			out.println("<form action='newBoard.goods'>");
			out.println("<button>�۾���</button>");
			out.println("</form><br/>");			
			out.println("</div>");
			
		} else if (session != null) {
			out.println("<h2> �ݰ����ϴ�, "+session.getAttribute("userName")+"��!</h2>");
			out.println("<h2>�ŸŰԽ���</h2>");
			out.println("<table width='100%' border='1'>");			
			out.println("<tr>");
			out.println("<td>��ȣ</td><td>����</td><td>�ۼ���</td>");
			ProductBoardDAO dao = new ProductBoardDAO();
			try {
				ArrayList<ProductBoardVO> boards = dao.showAllList();
				for (ProductBoardVO board : boards) {
					out.println("<tr>");
					out.println("<td>"+board.getNo()+"</td><td><a href='detail.goods?bno="+board.getNo()+"'>"+board.getTitle()+"</a></td><td>"+board.getWriter()+"</td>");
				}				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			out.println("</table>");			
			out.println("<div>");
			out.println("<form action='newBoard.goods'>");
			out.println("<button>�۾���</button>");
			out.println("</form><br/>");			
			out.println("<form action='logoutProcess.goods'>");
			out.println("<button>�α׾ƿ�</button>");
			out.println("</form>");
			out.println("</div>");			
		} 
		out.println("</body>");			
		out.println("</html>");			
	}
}
