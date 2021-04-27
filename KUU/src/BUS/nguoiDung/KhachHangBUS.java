package src.BUS.nguoiDung;
import java.sql.*;

import src.BUS.nha.*;
import src.application.java.CnnDB;
public class KhachHangBUS extends NguoiDung {
    //connect database
    CnnDB conn = new CnnDB();
    Connection cnn = conn.getDB();
    
	public KhachHangBUS() {
		super();
	}
	public KhachHangBUS(String ngDung, String mKhau, String ht, String sdt, String mail) {
		super(ngDung, mKhau, ht, sdt, mail);
	}
	public KhachHangBUS(KhachHangBUS kh) {
		super(kh.tenDangNhap, kh.matKhau, kh.hoTen, kh.sdt, kh.email);
	}
	@Override
	public void themNha(DangBanNhaBUS DbNha) {
		try {
			Statement statement = cnn.createStatement();
			String insertSqlString = "Insert into NHADANGBAN(ID, manguoidung, sotang, dientich, ketcau, giatien, sonha, duong, phuong, quan, ghichu, daxoa)"
					+ " values(" + DbNha.getID() + ",'" + this.getId() + "','" + DbNha.getSoTang() + "','" + DbNha.getKetCau() + "','" + DbNha.getGiaTien()
					+ "','" + DbNha.getSoNha() + "','"+ DbNha.getDuong()+ "','" + DbNha.getPhuong() + "','" + DbNha.getQuan() + "','" + DbNha.getGhiChu() 
					+ "'," + DbNha.getDaXoa() + ")";
			statement.executeUpdate(insertSqlString);
			System.out.println("Add Sucessfully");
			String add = "SELECT ID FROM NHADANGBAN WHERE sonha = '" + DbNha.getSoNha() + "',' duong = '" + DbNha.getDuong() + "', phuong ='" + DbNha.getPhuong()
			+ "', quan = '" + DbNha.getQuan() + "', ID = " + this.getId();
			ResultSet rs = statement.executeQuery(add);
			while (rs.next()) {
				DbNha.setID(rs.getInt("ID"));
			}
			cnn.commit();
			statement.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	@Override
	public void xoaNha(DangBanNhaBUS DbNha) {
		try {
			Statement statement = cnn.createStatement();
			String updateSqlString = "Update NHADANGBAN SET daXoa = 1 WHERE id = '" + DbNha.getID() + "'";
			statement.executeUpdate(updateSqlString);
			cnn.commit();
			System.out.println("Update success");
			statement.close();	
		
			}  catch (SQLException e) {
			System.out.println(e);
		}
	}
	@Override
	public void suaNha(DangBanNhaBUS nha1, DangBanNhaBUS nha2) {
		try {
			Statement statement = cnn.createStatement();
			String updateSqlString = "Update NHADANGBAN SET sotang = " + nha2.getSoTang() + "', dientich = " + nha2.getDienTich() 
							+ ", ketcau = '" + nha2.getKetCau() + "', giatien = " + nha2.getGiaTien() + "',sonha = '" + nha2.getSoNha() 
							+ "', duong = '" + nha2.getDuong() + "', phuong = '" + nha2.getPhuong() + "','" + "quan = '" + nha2.getQuan() 
							+ " WHERE id = '" + nha1.getID() + "'";
			statement.executeUpdate(updateSqlString);
			cnn.commit();
			System.out.println("Update success");
			statement.close();	
		
			}  catch (SQLException e) {
			System.out.println(e);
		}
	}
}
