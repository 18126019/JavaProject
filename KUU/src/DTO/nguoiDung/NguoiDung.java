package src.DTO.nguoiDung;

import java.util.ArrayList;

import src.DTO.heSo.hesoDat.Hem;
import src.DTO.nha.*;
import src.application.java.CnnDB;
public abstract class NguoiDung {
	protected String tenDangNhap;
	protected String matKhau;
	protected String hoTen;
	protected String sdt;
	protected String email;
	protected int id = 0;
	protected int daXoa = 0;
	protected NguoiDung() {
		this.tenDangNhap = "";
		this.matKhau = "";
		this.hoTen = "";
		this.sdt = "";
		this.email = "";
	}
	
	protected NguoiDung(String ngDung, String mKhau, String ht, String SDT, String mail) {
		this.tenDangNhap = ngDung;
		this.matKhau = mKhau;
		this.hoTen = ht;
		this.sdt = SDT;
		this.email = mail;
	}

	protected NguoiDung(NguoiDung u) {
		this.tenDangNhap = u.tenDangNhap;
		this.matKhau = u.matKhau;
		this.hoTen = u.hoTen;
		this.sdt = u.sdt;
		this.email = u.email;
	}
	public String getTenDangNhap() {
		return this.tenDangNhap;
	}
	public String getSdt() {
		return this.sdt;
	}	
	public String getMatKhau() {
		return this.matKhau;
	}
	public String getHoTen() {
		return this.hoTen;
	}	
	public String getEmail() {
		return this.email;
	}
	public int getId() {
		return id;
	}
	public int getDaXoa() {
		return daXoa;
	}
	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public void setMatKhau(String matKhau)
	{
		this.matKhau = matKhau;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setDaXoa(int daXoa) {
		this.daXoa = daXoa;
	}
}
