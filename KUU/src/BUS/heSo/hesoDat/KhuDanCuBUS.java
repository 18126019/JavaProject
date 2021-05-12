package src.BUS.heSo.hesoDat;
import java.sql.*;
import java.util.ArrayList;

import src.application.java.*;
import src.DAO.heSo.hesoDat.*;
import src.application.java.CnnDB;
import src.DTO.heSo.hesoDat.*;
public class KhuDanCuBUS {
	private String tenKhuDanCu;
    private float hesoKhuDanCu;
    private int id = 0;
    //connect database
    CnnDB conn = new CnnDB();
    Connection cnn = conn.getDB();
    
    public KhuDanCuBUS()
    {
        this.tenKhuDanCu = "";
        this.hesoKhuDanCu = 0;
    }

	public KhuDanCuBUS(String ten, float hs)
	{
		this.tenKhuDanCu = ten;
		this.hesoKhuDanCu = hs;
	}
    public float getHesoKhuDanCu() {
        return hesoKhuDanCu;
    }
    public String getTenKhuDanCu() {
        return tenKhuDanCu;
    }
    public int getId() {
    	return id;
    }
    public void setHesoKhuDanCu(float hesoKhuDanCu) {
        this.hesoKhuDanCu = hesoKhuDanCu;
    }
    public void setTenKhuDanCu(String tenKhuDanCu) {
        this.tenKhuDanCu = tenKhuDanCu;
    }
    public void setId(int id) {
    	this.id = id;
    }

	public ArrayList<KhuDanCuDTO> danhsachKhuDanCu() {
		KhuDanCuDAO khuDanCuDAO = new KhuDanCuDAO();
		KhuDanCuDTO khuDanCuDTO = new KhuDanCuDTO();
		ArrayList<KhuDanCuDTO> dsKhuDanCu = khuDanCuDTO.danhSachKhuDanCu(khuDanCuDAO);

		return dsKhuDanCu;
	}
}