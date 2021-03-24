package nguoiDung;
import java.sql.*;
import java.util.ArrayList;
import nha.*;
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
	public void themKhachHang() {
		//
	}
	
	public void suaKhachHang() {
		//
	}
	
	public void xoaKhachHang() {
		//
	}
	public ArrayList<KhachHang> getDsKhachHang() {
		return this.dsKhachHang;
	}
	
	public KhachHang timKiemKhachHang() {
		return dsKhachHang.get(1);
	}
	
	public ArrayList<KhachHang> sapXepKhachHang() {
		return this.dsKhachHang;
	}
	@Override
	public void themNha() {
		// TODO Auto-generated method stub
	}
	@Override
	public void xoaNha() {
		// TODO Auto-generated method stub
	}
	@Override
	public void suaNha() {
		// TODO Auto-generated method stub	
	}
}
