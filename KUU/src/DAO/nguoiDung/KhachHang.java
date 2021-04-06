package src.DAO.nguoiDung;
import java.sql.*;
import java.util.ArrayList;
import src.DAO.nha.*;
import src.application.java.CnnDB;
public class KhachHang {
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
    
	public KhachHang() {
		this.tenDangNhap = "";
		this.matKhau = "";
		this.email = "";
		this.hoTen = "";
		this.sdt = "";
	}
	public KhachHang(String ngDung, String mKhau, String ht, String sdt, String mail) {
		this.tenDangNhap = ngDung;
		this.matKhau = mKhau;
		this.email = mail;
		this.hoTen = ht;
		this.sdt = sdt;
	}
	public KhachHang(KhachHang kh) {
		this.tenDangNhap = kh.tenDangNhap;
		this.matKhau = kh.matKhau;
		this.email = kh.email;
		this.hoTen = kh.hoTen;
		this.sdt = kh.sdt;
	}
	public void themNha(DangBanNha DbNha) {
		try {
			Statement statement = cnn.createStatement();
			String insertSqlString = "Insert into NHADANGBAN(ID, manguoidung, sotang, dientich, ketcau, giatien, sonha, duong, phuong, quan, ghichu, daxoa)"
					+ " values(" + DbNha.getID() + ",'" + this.getId() + "','" + DbNha.getSoTang() + "','" + DbNha.getKetCau() + "','" + DbNha.getGiaTien()
					+ "','" + DbNha.getSoNha() + "','"+ DbNha.getDuong()+ "','" + DbNha.getPhuong() + "','" + DbNha.getQuan() + "','" + DbNha.getGhiChu() 
					+ "'," + DbNha.getDaXoa() + ")";
			statement.executeUpdate(insertSqlString);
			cnn.commit();
			statement.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	public void xoaNha(DangBanNha DbNha) {
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
	public void suaNha(DangBanNha nha1, DangBanNha nha2) {
		try {
			Statement statement = cnn.createStatement();
			String updateSqlString = "Update NHADANGBAN SET sotang = " + nha2.getSoTang() + "', dientich = " + nha2.getDienTich() 
							+ ", ketcau = '" + nha2.getKetCau() + "', giatien = " + nha2.getGiaTien() + "',sonha = '" + nha2.getSoNha() 
							+ "', duong = '" + nha2.getDuong() + "', phuong = '" + nha2.getPhuong() + "','" + "quan = '" + nha2.getQuan() 
							+ " WHERE id = '" + nha1.getID() + "'";
			statement.executeUpdate(updateSqlString);
			cnn.commit();
			statement.close();	
			}  catch (SQLException e) {
			System.out.println(e);
		}
	}
}
