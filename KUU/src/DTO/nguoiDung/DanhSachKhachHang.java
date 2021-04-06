package src.DTO.nguoiDung;

import java.util.ArrayList;
import java.util.Collections;

public class DanhSachKhachHang {
	private ArrayList<KhachHang> dsKhachHang;
	
	public DanhSachKhachHang() {
		this.dsKhachHang = new ArrayList<>();
	}
	public ArrayList<KhachHang> getDsKhachHang() {
		return dsKhachHang;
	}
	public void setDsKhachHang(ArrayList<KhachHang> dsKhachHang) {
		this.dsKhachHang = dsKhachHang;
	}
}
