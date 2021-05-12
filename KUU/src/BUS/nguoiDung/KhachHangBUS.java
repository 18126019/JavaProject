package src.BUS.nguoiDung;
import java.sql.*;
import java.util.ArrayList;

import src.BUS.nha.*;
import src.DAO.heSo.hesoDat.HinhDangDAO;
import src.DAO.nguoiDung.KhachHangDAO;
import src.DTO.heSo.hesoDat.HinhDangDTO;
import src.DTO.nguoiDung.KhachHangDTO;
import src.application.java.CnnDB;
public class KhachHangBUS extends NguoiDung {
    //connect database
    CnnDB conn = new CnnDB();
    Connection cnn = conn.getDB();
    
	public KhachHangBUS() {
		super();
	}
	public KhachHangBUS(int id, String ngDung, String mKhau, String ht, String sdt, String mail) {
		super(id, ngDung, mKhau, ht, sdt, mail);
	}
	public KhachHangBUS(KhachHangBUS kh) {
		super(kh.id, kh.tenDangNhap, kh.matKhau, kh.hoTen, kh.sdt, kh.email);
	}

	public ArrayList<KhachHangDTO> danhSachKhachHang() {
		KhachHangDAO khachHangDAO = new KhachHangDAO();
		KhachHangDTO khachHangDTO = new KhachHangDTO();
		ArrayList<KhachHangDTO> dsKhachHang = khachHangDTO.danhSachKhachHang(khachHangDAO);

		return dsKhachHang;
	}
}
