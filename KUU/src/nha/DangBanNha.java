package nha;
import java.sql.*;
public class DangBanNha extends Nha {
    protected String ketCau;
    protected String hem;
    protected String matTien;
    protected String ghiChu;
    private int id = 0;
    //connect database
    CnnDB conn = new CnnDB();
    Connection cnn = conn.getDB();
    public DangBanNha()
    {
        super();
        ketCau = "";
        hem = "";
        matTien = "";
        ghiChu = "";
    }
    public String getGhiChu() {
        return ghiChu;
    }
    public String getHem() {
        return hem;
    }
    public String getKetCau() {
        return ketCau;
    }
    public String getMatTien() {
        return matTien;
    }
    public int getID() {
    	return id;
    }
    public void setID(int id) {
    	this.id = id;
    }
    
    public void suaNha()
    {
        //
    }
    
  
}
