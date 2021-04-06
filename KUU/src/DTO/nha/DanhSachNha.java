package src.DTO.nha;

import java.util.ArrayList;
import java.util.Collections;
import src.DTO.nguoiDung.KhachHang;

public class DanhSachNha {
	private ArrayList<Nha> dsNha;
	
	public DanhSachNha() {
		this.dsNha = new ArrayList<>();
	}
	public ArrayList<Nha> getDsNha() {
		return dsNha;
	}
	public void setDsNha(ArrayList<Nha> dsNha) {
		this.dsNha = dsNha;
	}
}
