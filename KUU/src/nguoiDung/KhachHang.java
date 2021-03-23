package nguoiDung;

import java.util.ArrayList;
import nha.*;

public class KhachHang extends NguoiDung {
	protected ArrayList<Nha> dsNha;
	
	public KhachHang() {
		super();
		this.dsNha = new ArrayList<>();
	}
	public KhachHang(String ngDung, String mKhau, String ht, String sdt, String mail, ArrayList<Nha> dsNha) {
		super(ngDung, mKhau, ht, sdt, mail);
		this.dsNha = dsNha;
	}
	public KhachHang(KhachHang kh) {
		super(kh.tenDangNhap, kh.matKhau, kh.hoTen, kh.sdt, kh.email);
		this.dsNha = kh.dsNha;
	}
	public ArrayList<Nha> getdsNha() {
		return dsNha;
	}
	public void setdsNha(ArrayList<Nha> dsNha) {
		this.dsNha = dsNha;
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
