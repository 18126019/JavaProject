package src.DAO.nha;
import src.application.java.CnnDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class DangBanNhaDAO extends Nha {
	protected int maNguoiDung;
    protected String ketCau;
    protected String hem;
    protected String matTien;
    protected String ghiChu;
    protected String imgUrl;
    private int id = 0;
    //connect database
    CnnDB conn = new CnnDB();
    Connection cnn = conn.getDB();
    public DangBanNhaDAO()
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
    public String getImgUrl() {
        return this.imgUrl;
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
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public ResultSet layDangBanNha() {
        ResultSet rs = null;
        try {
            Statement statement = cnn.createStatement();
            String selectString = "SELECT * FROM NHADANGBAN";
            rs = statement.executeQuery(selectString);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
}
