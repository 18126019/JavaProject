package src.DTO.nguoiDung;
import java.sql.*;
import java.util.ArrayList;

import src.DAO.heSo.HeSoNcDAO;
import src.DAO.nguoiDung.KhachHangDAO;
import src.DTO.heSo.HeSoNcDTO;
import src.application.java.CnnDB;
public class KhachHangDTO extends NguoiDung {
    //connect database
    CnnDB conn = new CnnDB();
    Connection cnn = conn.getDB();
    private ArrayList<KhachHangDTO> danhsachKhachHang = new ArrayList<>();

	public ArrayList<KhachHangDTO> getDanhsachKhachHang() {
		return danhsachKhachHang;
	}

	public void setDanhsachKhachHang(ArrayList<KhachHangDTO> danhsachKhachHang) {
		this.danhsachKhachHang = danhsachKhachHang;
	}

	public KhachHangDTO() {
		super();
	}
	public KhachHangDTO(int id, String ngDung, String mKhau, String ht, String sdt, String mail) {
		super(id, ngDung, mKhau, ht, sdt, mail);
	}
	public KhachHangDTO(KhachHangDTO kh) {
		super(kh.id, kh.tenDangNhap, kh.matKhau, kh.hoTen, kh.sdt, kh.email);
	}
	public ArrayList<KhachHangDTO> danhSachKhachHang(KhachHangDAO khachHangDAO){
		ResultSet resultSet = khachHangDAO.layKhacHang();
		try {
			while (resultSet.next()) {
				KhachHangDTO khachHangDTO = new KhachHangDTO(
						resultSet.getInt("id"),
						resultSet.getString("taikhoan"),
						resultSet.getString("matkhau"),
						resultSet.getString("ten"),
						resultSet.getString("sodienthoai"),
						resultSet.getString("email"));
				this.getDanhsachKhachHang().add(khachHangDTO);
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
		return this.getDanhsachKhachHang();
	}
	public String layTen(KhachHangDAO khachHangDAO, String username) {
		ResultSet rs = khachHangDAO.timKh(username);
		String ten = "";
		try {
			while (rs.next()) {
				ten = rs.getString("ten");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ten;
	}
	public int layId(KhachHangDAO khachHangDAO, String username) {
		ResultSet rs = khachHangDAO.timKh(username);
		int id = -1;
		try {
			while (rs.next()) {
				id = rs.getInt("id");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}
	public String layEmail(KhachHangDAO khachHangDAO, String username) {
		ResultSet rs = khachHangDAO.timKh(username);
		String email = "";
		System.out.println(rs);
		try {
			while (rs.next()) {
				email = rs.getString("email");
			}

			System.out.println(email);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return email;
	}
	public String laySdt(KhachHangDAO khachHangDAO, String username) {
		ResultSet rs = khachHangDAO.timKh(username);
		String sdt = "";
		try {
			while (rs.next()) {
				sdt = rs.getString("sodienthoai");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sdt;
	}
}
