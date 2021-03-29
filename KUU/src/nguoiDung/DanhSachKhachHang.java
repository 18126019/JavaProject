package src.nguoiDung;

import java.util.ArrayList;
import java.util.Collections;

public class DanhSachKhachHang {
	private ArrayList<KhachHang> dsKhachHang;
	
	public DanhSachKhachHang() {
		this.dsKhachHang = new ArrayList<>();
	}
	public void sapXepTheoTen() {
		int n = this.dsKhachHang.size();
		for (int i = 0; i < n-1; i++) 
        { 
            int min_idx = i; 
            for (int j = i+1; j < n; j++) 
                if (this.dsKhachHang.get(j).getHoTen().compareTo(this.dsKhachHang.get(min_idx).getHoTen()) < 0) 
                    min_idx = j; 
            Collections.swap(this.dsKhachHang, min_idx, i);
        } 
	}
	public ArrayList<KhachHang> timKiemTheoTen(String ten) {
		ArrayList<KhachHang> temp = new ArrayList<>();
		for(int i = 0; i < this.dsKhachHang.size(); i++) {
			if(this.dsKhachHang.get(i).getHoTen() == ten) {
				temp.add(this.dsKhachHang.get(i));
			}
		}
		return temp;
	}
}
