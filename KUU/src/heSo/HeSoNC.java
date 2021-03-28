package heSo;
import java.sql.*;
public class hesoKhac 
{
	private String tenHesoKhac;
    private float heso;
    private int id = 0;
    //connect database
    CnnDB conn = new CnnDB();
    Connection cnn = conn.getDB();
    
    public hesoKhac()
    {
        this.tenHesoKhac = "";
        this.heso = 0;
    }

    public float getHeso() {
        return heso;
    }
    public String getTenHesoKhac() {
        return tenHesoKhac;
    }
    public void setHeso(float heso) {
        this.heso = heso;
    }
    public void setTenHesoKhac(String tenHesoKhac) {
        this.tenHesoKhac = tenHesoKhac;
    }
}