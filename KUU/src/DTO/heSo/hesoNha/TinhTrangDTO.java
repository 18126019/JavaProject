package src.DTO.heSo.hesoNha;
import java.sql.*;
import src.application.java.CnnDB;
public class TinhTrangDTO
{
	private String tenTinhTrang;
    private float hesoTinhTrang;
    private int id = 0;
    //connect database
    CnnDB conn = new CnnDB();
    Connection cnn = conn.getDB();
    
    public TinhTrangDTO()
    {
        this.hesoTinhTrang = 0;
        this.tenTinhTrang = "";
    }

    public TinhTrangDTO(String ten, float hs) {
    	 
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
}
