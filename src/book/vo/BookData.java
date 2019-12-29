package book.vo;

import java.sql.Time;
import java.util.Date;

public class BookData {
	protected int no;
	protected String email;
	protected String password;
	protected String text;
	protected Date createdDate;
	protected Date modifiedDate;
	protected Time createdTime;
	protected Time modifiedTime;

	public int getNo() {
		return no;
	}
	
	public BookData setNo(int no) {
		this.no = no;
		return this;
	}
	
	public String getEmail() {
		return email;
	}
	
	public BookData setEmail(String email) {
		this.email = email;
		return this;
	}
	
	public String getPassword() {
		return password;
	}
	
	public BookData setPassword(String password) {
		this.password = password;
		return this;
	}
	
	public String getText() {
		return text;
	}
	
	public BookData setText(String text) {
		this.text = text;
		return this;
	}
	
	public Date getCreatedDate() {
		return createdDate;
	}
	
	public BookData setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
		return this;
	}
	
	public Date getModifiedDate() {
		return modifiedDate;
	}
	
	public BookData setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
		return this;
	}
	
	public Time getCreatedTime() {
		return createdTime;
	}
	
	public BookData setcreatedTime(Time createdTime) {
		this.createdTime = createdTime;
		return this;
	}
	
	public Time getModifiedTime() {
		return modifiedTime;
	}
	
	public BookData setModifiedTime(Time modifiedDate) {
		this.modifiedTime = modifiedDate;
		return this;
	}
}
