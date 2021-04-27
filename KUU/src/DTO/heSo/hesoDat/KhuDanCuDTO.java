package src.DTO.heSo.hesoDat;
import java.sql.*;
import src.application.java.*;
public class KhuDanCuDTO {
	private String tenKhuDanCu;
    private float hesoKhuDanCu;
    private int id = 0;
    //connect database
    CnnDB conn = new CnnDB();
    Connection cnn = conn.getDB();
    
    public KhuDanCuDTO()
    {
        this.tenKhuDanCu = "";
        this.hesoKhuDanCu = 0;
    }

    public float getHesoKhuDanCu() {
        return hesoKhuDanCu;
    }
    public String getTenKhuDanCu() {
        return tenKhuDanCu;
    }
    public int getId() {
    	return id;
    }
    public void setHesoKhuDanCu(float hesoKhuDanCu) {
        this.hesoKhuDanCu = hesoKhuDanCu;
    }
    public void setTenKhuDanCu(String tenKhuDanCu) {
        this.tenKhuDanCu = tenKhuDanCu;
    }
    public void setId(int id) {
    	this.id = id;
    }
}