package src.BUS.heSo.hesoNha;
import java.sql.*;
import java.util.ArrayList;

import src.DAO.heSo.hesoDat.HemDAO;
import src.DAO.heSo.hesoNha.TinhTrangDAO;
import src.DTO.heSo.hesoDat.HemDTO;
import src.DTO.heSo.hesoNha.TinhTrangDTO;
import src.application.java.CnnDB;
public class TinhTrangBUS
{
	private String tenTinhTrang;
    private float hesoTinhTrang;
    private int id = 0;
    //connect database
    CnnDB conn = new CnnDB();
    Connection cnn = conn.getDB();
    
    public TinhTrangBUS()
    {
        this.hesoTinhTrang = 0;
        this.tenTinhTrang = "";
    }

    public TinhTrangBUS(String ten, float hs) {
    	 
    	this.tenTinhTrang = ten;
    	this.hesoTinhTrang = hs;
    }
    
    public float getHesoTinhTrang() {
        return hesoTinhTrang;
    }
    
    public String getTenTinhTrang() {
        return tenTinhTrang;
    }
    
    public int getID() {
    	return this.id;
    }
    
    public void setHesoTinhTrang(float hesoTinhTrang) {
        this.hesoTinhTrang = hesoTinhTrang;
    }
    
    public void setTenTinhTrang(String tenTinhTrang) {
        this.tenTinhTrang = tenTinhTrang;
    }
    
    public void setID(int id) {
    	this.id = id;
    }


	public ArrayList<TinhTrangDTO> danhsachTinhTrang() {
		TinhTrangDAO tinhTrangDAO = new TinhTrangDAO();
		TinhTrangDTO tinhTrangDTO = new TinhTrangDTO();
		ArrayList<TinhTrangDTO> dsTinhTrang = tinhTrangDTO.danhSachHem(tinhTrangDAO);

		return dsTinhTrang;
	}
}
