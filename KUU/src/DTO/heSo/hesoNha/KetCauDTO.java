package src.DTO.heSo.hesoNha;
import java.sql.*;
import src.application.java.CnnDB;

public class KetCauDTO
{
	private String tenKetCau;
    private float hesoKetCau;
    private int id = 0;
    //connect database
    CnnDB conn = new CnnDB();
    Connection cnn = conn.getDB();
    
    public KetCauDTO()
    {
        this.hesoKetCau = 0;
        this.tenKetCau = "";
    }

    public float getHesoKetCau() {
        return hesoKetCau;
    }
    public String getTenKetCau() {
        return tenKetCau;
    }
    public int getID() {
		return id;
	}
    public void setHesoKetCau(float hesoKetCau) {
        this.hesoKetCau = hesoKetCau;
    }
    public void setTenKetCau(String tenKetCau) {
        this.tenKetCau = tenKetCau;
    }
    public void setID(int id) {
		this.id = id;
	}
}
