package src.BUS.heSo.hesoDat;
import java.sql.*;
import java.util.ArrayList;

import src.DAO.heSo.hesoDat.*;
import src.DTO.heSo.hesoDat.*;
import src.application.java.*;
public class HinhDangBUS {
	private String tenHinhDang;
    private float hesoHinhDang;
    private int id = 0;
    //connect database
    CnnDB conn = new CnnDB();
    Connection cnn = conn.getDB();
    
    public HinhDangBUS()
    {
        this.tenHinhDang = "";
        this.hesoHinhDang = 0;
    }

	public HinhDangBUS(String ten, float hs)
	{
		this.tenHinhDang = ten;
		this.hesoHinhDang = hs;
	}
	public int getId() {
		return id;
	}
    public float getHesoHinhDang() {
        return hesoHinhDang;
    }
    public String getTenHinhDang() {
        return tenHinhDang;
    }
	public void setHesoHinhDang(float hesoHinhDang) {
		this.hesoHinhDang = hesoHinhDang;
	}
	public void setTenHinhDang(String tenHinhDang) {
		this.tenHinhDang = tenHinhDang;
	}
	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<HinhDangDTO> danhsachHinhDang() {
		HinhDangDAO hinhDangDAO = new HinhDangDAO();
		HinhDangDTO hinhDangDTO = new HinhDangDTO();
		ArrayList<HinhDangDTO> dsHinhDang = hinhDangDTO.danhSachHinhDang(hinhDangDAO);

		return dsHinhDang;
	}
}