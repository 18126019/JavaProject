package heSo.hesoNha;
import java.sql.*;
public class TinhTrang
{
	private String tenTinhTrang;
    private float hesoTinhTrang;
    private int id = 0;
    //connect database
    CnnDB conn = new CnnDB();
    Connection cnn = conn.getDB();
    
    public TinhTrang()
    {
        this.hesoTinhTrang = 0;
        this.tenTinhTrang = "";
    }

    public float getHesoTinhTrang() {
        return hesoTinhTrang;
    }
    public String getTenTinhTrang() {
        return tenTinhTrang;
    }
    public void setHesoTinhTrang(float hesoTinhTrang) {
        this.hesoTinhTrang = hesoTinhTrang;
    }
    public void setTenTinhTrang(String tenTinhTrang) {
        this.tenTinhTrang = tenTinhTrang;
    }
}
