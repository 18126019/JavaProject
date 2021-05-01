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
	public void themNha(DangBanNhaDTO DbNha) {
		try {
			Statement statement = cnn.createStatement();
			String insertSqlString = "Insert into NHADANGBAN(ID, manguoidung, sotang, dientich, ketcau, giatien, sonha, duong, phuong, quan, ghichu, imgurl, daxoa)"
					+ " values('" + DbNha.getId() + "','" + this.getId() + "','" + DbNha.getSoTang() + "','" + DbNha.getKetcau() + "','" + DbNha.getGiaTien()
					+ "','" + DbNha.getSoNha() + "','" + DbNha.getDuong()+ "','" + DbNha.getPhuong() + "','" + DbNha.getQuan() + "','" + DbNha.getGhichu()
					+ "','"  + DbNha.getImgUrl() + "','" + this.daXoa + "')";
			statement.executeUpdate(insertSqlString);
			cnn.commit();
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
	public void suaNha(DangBanNhaDTO nha1) {
		try {
			Statement statement = cnn.createStatement();
			String updateSqlString = "Update NHADANGBAN SET sotang = " + nha1.getSoTang() + "', dientich = " + nha1.getDienTich()
							+ ", ketcau = '" + nha1.getKetcau() + "', giatien = '" + nha1.getGiaTien() + "', sonha = '" + nha1.getSoNha()
							+ "', duong = '" + nha1.getDuong() + "', phuong = '" + nha1.getPhuong() + "', quan = '" + nha1.getQuan()
							+ "', ghichu = '" + nha1.getGhichu() + " WHERE id = '" + nha1.getId() + "'";
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
}
