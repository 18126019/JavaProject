package src.BUS.nguoiDung;
import src.BUS.nha.DangBanNhaBUS;
import src.application.java.CnnDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
public class QuanTriBUS extends NguoiDung {
    //connect database
    CnnDB conn = new CnnDB();
    Connection cnn = conn.getDB();
	
    public QuanTriBUS() {
		super();
	}
	
	public QuanTriBUS(String ngDung, String mKhau, String ht, String SDT, String mail) {
		super(ngDung, mKhau, ht, SDT, mail);

	}
	
	public QuanTriBUS(QuanTriBUS qTri) {
		super(qTri.tenDangNhap, qTri.matKhau, qTri.hoTen, qTri.sdt, qTri.email);
	}
	
	
	public void themKhachHang(KhachHangBUS kh) {
		try {

			Statement statement = cnn.createStatement();
			String insertSqlString = "Insert into KHACHHANG(taikhoan, matkhau, ten, email, sodienthoai, maquantri, daxoa)"
					+ " values('" + kh.getTenDangNhap() + "','" + kh.getMatKhau() + "','" + kh.getHoTen() + "','" + kh.getSdt()
					+ "','" + this.getId() + "','" + kh.getDaXoa() + "')";
			statement.executeUpdate(insertSqlString);
			System.out.println("Add Sucessfully");
			String add = "SELECT ID FROM KHACHHANG WHERE taikhoan = '" + this.getTenDangNhap() + "' AND matkhau = '" + this.getMatKhau() + "'";
			ResultSet rs = statement.executeQuery(add);
			while (rs.next()) {
				this.setId(rs.getInt("ID"));
			}
			cnn.commit();
			statement.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	public void suaKhachHang(KhachHangBUS kh, KhachHangBUS kh2) {
		try {
			Statement statement = cnn.createStatement();
			String updateSqlString = "Update KHACHHANG SET taikhoan = '" + kh2.getTenDangNhap() + "', matkhau = '" + kh2.getMatKhau() 
							+ "', ten = '" + kh2.getHoTen() + "', email = '" + kh2.getEmail() + "',sodienthoai = '" + kh2.getSdt() 
							+ "', maquantri = '" + this.getId() + "', daxoa = '" + kh2.getDaXoa() + " WHERE id = '" + kh.getId() + "'";
			statement.executeUpdate(updateSqlString);
			cnn.commit();
			System.out.println("Update success");
			statement.close();	
		
			}  catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	public void xoaKhachHang(KhachHangBUS kh) {
		try {
			Statement statement = cnn.createStatement();
			String updateSqlString = "Update KHACHHANG SET daXoa = 1 WHERE id = '" + kh.getId() + "'";
			statement.executeUpdate(updateSqlString);
			cnn.commit();
			System.out.println("Update success");
			statement.close();	
		
			}  catch (SQLException e) {
			System.out.println(e);
		}
	}
	public void convertDBtoList() {
		try {
			ArrayList<KhachHangBUS> dsKhachHangBUS = new ArrayList<>();
			Statement statement = cnn.createStatement();
			String convert = "SELECT ID, taikhoan, matkhau, ten, email, sodienthoai, maquantri, daxoa FROM KHACHHANG";
			ResultSet rs = statement.executeQuery(convert);
			while (rs.next()) {
				dsKhachHangBUS.add(new KhachHangBUS(rs.getString("taikhoan"), rs.getString("matkhau"),
							rs.getString("ten"), rs.getString("email"), rs.getString("sodienthoai")));
			}
			cnn.commit();
			statement.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	public KhachHangBUS timKiemKhachHang(KhachHangBUS kh) {
		KhachHangBUS res = new KhachHangBUS();
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
	@Override
	public void themNha(DangBanNhaBUS dbn) {
		// TODO Auto-generated method stub
	}
	@Override
	public void xoaNha(DangBanNhaBUS dbn) {
		// TODO Auto-generated method stub
	}
	@Override
	public void suaNha(DangBanNhaBUS dbn, DangBanNhaBUS dbn2) {
		// TODO Auto-generated method stub	
	}
}
