package application.java;

import java.util.Date;

public class Student {
	private String ID;
	private String ho;
	private String ten;
	private Date ngaySinh;
	private String queQuan;

	public Student() {
		this.ID = "";
		this.ho = "";
		this.ten = "";
		this.ngaySinh = new Date(0);
		this.queQuan = "";
	}

	public Student(String ID, String ho, String ten, Date ngaySinh, String queQuan) {
		this.ID = ID;
		this.ho = ho;
		this.ten = ten;
		this.ngaySinh = ngaySinh;
		this.queQuan = queQuan;
	}

	public String getID() {
		return this.ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public String getHo() {
		return this.ho;
	}

	public void setHo(String Ho) {
		this.ho = Ho;
	}

	public String getTen() {
		return this.ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public Date getNgaySinh() {
		return this.ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getQueQuan() {
		return this.queQuan;
	}

	public void setQueQuan(String queQuan) {
		this.queQuan = queQuan;
	}
}
