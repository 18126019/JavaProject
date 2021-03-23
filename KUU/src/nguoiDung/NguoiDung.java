package nguoiDung;

import java.util.ArrayList;

import heSo.hesoDat.Hem;
import nha.*;

public abstract class NguoiDung {
	protected String tenDangNhap;
	protected String matKhau;
	protected String hoTen;
	protected String sdt;
	protected String email;

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
	public void setSDT(String sdtMoi) {
		//
	}
	public void setMatKhau(String matKhauMoi)
	{
		//
	}
	public abstract void themNha();
	public abstract void suaNha();
	public abstract void xoaNha();
//	public abstract ArrayList<Nha> sapXepNha();
}
