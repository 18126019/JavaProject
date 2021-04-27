package src.DTO.nguoiDung;
import java.sql.*;

import src.application.java.CnnDB;
public class KhachHangDTO extends NguoiDung {
    //connect database
    CnnDB conn = new CnnDB();
    Connection cnn = conn.getDB();
    
	public KhachHangDTO() {
		super();
	}
	public KhachHangDTO(String ngDung, String mKhau, String ht, String sdt, String mail) {
		super(ngDung, mKhau, ht, sdt, mail);
	}
	public KhachHangDTO(KhachHangDTO kh) {
		super(kh.tenDangNhap, kh.matKhau, kh.hoTen, kh.sdt, kh.email);
	}
}
