package week1day2_2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BoardDAO {
	
	// 새로운 게시글 저장하기
	public void addNewBoard(BoardVO board) throws SQLException {
		String sql = "INSERT INTO TB_BOARD(NO, TITLE, WRITER, CONTENTS, IP) VALUES(BOARD_SEQ.NEXTVAL, ?, ?, ?, ?)";
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, board.getTitle());
		pstmt.setString(2, board.getWriter());
		pstmt.setString(3, board.getContents());
		pstmt.setString(4, board.getIp());

		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
	}
	
	// 등록된 모든 게시글을 제공하기
	public ArrayList<BoardVO> getAllBoards() throws SQLException {
		ArrayList<BoardVO> boards = new ArrayList<>();
		String sql = "SELECT NO, TITLE, REGDATE FROM TB_BOARD ORDER BY NO DESC";
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			BoardVO board = new BoardVO();
			board.setNo(rs.getInt("NO"));
			board.setTitle(rs.getString("TITLE"));
			board.setRegdate(rs.getDate("REGDATE"));
			
			boards.add(board);
		}
		
		rs.close();
		pstmt.close();
		con.close();
		
		return boards;
	}
	
	// 특정 글 번호에 해당하는 게시글을 제공하기
	public BoardVO getBoardByNo(int no) throws SQLException {
		String sql = "SELECT * FROM TB_BOARD WHERE NO = ?";
		BoardVO board = null;
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, no);
		ResultSet rs =  pstmt.executeQuery();
		while (rs.next()) {
			board = new BoardVO();
			board.setNo(rs.getInt("NO"));
			board.setTitle(rs.getString("TITLE"));
			board.setWriter(rs.getString("WRITER"));
			board.setContents(rs.getString("CONTENTS"));
			board.setLikes(rs.getInt("LIKES"));
			board.setRegdate(rs.getDate("REGDATE"));
			board.setIp(rs.getString("IP"));
			
		}		
		rs.close();
		pstmt.close();
		con.close();
		
		return board;
	}
	
	// 특정 글 번호에 해당하는 게시글을 삭제하기
	public void deleteBoard(int no) throws SQLException {
		String sql = "DELETE FROM TB_BOARD WHERE NO = ?";
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, no);
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
	}
	
	// 제목에 특정 단어가 포함된 게시글을 제공하기
	
	// ...

}
