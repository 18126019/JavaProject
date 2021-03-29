package src.heSo;
import java.sql.*;
import src.application.java.CnnDB;
public class HeSoNC 
{
	private String ten;
    private float heso;
    private int id = 0;
    //connect database
    CnnDB conn = new CnnDB();
    Connection cnn = conn.getDB();
    
    public HeSoNC() {
        this.ten = "";
        this.heso = 0;
    }

    public HeSoNC(String ten, float hs ) {
    	this.ten = ten;
    	this.heso = hs;
    }
    
    public float getHeso() {
        return heso;
    }
    
    public String getTen() {
        return this.ten;
    }
    
    public void setHeso(float heso) {
        this.heso = heso;
    }
    
    public void setTen(String ten) {
        this.ten = ten;
    }
}