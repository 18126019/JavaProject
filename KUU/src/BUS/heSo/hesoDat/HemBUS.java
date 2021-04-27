package src.BUS.heSo.hesoDat;
import java.sql.*;
import java.util.ArrayList;

import src.DAO.heSo.hesoDat.HemDAO;
import src.application.java.CnnDB;
import src.DTO.heSo.hesoDat.*;
public class HemBUS {
	private String tenHem;
    private float hesoHem;
    private int id = 0;
    //connect database
    CnnDB conn = new CnnDB();
    Connection cnn = conn.getDB();
    public HemBUS()
    {
        tenHem = "";
        hesoHem = 0;
    }	
    public HemBUS(String ten, float hs ) {
 
    	tenHem = ten;
    	hesoHem = hs;
    }
    public float getHesoHem() {
        return hesoHem;
    }
    public String getTenHem() {
        return tenHem;
    }
    public int getID() {
    	return id;
    }
    public void setHesoHem(float hesoHem) {
        this.hesoHem = hesoHem;
    }
    public void setTenHem(String tenHem) {
        this.tenHem = tenHem;
    }
    public void setID(int id) {
    	this.id = id;
    }

    public ArrayList<HemDTO> danhsachHem() {
        HemDAO hemDAO = new HemDAO();
        HemDTO hemDTO = new HemDTO();
        ArrayList<HemDTO> dsHem = hemDTO.danhSachHem(hemDAO);

        return dsHem;
    }
    
}