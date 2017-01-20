package week1day1practice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.ConnectionUtil;

public class StudentDAO {
	private final String INSERT_STUDENT_SQL = "INSERT INTO TB_STUDENT(NO, NAME, MAJOR, GRADE, PHONE, ID, PASSWORD) "
			+ "VALUES(SCHOOL_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?) ";
	private final String FIND_STUDENT_BY_NO_SQL = "SELECT * FROM TB_STUDENT WHERE NO LIKE '%'||?||'%'";
	
	public void addStudent(StudentVO student) throws SQLException {
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(INSERT_STUDENT_SQL);
		pstmt.setString(1, student.getName());
		pstmt.setString(2, student.getMajor());
		pstmt.setInt(3, student.getGrade());
		pstmt.setString(4, student.getPhone());
		pstmt.setString(5, student.getId());
		pstmt.setString(6, student.getPassword());
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
	}
	
	public ArrayList<StudentVO> searchStudentByNO(int no) throws SQLException {
		ArrayList<StudentVO> students = new ArrayList<>();
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(FIND_STUDENT_BY_NO_SQL);
		pstmt.setInt(1, no);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			StudentVO student = new StudentVO(no, rs.getString("NAME"), rs.getString("MAJOR"), rs.getInt("GRADE"), rs.getString("PHONE"), rs.getString("ID"), rs.getString("PASSWORD"));
			students.add(student);
		}
		rs.close();
		pstmt.close();
		con.close();
		
		return students;
	}
}
