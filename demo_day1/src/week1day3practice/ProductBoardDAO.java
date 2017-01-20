package week1day3practice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductBoardDAO {
	public ArrayList<ProductBoardVO> showAllList() throws SQLException {
		ArrayList<ProductBoardVO> boards = new ArrayList<>();
		String sql = "SELECT * FROM TB_PRODUCT_BOARD";
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			ProductBoardVO board = new ProductBoardVO();
			board.setNo(rs.getInt("NO"));
			board.setTitle(rs.getString("TITLE"));
			board.setWriter(rs.getString("WRITER"));
			board.setContents(rs.getString("CONTENTS"));
			board.setRegdate(rs.getDate("REGDATE"));
			
			boards.add(board);
		}
		rs.close();
		pstmt.close();
		con.close();
		
		return boards;
	}
	
	public void addNewBoard(String title, String writer ,String contents) throws SQLException {
		String sql = "INSERT INTO TB_PRODUCT_BOARD(NO, TITLE, WRITER, CONTENTS, REGDATE) VALUES(PRODUCT_BOARD_SEQ.NEXTVAL, ?, ?, ?, SYSDATE)";
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, title);
		pstmt.setString(2, writer);
		pstmt.setString(3, contents);
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
	}
	
	public ProductBoardVO viewBoardDetail(int bno) throws SQLException {
		ProductBoardVO board = null;
		String sql = "SELECT * FROM TB_PRODUCT_BOARD WHERE NO = ?";
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, bno);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			board = new ProductBoardVO();
			board.setNo(rs.getInt("NO"));
			board.setTitle(rs.getString("TITLE"));
			board.setWriter(rs.getString("WRITER"));
			board.setContents(rs.getString("CONTENTS"));
			board.setRegdate(rs.getDate("REGDATE"));
		}
		rs.close();
		pstmt.close();
		con.close();
		
		return board;
	}
	
	public int deleteBoard(int bno, String userId) throws SQLException {
		int result = 0;
		String sql = "DELETE FROM TB_PRODUCT_BOARD WHERE NO = ? AND WRITER = ?";
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, bno);
		pstmt.setString(2, userId);
		result = pstmt.executeUpdate();
		pstmt.close();
		con.close();
		return result;
	}
}
