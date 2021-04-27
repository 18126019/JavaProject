package src.DAO.nguoiDung;
import java.sql.*;

import src.application.java.CnnDB;

public class QuanTriDAO {
    //connect database
    CnnDB conn = new CnnDB();
    Connection cnn = conn.getDB();
    protected String tenDangNhap;
	protected String matKhau;
	protected String hoTen;
	protected String sdt;
	protected String email;
	protected int id = 0;
	protected int daXoa = 0;
	
	public QuanTriDAO() {
		this.tenDangNhap = "";
		this.matKhau = "";
		this.email = "";
		this.hoTen = "";
		this.sdt = "";
	}
	public QuanTriDAO(String ngDung, String mKhau, String ht, String sdt, String mail) {
		this.tenDangNhap = ngDung;
		this.matKhau = mKhau;
		this.email = mail;
		this.hoTen = ht;
		this.sdt = sdt;
	}
	public QuanTriDAO(QuanTriDAO qt) {
		this.tenDangNhap = qt.tenDangNhap;
		this.matKhau = qt.matKhau;
		this.email = qt.email;
		this.hoTen = qt.hoTen;
		this.sdt = qt.sdt;
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
  
	public void themKhachHang(KhachHangDAO kh) {
		try {
			Statement statement = cnn.createStatement();
			String insertSqlString = "Insert into KHACHHANG(taikhoan, matkhau, ten, email, sodienthoai, maquantri, daxoa)"
					+ " values('" + kh.getTenDangNhap() + "','" + kh.getMatKhau() + "','" + kh.getHoTen() + "','" + kh.getSdt()
					+ "','" + this.getId() + "','" + kh.getDaXoa() + "')";
			statement.executeUpdate(insertSqlString);
			cnn.commit();
			statement.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	public void suaKhachHang(KhachHangDAO kh, KhachHangDAO kh2) {
		try {
			Statement statement = cnn.createStatement();
			String updateSqlString = "Update KHACHHANG SET taikhoan = '" + kh2.getTenDangNhap() + "', matkhau = '" + kh2.getMatKhau() 
							+ "', ten = '" + kh2.getHoTen() + "', email = '" + kh2.getEmail() + "',sodienthoai = '" + kh2.getSdt() 
							+ "', maquantri = '" + this.getId() + "', daxoa = '" + kh2.getDaXoa() + " WHERE id = '" + kh.getId() + "'";
			statement.executeUpdate(updateSqlString);
			cnn.commit();
			statement.close();	
		
			}  catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	public void xoaKhachHang(KhachHangDAO kh) {
		try {
			Statement statement = cnn.createStatement();
			String updateSqlString = "Update KHACHHANG SET daXoa = 1 WHERE id = '" + kh.getId() + "'";
			statement.executeUpdate(updateSqlString);
			cnn.commit();
			statement.close();	
		
			}  catch (SQLException e) {
			System.out.println(e);
		}
	}
	public KhachHangDAO timKiemKhachHang(KhachHangDAO kh) {
		KhachHangDAO res = new KhachHangDAO();
		try {
			Statement statement = cnn.createStatement();
			String convert = "SELECT taikhoan, matkhau, ten, email, sodienthoai, maquantri, daxoa FROM KHACHHANG WHERE ID = " + kh.getId() + "";
			ResultSet rs = statement.executeQuery(convert);
			while (rs.next()) {
				res.setTenDangNhap(rs.getString("taikhoan"));
				res.setMatKhau(rs.getString("matkhau"));
				res.setHoTen(rs.getString("ten"));
				res.setEmail(rs.getString("email"));
				res.setSdt(rs.getString("sodienthoai"));
				res.setDaXoa(rs.getInt("daxoa"));
				res.setId(kh.getId());
			}
			cnn.commit();
			statement.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return res;
	}
	public ResultSet layQuanTriVien() {
		ResultSet rs = null;
		try {
			Statement statement = cnn.createStatement();
			String selectString = "SELECT * FROM QUANTRIVIEN";
			rs = statement.executeQuery(selectString);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
}
