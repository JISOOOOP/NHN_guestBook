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

}
