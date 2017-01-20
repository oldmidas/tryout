package demo2DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import demo2VO.CartVO;
import demo2VO.ItemVO;
import util.ConnectionUtil;

public class ItemDAO {
	public void delItemByCartNo(int cartNo) throws SQLException {
		String sql = "DELETE FROM TB_CART WHERE CART_NO = ?";
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, cartNo);
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
	}
	
	public ArrayList<CartVO> getCartItemsByUser(String userId) throws SQLException {
		ArrayList<CartVO> items = new ArrayList<>();
		String sql = "SELECT A.CART_NO, B.ITEM_NO, B.ITEM_NAME, B.ITEM_MAKER, B.ITEM_PRICE, A.REGDATE "
				+ " FROM TB_CART A, TB_ITEM B "
				+ " WHERE A.ITEM_NO=B.ITEM_NO "
				+ " AND A.USER_ID = ?";
	
		ArrayList<CartVO> cartItems = new ArrayList<>();
		
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, userId);
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			CartVO cart = new CartVO();
			cart.setNo(rs.getInt("CART_NO"));
			cart.setRegdate(rs.getDate("REGDATE"));
			
			ItemVO item = new ItemVO();
			item.setNo(rs.getInt("ITEM_NO"));
			item.setName(rs.getString("ITEM_NO"));
			item.setMaker(rs.getString("ITEM_MAKER"));
			item.setPrice(rs.getInt("ITEM_PRICE"));
			
			cart.setItem(item);
			cartItems.add(cart);
		}
		
		rs.close();
		pstmt.close();
		con.close();
		
		return cartItems;
	}
	
	public ArrayList<ItemVO> getAllItems() throws SQLException {
		ArrayList<ItemVO> items = new ArrayList<>();
		String sql = "SELECT ITEM_NO, ITEM_NAME, ITEM_MAKER, ITEM_PRICE, ITEM_PUBDATE "
				+ " FROM TB_ITEM "
				+ " ORDER BY ITEM_NO ASC";
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			ItemVO item = new ItemVO();
			item.setNo(rs.getInt("ITEM_NO"));
			item.setName(rs.getString("ITEM_NAME"));
			item.setMaker(rs.getString("ITEM_MAKER"));
			item.setPrice(rs.getInt("ITEM_PRICE"));
			item.setPubdate(rs.getDate("ITEM_PUBDATE"));
			
			items.add(item);
		}
		rs.close();
		pstmt.close();
		con.close();
				
		return items;
	}
	
	public void addCart(int itemNo, String userId) throws SQLException {
		String sql = " INSERT INTO TB_CART(CART_NO, ITEM_NO, USER_ID, REGDATE) "
				+ " VALUES(COMM_SEQ.NEXTVAL, ?, ?, SYSDATE) ";
		Connection con = ConnectionUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, itemNo);
		pstmt.setString(2, userId);
		pstmt.executeUpdate();
		pstmt.close();
		con.close();
	}
}