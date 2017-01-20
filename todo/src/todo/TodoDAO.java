package todo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import util.ConnectionUtil;

public class TodoDAO {
	
	public ArrayList<TodoVO> getTodoListForPaging(int begin, int end, String userId) throws Exception {
		ArrayList<TodoVO> todos = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String sql = "SELECT NO, CATEGORY, TITLE, DESCRIPTION, DAY, LOCATION, COMPLETED, USER_ID "
				+ " FROM (SELECT ROW_NUMBER() OVER (ORDER BY NO DESC) RN, "
				+ " NO, CATEGORY, TITLE, DESCRIPTION, DAY, LOCATION, COMPLETED, USER_ID "
				+ "		FROM TB_TODO "
				+ "		WHERE USER_ID = ?) "
				+ " WHERE RN>= ? AND RN <=? ";
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, userId);
		pstmt.setInt(2, begin);
		pstmt.setInt(3, end);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			TodoVO vo = new TodoVO();
			vo.setNo(rs.getInt("NO"));
			vo.setCatagory(rs.getString("CATEGORY"));
			vo.setTitle(rs.getString("TITLE"));
			vo.setDescription(rs.getString("DESCRIPTION"));
			vo.setLocation(rs.getString("LOCATION"));
			vo.setDay(sdf.format(rs.getDate("DAY")));
			if ("complete".equals(rs.getString("COMPLETED"))) {
				vo.setCompleted(true);
			} else if ("incomplete".equals(rs.getString("COMPLETED"))) {
				vo.setCompleted(false);
			}
			vo.setUserId(rs.getString("USER_ID"));
			todos.add(vo);
		}
		rs.close();
		pstmt.close();
		con.close();
		
		return todos;
	}
	
	public int getTotalRows(String userId) throws SQLException {
		int totalRows = 0;
		String sql = "SELECT COUNT(*) CNT FROM TB_TODO WHERE USER_ID = ?";
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, userId);
		ResultSet rs = pstmt.executeQuery();
		
		if (rs.next()) {
			totalRows = rs.getInt("CNT");
		}	
		rs.close();
		pstmt.close();
		con.close();
		
		return totalRows;
	}
	
	public void addTodo(TodoVO vo) throws SQLException {
		String sql = " INSERT INTO TB_TODO(NO, CATEGORY, TITLE, DESCRIPTION, LOCATION, DAY, COMPLETED, USER_ID) "
				+ " VALUES(TODO_SEQ.NEXTVAL, ?, ?, ?, ?, ?, 'incomplete', ?) ";
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, vo.getCatagory());
		pstmt.setString(2, vo.getTitle());
		pstmt.setString(3, vo.getDescription());
		pstmt.setString(4, vo.getLocation());
		pstmt.setString(5, vo.getDay());
		pstmt.setString(6, vo.getUserId());
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
	}
	
	public ArrayList<TodoVO> showAllTodo(String userId) throws SQLException {
		ArrayList<TodoVO> vos = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String sql = " SELECT NO, CATEGORY, TITLE, DESCRIPTION, LOCATION, DAY, COMPLETED, USER_ID FROM TB_TODO WHERE USER_ID = ? ORDER BY NO ";
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, userId);
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			TodoVO vo = new TodoVO();
			vo.setNo(rs.getInt("NO"));
			vo.setCatagory(rs.getString("CATEGORY"));
			vo.setTitle(rs.getString("TITLE"));
			vo.setDescription(rs.getString("DESCRIPTION"));
			vo.setLocation(rs.getString("LOCATION"));
			vo.setDay(sdf.format(rs.getDate("DAY")));
			if ("complete".equals(rs.getString("COMPLETED"))) {
				vo.setCompleted(true);
			} else if ("incomplete".equals(rs.getString("COMPLETED"))) {
				vo.setCompleted(false);
			}
			vo.setUserId(rs.getString("USER_ID"));
			vos.add(vo);
		}
		rs.close();
		pstmt.close();
		con.close();
		
		return vos;
	}
	
	public TodoVO showDetailByNo(int tno) throws SQLException {
		TodoVO vo = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String sql = " SELECT NO, CATEGORY, TITLE, DESCRIPTION, LOCATION, DAY, COMPLETED FROM TB_TODO WHERE NO = ? ";
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, tno);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			vo = new TodoVO();
			vo.setNo(rs.getInt("NO"));
			vo.setCatagory(rs.getString("CATEGORY"));
			vo.setTitle(rs.getString("TITLE"));
			vo.setDescription(rs.getString("DESCRIPTION"));
			vo.setLocation(rs.getString("LOCATION"));
			vo.setDay(sdf.format(rs.getDate("DAY")));
			if ("complete".equals(rs.getString("COMPLETED"))) {
				vo.setCompleted(true);
			} else if ("incomplete".equals(rs.getString("COMPLETED"))) {
				vo.setCompleted(false);
			}
		}
		rs.close();
		pstmt.close();
		con.close();
		
		return vo;
	}
	
	public void completeTodo(int tno) throws SQLException {
		String sql = " UPDATE TB_TODO SET COMPLETED = 'complete' WHERE NO = ? ";
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, tno);
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
	}
	
	public void deleteTodo(int tno) throws SQLException {
		String sql = " DELETE FROM TB_TODO WHERE NO = ? ";
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, tno);
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
	}
	
	
}
