package src.DTO.heSo.hesoDat;
import java.sql.*;
import src.application.java.CnnDB;
public class Hem {
	private String tenHem;
    private float hesoHem;
    private int id = 0;
    //connect database
    CnnDB conn = new CnnDB();
    Connection cnn = conn.getDB();
    public Hem()
    {
        tenHem = "";
        hesoHem = 0;
    }	
    public Hem(String ten, float hs ) {
 
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
}