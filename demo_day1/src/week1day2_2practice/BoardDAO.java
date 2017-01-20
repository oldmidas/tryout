package week1day2_2practice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BoardDAO {
	//글쓰기
	public void writeNewBoard(BoardVO board) {
		
	} 
	//글읽어오기
	public ArrayList<BoardVO> listAllBoard() throws SQLException {
		ArrayList<BoardVO> boards = new ArrayList<>();
		String sql = "SELECT NO, TITLE, WRITER FROM TB_JAVABOARD ORDER BY NO DESC";
		Connection con = ConnectionUtil.getConnetion();
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			BoardVO board = new BoardVO();
			board.setNo(rs.getInt("NO"));
			board.setTitle(rs.getString("TITLE"));
			board.setWriter(rs.getString("WRITER"));
			boards.add(board);
		}
		return boards;
	}
	
	//글열기
	public BoardVO openClikedBoard(int no) throws SQLException {
		BoardVO board = null;
		String sql = "SELECT * FROM TB_JAVABOARD WHERE NO = ?";
		Connection con = ConnectionUtil.getConnetion();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, no);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			board = new BoardVO();
			board.setNo(rs.getInt("NO"));
			board.setTitle(rs.getString("TITLE"));
			board.setWriter(rs.getString("WRITER"));
			board.setContents(rs.getString("CONTENTS"));
			board.setDate(rs.getDate("REGDATE"));
		}
		return board;
	}
}
