package book.vo;

import java.util.Date;

public class BookData {
	protected int no;
	protected String email;
	protected String password;
	protected String g_text;
	protected Date createdDate;
	protected Date modifiedDate;

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
		return email;
	}
	
	public BookData setPassword(String password) {
		this.password = password;
		return this;
	}
	
	public String getText() {
		return g_text;
	}
	
	public BookData setText(String g_text) {
		this.g_text = g_text;
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
}
