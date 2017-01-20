package week1day1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import util.ConnectionUtil;

public class BookDAO {
	static final String INSERT_SQL = "INSERT INTO TB_BOOK(NO, TITLE, AUTHOR, PUBLISHER, PRICE, PUBDATE) "
									+ "VALUES(BOOK_SEQ.NEXTVAL, ?, ?, ?, ?, TO_DATE(?, 'YYYY-MM-DD'))";
	static final String SEARCH_BOOKS_BY_PUB_NAME = "SELECT NO, TITLE, AUTHOR, PUBLISHER, PRICE, PUBDATE "
									+ "FROM TB_BOOK "
									+ "WHERE PUBLISHER LIKE '%'||?||'%'";
	
	public void addBook(String title, String author, String publisher, int price, String pubdate) throws SQLException {
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(INSERT_SQL);
		pstmt.setString(1, title);
		pstmt.setString(2, author);
		pstmt.setString(3, publisher);
		pstmt.setInt(4, price);
		pstmt.setString(5, pubdate);
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
	}
	
	public ArrayList<BookVO> searchBooksByPubName(String pub_name) throws SQLException {
		ArrayList<BookVO> books = new ArrayList<>();
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(SEARCH_BOOKS_BY_PUB_NAME);
		pstmt.setString(1, pub_name);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			BookVO book = new BookVO();
			int no = rs.getInt("NO");
			String title = rs.getString("TITLE");
			String author = rs.getString("AUTHOR");
			String publisher = rs.getString("PUBLISHER");			
			int price = rs.getInt("PRICE");
			Date pubdate = rs.getDate("PUBDATE");
			
			book.setNo(no);
			book.setTitle(title);
			book.setAuthor(author);
			book.setPublisher(publisher);
			book.setPrice(price);
			book.setDate(pubdate);
			books.add(book);
		}
		
		rs.close();
		pstmt.close();
		con.close();
		
		return books;
	}
			
}
