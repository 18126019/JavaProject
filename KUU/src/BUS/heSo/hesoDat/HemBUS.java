package src.BUS.heSo.hesoDat;
import src.DTO.heSo.hesoDat.HemDTO;
import src.application.java.CnnDB;

import java.sql.Connection;
import java.util.ArrayList;

import src.DAO.heSo.hesoDat.HemDAO;

public class HemBUS {
	private String tenHem;
    private float hesoHem;
    private int id = 0;
    private ArrayList<HemDTO> dsHem;
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

        return hemDTO.danhSachHem(hemDAO);
    }
}