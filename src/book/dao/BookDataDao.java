package book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import book.vo.BookData;

public class BookDataDao {
	DataSource ds;
	
	public void setDataSource(DataSource ds) {
		this.ds = ds;
	}
	
	public List<BookData> selectList() throws Exception{
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			connection = ds.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery(
					"select BNO,EMAIL,TXT,MOD_DATE"
					+ " from BOOKDATALIST"
					+ " order by MOD_DATE DESC");
			
			ArrayList<BookData> bookDataList = new ArrayList<BookData>();
			
			while(rs.next()) {
				bookDataList.add(new BookData()
							.setNo(rs.getInt("BNO"))
							.setEmail(rs.getString("EMAIL"))
							.setText(rs.getString("TXT"))
							.setModifiedDate(rs.getDate("MOD_DATE"))
							.setModifiedTime(rs.getTime("MOD_DATE")));
			}
			
			return bookDataList;
			
		} catch (Exception e) {
			throw e;
		} finally {
			try {if(rs != null) {rs.close();}} catch (Exception e) {}
			try {if(stmt != null) {stmt.close();}} catch (Exception e) {}
			try {if(connection != null) {connection.close();}} catch (Exception e) {}
		}
	}
	
	public int insert(BookData bookData) throws Exception {
		// 게시글 등록
		Connection connection = null;
		PreparedStatement stmt = null;
		
		try {
			connection = ds.getConnection();
			stmt = connection.prepareStatement(
					"INSERT INTO BOOKDATALIST(EMAIL,PWD,TXT,CRE_DATE,MOD_DATE)"
					+ " VALUES (?,?,?,NOW(),NOW())");
			stmt.setString(1, bookData.getEmail());
			stmt.setString(2, bookData.getPassword());
			stmt.setString(3, bookData.getText());
			return stmt.executeUpdate();
			
		} catch (Exception e) {
			throw e;
			
		} finally {
			try {if(stmt != null) {stmt.close();}} catch (Exception e) {}
			try {if(connection != null) {connection.close();}} catch (Exception e) {}
		}
	}
	
	public BookData selectOne(int no) throws Exception {
		// 게시글 조회
		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			connection = ds.getConnection();
			stmt = connection.prepareStatement(
					"SELECT EMAIL,PWD,TXT FROM BOOKDATALIST"
					+ " WHERE BNO=?");
			stmt.setInt(1, no);
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				BookData bookData = new BookData()
												.setEmail(rs.getString("EMAIL"))
												.setPassword(rs.getString("PWD"))
												.setText(rs.getString("TXT"));
				return bookData;
			} else {
				throw new Exception("해당 게시글을 찾을 수 없습니다");
			}
			
		} catch (Exception e) {
			throw e;
			
		} finally {
			try {if(rs != null) {rs.close();}} catch (Exception e) {}
			try {if(stmt != null) {stmt.close();}} catch (Exception e) {}
			try {if(connection != null) {connection.close();}} catch (Exception e) {}
		}
	}

	public int update(BookData bookData) throws Exception {
		Connection connection = null;
		PreparedStatement stmt = null;
		
		try {
			connection = ds.getConnection();
			stmt = connection.prepareStatement(
					"UPDATE BOOKDATALIST SET TXT=?,MOD_DATE=now()"
					+ " WHERE BNO=?");
			stmt.setString(1, bookData.getText());
			stmt.setInt(2, bookData.getNo());
			return stmt.executeUpdate();
			
		} catch (Exception e) {
			throw e;
			
		} finally {
			try {if(stmt != null) {stmt.close();}} catch (Exception e) {}
			try {if(connection != null) {connection.close();}} catch (Exception e) {}
		}
	}
	
	public BookData exist(String email, String password) throws Exception {
		// 있으면 BookData return, 없으면 null return
		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			connection = ds.getConnection();
			stmt = connection.prepareStatement(
					"select BNO,EMAIL,TXT from BOOKDATALIST"
					+ " WHERE EMAIL=? AND PWD=?");
			stmt.setString(1, email);
			stmt.setString(2, password);
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				return new BookData().setNo(rs.getInt("BNO"))
									.setEmail(rs.getString("EMAIL"))
									.setText(rs.getString("TXT"));
			}
			else {
				return null;
			}
			
		} catch (Exception e) {
			throw e;
			
		} finally {
			try {if(rs != null) {rs.close();}} catch (Exception e) {}
			try {if(stmt != null) {stmt.close();}} catch (Exception e) {}
			try {if(connection != null) {connection.close();}} catch (Exception e) {}
		}
	}
	
}
