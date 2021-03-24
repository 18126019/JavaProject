package heSo.hesoNha;
import java.sql.*;

public class NoiThat
{
	private String tenNoiThat;
    private float hesoNoiThat;
    private int id = 0;
    //connect database
    CnnDB conn = new CnnDB();
    Connection cnn = conn.getDB();
    
    public NoiThat()
    {
        this.hesoNoiThat = 0;
        this.tenNoiThat = "";
    }

    public float getHesoNoiThat() {
        return hesoNoiThat;
    }
    public String getTenNoiThat() {
        return tenNoiThat;
    }
    public void setHesoNoiThat(float hesoNoiThat) {
        this.hesoNoiThat = hesoNoiThat;
    }
    public void setTenNoiThat(String tenNoiThat) {
        this.tenNoiThat = tenNoiThat;
    }
}