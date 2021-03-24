package heSo.hesoDat;
import java.sql.*;

public class HinhDang
{
	private String tenHinhDang;
    private float hesoHinhDang;
    private int id = 0;
    //connect database
    CnnDB conn = new CnnDB();
    Connection cnn = conn.getDB();
    
    public HinhDang()
    {
        this.tenHinhDang = "";
        this.hesoHinhDang = 0;
    }

    public float getHesoHinhDang() {
        return hesoHinhDang;
    }
    public String getTenHinhDang() {
        return tenHinhDang;
    }
    public void setHesoHinhDang(float hesoHinhDang) {
        this.hesoHinhDang = hesoHinhDang;
    }
    public void setTenHinhDang(String tenHinhDang) {
        this.tenHinhDang = tenHinhDang;
    }
}