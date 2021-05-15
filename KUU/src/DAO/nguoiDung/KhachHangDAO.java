package src.DAO.nguoiDung;
import src.DAO.nha.DangBanNhaDAO;
import src.DTO.nha.DangBanNhaDTO;
import src.application.java.CnnDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class KhachHangDAO {
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
    
	public KhachHangDAO() {
		this.tenDangNhap = "";
		this.matKhau = "";
		this.email = "";
		this.hoTen = "";
		this.sdt = "";
	}
	public KhachHangDAO(String ngDung, String mKhau, String ht, String sdt, String mail) {
		this.tenDangNhap = ngDung;
		this.matKhau = mKhau;
		this.email = mail;
		this.hoTen = ht;
		this.sdt = sdt;
	}
	public KhachHangDAO(KhachHangDAO kh) {
		this.tenDangNhap = kh.tenDangNhap;
		this.matKhau = kh.matKhau;
		this.email = kh.email;
		this.hoTen = kh.hoTen;
		this.sdt = kh.sdt;
	}
	public void themNha(DangBanNhaDAO DbNha) {
		try {
			Statement statement = cnn.createStatement();
			String insertSqlString = "Insert into NHADANGBAN(manguoidung, sotang, dientich, ketcau, giatien, sonha, duong, phuong, quan, ghichu, imgurl, daxoa)"
					+ " values('" +  DbNha.getMaNguoiDung() + "','" + DbNha.getSoTang() + "','" + DbNha.getDienTich() + "',N'" + DbNha.getKetCau() + "','" + DbNha.getGiaTien()
					+ "','" + DbNha.getSoNha() + "',N'" + DbNha.getDuong()+ "',N'" + DbNha.getPhuong() + "',N'" + DbNha.getQuan() + "',N'" + DbNha.getGhiChu()
					+ "','"  + DbNha.getImgUrl() + "','" + DbNha.getDaXoa() + "')";
			statement.executeUpdate(insertSqlString);
			cnn.commit();
			System.out.println("success");
			statement.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	public void xoaNha(DangBanNhaDAO DbNha) {
		try {
			Statement statement = cnn.createStatement();
			String updateSqlString = "Update NHADANGBAN SET daXoa = 1 WHERE id = '" + DbNha.getID() + "'";
			statement.executeUpdate(updateSqlString);
			cnn.commit();
			statement.close();	
			}  catch (SQLException e) {
			System.out.println(e);
		}
	}
	public void suaNha(DangBanNhaDAO nha1) {
		try {
			Statement statement = cnn.createStatement();
			String updateSqlString = "Update NHADANGBAN SET sotang = '" + nha1.getSoTang() + "', dientich = '" + nha1.getDienTich()
							+ "', ketcau = N'" + nha1.getKetCau() + "', giatien = '" + nha1.getGiaTien() + "', sonha = '" + nha1.getSoNha()
							+ "', duong = N'" + nha1.getDuong() + "', phuong = N'" + nha1.getPhuong() + "', quan = N'" + nha1.getQuan()
							+ "', ghichu = N'" + nha1.getGhiChu() + "', imgurl = '" + nha1.getImgUrl() + "' WHERE id = '" + nha1.getID() + "'";
			statement.executeUpdate(updateSqlString);
			cnn.commit();
			statement.close();	
			}  catch (SQLException e) {
			System.out.println(e);
		}
	}
	public ResultSet layKhacHang() {
		ResultSet rs = null;
		try {
			Statement statement = cnn.createStatement();
			String selectString = "SELECT * FROM KHACHHANG";
			rs = statement.executeQuery(selectString);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	public ResultSet timKh(String username) {
		ResultSet rs = null;
		try {
			Statement statement = cnn.createStatement();
			String selectId = "SELECT * FROM KHACHHANG WHERE taikhoan = '" + username + "'";
			rs = statement.executeQuery(selectId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	public void updateTaiKhoan(String username, int id) {
		try {
			Statement statement = cnn.createStatement();
			String update = "UPDATE KHACHHANG SET taikhoan = '" + username + "' WHERE id = '" + id + "'";
			statement.executeUpdate(update);
			cnn.commit();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void updateMatKhau(String pass, int id) {
		try {
			Statement statement = cnn.createStatement();
			String update = "UPDATE KHACHHANG SET matkhau = '" + pass + "' WHERE id = '" + id + "'";
			statement.executeUpdate(update);
			cnn.commit();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void updateHoTen(String name, int id) {
		try {
			Statement statement = cnn.createStatement();
			String update = "UPDATE KHACHHANG SET ten = '" + name + "' WHERE id = '" + id + "'";
			statement.executeUpdate(update);
			cnn.commit();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void updateEmail(String email, int id) {
		try {
			Statement statement = cnn.createStatement();
			String update = "UPDATE KHACHHANG SET email = '" + email + "' WHERE id = '" + id + "'";
			statement.executeUpdate(update);
			cnn.commit();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void updateSdt(String phone, int id) {
		try {
			Statement statement = cnn.createStatement();
			String update = "UPDATE KHACHHANG SET sodienthoai = '" + phone + "' WHERE id = '" + id +"'";
			statement.executeUpdate(update);
			cnn.commit();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void updateDaXoa(int enabled, int id) {
		try {
			Statement statement = cnn.createStatement();
			String update = "UPDATE KHACHHANG SET daxoa = " + enabled + " WHERE id = '" + id + "'";
			statement.executeUpdate(update);
			cnn.commit();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
