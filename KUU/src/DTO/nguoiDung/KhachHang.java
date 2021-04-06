package src.DTO.nguoiDung;
import java.sql.*;
import java.util.ArrayList;
import src.DTO.nha.*;
import src.application.java.CnnDB;
public class KhachHang extends NguoiDung {
    //connect database
    CnnDB conn = new CnnDB();
    Connection cnn = conn.getDB();
    
	public KhachHang() {
		super();
	}
	public KhachHang(String ngDung, String mKhau, String ht, String sdt, String mail) {
		super(ngDung, mKhau, ht, sdt, mail);
	}
	public KhachHang(KhachHang kh) {
		super(kh.tenDangNhap, kh.matKhau, kh.hoTen, kh.sdt, kh.email);
	}
}
