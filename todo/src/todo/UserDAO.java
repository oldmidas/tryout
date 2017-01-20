package todo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 
import util.ConnectionUtil;

public class UserDAO {
	public void addUser(UserVO user) throws SQLException {
		String sql = "INSERT INTO TB_USER"
				+ "(USER_ID, USER_PWD, USER_NAME, USER_PHONE, USER_ADDR) "
				+ "VALUES(?, ?, ?, ?, ?)";
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, user.getId());
		pstmt.setString(2, user.getPwd());
		pstmt.setString(3, user.getName());
		pstmt.setString(4, user.getPhone());
		pstmt.setString(5, user.getAddr());
		pstmt.executeQuery();
		
		pstmt.close();
		con.close();
	}
	
	public UserVO getUserById(String id) throws SQLException {
		UserVO user = null;
		String sql = "SELECT USER_ID, USER_PWD, USER_NAME, USER_PHONE, USER_ADDR, USER_POINT, USER_REGDATE FROM TB_USER WHERE USER_ID = ?";
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			user = new UserVO();
			user.setId(rs.getString("USER_ID"));
			user.setPwd(rs.getString("USER_PWD"));
			user.setName(rs.getString("USER_NAME"));
			user.setPhone(rs.getString("USER_PHONE"));
			user.setAddr(rs.getString("USER_ADDR"));
			user.setPoint(rs.getInt("USER_POINT"));
			user.setRegdate(rs.getDate("USER_REGDATE"));
		}
		rs.close();
		pstmt.close();
		con.close();
		
		return user;
	}
}
