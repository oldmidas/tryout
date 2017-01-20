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
		
		//클라이언트가 전달한 값 꺼내기
		String title = req.getParameter("title");
		String writer = req.getParameter("writer");
		String contents = req.getParameter("contents");
		//BoardVO 객체를 생성해서 값 담기
		BoardVO board = new BoardVO();
		board.setTitle(title);
		board.setWriter(writer);
		board.setContents(contents);
		board.setIp(req.getRemoteAddr());
		//BoardDAO의 저장하는 메소드에게 BoardVO 객체 전달해서 DB에 저장시키기
		BoardDAO dao = new BoardDAO();
		try {
			dao.addNewBoard(board);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//목록을 볼수 있는 url을 브라우저에게 응답해주기
		resp.sendRedirect("list.hta");
	}
}
