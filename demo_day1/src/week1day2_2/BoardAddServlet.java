package week1day2_2;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/add.hta"})
public class BoardAddServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		//Ŭ���̾�Ʈ�� ������ �� ������
		String title = req.getParameter("title");
		String writer = req.getParameter("writer");
		String contents = req.getParameter("contents");
		//BoardVO ��ü�� �����ؼ� �� ���
		BoardVO board = new BoardVO();
		board.setTitle(title);
		board.setWriter(writer);
		board.setContents(contents);
		board.setIp(req.getRemoteAddr());
		//BoardDAO�� �����ϴ� �޼ҵ忡�� BoardVO ��ü �����ؼ� DB�� �����Ű��
		BoardDAO dao = new BoardDAO();
		try {
			dao.addNewBoard(board);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//����� ���� �ִ� url�� ���������� �������ֱ�
		resp.sendRedirect("list.hta");
	}
}
