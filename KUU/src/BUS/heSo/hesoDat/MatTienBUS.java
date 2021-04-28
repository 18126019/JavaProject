package src.BUS.heSo.hesoDat;
import java.sql.*;
import java.util.ArrayList;

import src.DAO.heSo.hesoDat.*;
import src.DTO.heSo.hesoDat.*;
import src.application.java.*;
public class MatTienBUS {
	private String tenMatTien;
    private float hesoMatTien;
    private int id = 0;
    //connect database
    CnnDB conn = new CnnDB();
    Connection cnn = conn.getDB();
    
    public MatTienBUS()
    {
        this.tenMatTien = "";
        this.hesoMatTien = 0;
    }
	public MatTienBUS(String ten, float hs ) {

		tenMatTien = ten;
		hesoMatTien = hs;
	}
    public float getHesoMatTien() {
        return hesoMatTien;
    }
    public String getTenMatTien() {
        return tenMatTien;
    }
    public int getId() {
    	return id;
    }
    public void setHesoMatTien(Float hesoMatTien) {
        this.hesoMatTien = hesoMatTien;
    }
    public void setTenMatTien(String tenMatTien) {
        this.tenMatTien = tenMatTien;
    }
    public void setId(int id) {
    	this.id = id;
    }

	public ArrayList<MatTienDTO> danhsachMatTien() {
		MatTienDAO matTienDAO = new MatTienDAO();
		MatTienDTO matTienDTO = new MatTienDTO();
		ArrayList<MatTienDTO> dsMatTien = matTienDTO.danhSachMatTien(matTienDAO);

		return dsMatTien;
	}
}