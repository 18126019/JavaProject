package src.DTO.heSo;
import java.sql.*;
import src.application.java.CnnDB;

public class HeSoNcDTO {
	private String ten;
    private float heso;
    private int id = 0;
    //connect database
    CnnDB conn = new CnnDB();
    Connection cnn = conn.getDB();
    
    public HeSoNcDTO() {
        this.ten = "";
        this.heso = 0;
    }

    public HeSoNcDTO(String ten, float hs ) {
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
}