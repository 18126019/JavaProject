package src.BUS.heSo;
import java.sql.*;
import java.util.ArrayList;

import src.DAO.heSo.HeSoNcDAO;
import src.DAO.heSo.hesoDat.HinhDangDAO;
import src.DTO.heSo.HeSoNcDTO;
import src.DTO.heSo.hesoDat.HinhDangDTO;
import src.application.java.CnnDB;

public class HeSoNcBUS {
	private String ten;
    private float heso;
    private int id = 0;
    //connect database
    CnnDB conn = new CnnDB();
    Connection cnn = conn.getDB();
    
    public HeSoNcBUS() {
        this.ten = "";
        this.heso = 0;
    }

    public HeSoNcBUS(String ten, float hs ) {
    	this.ten = ten;
    	this.heso = hs;
    }
    
    public float getHeso() {
        return heso;
    }
    
    public String getTen() {
        return this.ten;
    }
    
    public int getID() {
		return this.id;
	}
    
    public void setHeso(float heso) {
        this.heso = heso;
    }
    
    public void setTen(String ten) {
        this.ten = ten;
    }
    
    public void setID(int id) {
		this.id = id;
	}

	public ArrayList<HeSoNcDTO> danhsachNgoaiCanh() {
		HeSoNcDTO heSoNcDTO = new HeSoNcDTO();
		HeSoNcDAO heSoNcDAO = new HeSoNcDAO();
		ArrayList<HeSoNcDTO> dsHeSoNc = heSoNcDTO.danhSachHeSoNn(heSoNcDAO);

		return dsHeSoNc;
	}
    
}