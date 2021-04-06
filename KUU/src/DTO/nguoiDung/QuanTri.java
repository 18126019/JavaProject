package src.DTO.nguoiDung;
import java.sql.*;
import java.util.ArrayList;
import src.application.java.CnnDB;
import src.DTO.nha.*;
public class QuanTri extends NguoiDung {
	protected ArrayList<KhachHang> dsKhachHang;
    //connect database
    CnnDB conn = new CnnDB();
    Connection cnn = conn.getDB();
	
    public QuanTri() {
		super();
		dsKhachHang = new ArrayList<>();
	}
	
	public QuanTri(String ngDung, String mKhau, String ht, String SDT, String mail, ArrayList<KhachHang> dsKhachHang) {
		super(ngDung, mKhau, ht, SDT, mail);
		this.dsKhachHang = dsKhachHang;
	}
	
	public QuanTri(QuanTri qTri) {
		super(qTri.tenDangNhap, qTri.matKhau, qTri.hoTen, qTri.sdt, qTri.email);
		dsKhachHang = qTri.dsKhachHang;
	}

	public ArrayList<KhachHang> getDsKhachHang() {
		return this.dsKhachHang;
	}
	public void setDsKhachHang(ArrayList<KhachHang> dsKhachHang) {
		this.dsKhachHang = dsKhachHang;
	}
}
