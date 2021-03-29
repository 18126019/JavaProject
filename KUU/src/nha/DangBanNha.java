package src.nha;
import java.sql.*;
import src.application.java.CnnDB;
public class DangBanNha extends Nha {
	protected int maNguoiDung;
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
        maNguoiDung = 0;
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
    public int getMaNguoiDung()
    {
    	return this.maNguoiDung;
    }
    
    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
    public void setHem(String hem) {
        this.hem = hem;
    }
    public void setKetCau(String ketCau) {
        this.ketCau = ketCau ;
    }
    public void setMatTien(String matTien) {
        this.matTien = matTien;
    }
    public void setMaNguoiDung(int MaNguoiDung)
    {
    	this.maNguoiDung = MaNguoiDung;
    }
    public void setID(int id) {
    	this.id = id;
    }
    

  
}
