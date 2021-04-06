package src.DTO.heSo.hesoDat;
import java.sql.*;
import src.application.java.*;
public class MatTien {
	private String tenMatTien;
    private float hesoMatTien;
    private int id = 0;
    //connect database
    CnnDB conn = new CnnDB();
    Connection cnn = conn.getDB();
    
    public MatTien()
    {
        this.tenMatTien = "";
        this.hesoMatTien = 0;
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
}