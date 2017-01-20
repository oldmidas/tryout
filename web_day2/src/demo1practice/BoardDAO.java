package demo1practice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import util.ConnectionUtil;

public class BoardDAO {
	/*
	 * 게시판의 모든 글을 표시하는 DAO
	 */
	public ArrayList<BoardVO> showAllList() throws SQLException {
		ArrayList<BoardVO> boards = new ArrayList<>();
		String sql = "SELECT NO, WRITER, TITLE, CONTENTS FROM TB_BOARD ORDER BY NO DESC";
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			BoardVO board = new BoardVO();
			board.setNo(rs.getInt("NO"));
			board.setWriter(rs.getString("WRITER"));
			board.setTitle(rs.getString("TITLE"));
			board.setContents(rs.getString("CONTENTS"));
			boards.add(board);
		}
		rs.close();
		pstmt.close();
		con.close();
		
		return boards;
	}
	
	/*
	 *  게시판에 새로운 글을 더하는 DAO
	 */
	public void addNewBoard(BoardVO board) throws SQLException {
		String sql = "INSERT INTO TB_BOARD(NO, TITLE, WRITER, CONTENTS, REGDATE) VALUES(BOARD_SEQ.NEXTVAL, ?, ?, ?, SYSDATE)";
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, board.getTitle());
		pstmt.setString(2, board.getWriter());
		pstmt.setString(3, board.getContents());
		pstmt.executeQuery();
		
		pstmt.close();
		con.close();
	}
	
	/*
	 *  DAO that calls details of Board
	 */
	public BoardVO viewBoardDetail(int bno) throws SQLException {
		BoardVO board = null;
		String sql = "SELECT NO, WRITER, TITLE, CONTENTS, REGDATE FROM TB_BOARD WHERE NO = ?";
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, bno);
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		board = new BoardVO();
		board.setNo(rs.getInt("NO"));
		board.setWriter(rs.getString("WRITER"));
		board.setTitle(rs.getString("TITLE"));
		board.setContents(rs.getString("CONTENTS"));

		rs.close();
		pstmt.close();
		con.close();
		
		return board;
	}
	
	/*
	 * 게시글을 지우는 DAO
	 */
	public void deleteBoard(int bno) throws SQLException {
		String sql = "DELETE FROM TB_BOARD WHERE NO = ?";
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, bno);
		pstmt.executeQuery();
		
		pstmt.close();
		con.close();
	}
}
