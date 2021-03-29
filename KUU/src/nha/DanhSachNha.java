package src.nha;

import java.util.ArrayList;
import java.util.Collections;
import src.nguoiDung.KhachHang;

public class DanhSachNha {
	private ArrayList<Nha> dsNha;
	
	public DanhSachNha() {
		this.dsNha = new ArrayList<>();
	}
	public void sapXepTheoGia() {
		int n = this.dsNha.size();
		for (int i = 0; i < n-1; i++) 
        { 
            int min_idx = i; 
            for (int j = i+1; j < n; j++) 
                if (this.dsNha.get(j).giaTien < this.dsNha.get(min_idx).giaTien) 
                    min_idx = j; 
            Collections.swap(this.dsNha, min_idx, i);
        } 
	}
	public ArrayList<Nha> timKiemTheoDuong(String duong) {
		ArrayList<Nha> temp = new ArrayList<>();
		for(int i = 0; i < this.dsNha.size(); i++) {
			if(this.dsNha.get(i).duong == duong) {
				temp.add(this.dsNha.get(i));
			}
		}
		return temp;
	}
	public ArrayList<Nha> timKiemTheoQuan(String quan) {
		ArrayList<Nha> temp = new ArrayList<>();
		for(int i = 0; i < this.dsNha.size(); i++) {
			if(this.dsNha.get(i).quan == quan) {
				temp.add(this.dsNha.get(i));
			}
		}
		return temp;
	}
}
