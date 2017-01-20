package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.ConnectionUtil;
import vo.BlogVO;

public class BlogDAO {
	public BlogVO getBlogByNo(int no) throws SQLException {
		BlogVO blog = null;
		String sql = "SELECT NO, TITLE, WRITER, CONTENTS, GROUPNO, REGDATE FROM TB_BLOG WHERE NO = ? ";
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, no);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			blog = new BlogVO();
			blog.setNo(rs.getInt("NO"));
			blog.setTitle(rs.getString("TITLE"));
			blog.setWriter(rs.getString("WRITER"));
			blog.setContents(rs.getString("CONTENTS"));
			blog.setRegdate(rs.getDate("REGDATE"));
			blog.setGroupno(rs.getInt("GROUPNO"));
		}
		rs.close();
		pstmt.close();
		con.close();
		
		return blog;
	}
	
	public int getSeq() throws SQLException {
		int no = 0;
		
		String sql = "SELECT COMM_SEQ.NEXTVAL SEQ FROM DUAL";
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		no = rs.getInt("SEQ");

		rs.close();
		pstmt.close();
		con.close();
		
		return no;
	}
	
	public void addBlog(BlogVO blog) throws SQLException {
		String sql = "INSERT INTO TB_BLOG(NO, TITLE, WRITER, CONTENTS, GROUPNO) VALUES(?, ?, ?, ?, ?)";
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, blog.getNo());
		pstmt.setString(2, blog.getTitle());
		pstmt.setString(3, blog.getWriter());
		pstmt.setString(4, blog.getContents());
		pstmt.setInt(5, blog.getGroupno());
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
	}
	
	public ArrayList<BlogVO> getBlogList() throws SQLException {
		String sql = "SELECT NO, TITLE, WRITER, CONTENTS, REGDATE, GROUPNO "
				+ " FROM TB_BLOG "
				+ " ORDER BY GROUPNO DESC, NO ASC";
		ArrayList<BlogVO> list = new ArrayList<>();
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			BlogVO blog = new BlogVO();
			blog.setNo(rs.getInt("NO"));
			blog.setTitle(rs.getString("TITLE"));
			blog.setWriter(rs.getString("WRITER"));
			blog.setContents(rs.getString("CONTENTS"));
			blog.setRegdate(rs.getDate("REGDATE"));
			blog.setGroupno(rs.getInt("GROUPNO"));
			
			list.add(blog);
		}
		rs.close();
		pstmt.close();
		con.close();
		
		return list;
	}
}
