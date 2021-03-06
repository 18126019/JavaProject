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
    public void xoaNha(int id, int maNguoiDung) {
        try {
            Statement statement = cnn.createStatement();
            String deleteString = "UPDATE NHADANGBAN SET daxoa = 1 WHERE ID = '" + id + "' AND manguoidung = '" + maNguoiDung + "'";
            statement.executeUpdate(deleteString);
            cnn.commit();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateSoNha(String soNha, int id) {
        try {
            Statement statement = cnn.createStatement();
            String update = "UPDATE NHADANGBAN SET sonha = '" + soNha + "' WHERE id = '" + id + "'";
            statement.executeUpdate(update);
            cnn.commit();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateDuong(String duong, int id) {
        try {
            Statement statement = cnn.createStatement();
            String update = "UPDATE NHADANGBAN SET duong = '" + duong + "' WHERE id = '" + id + "'";
            statement.executeUpdate(update);
            cnn.commit();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePhuong(String phuong, int id) {
        try {
            Statement statement = cnn.createStatement();
            String update = "UPDATE NHADANGBAN SET phuong = '" + phuong + "' WHERE id = '" + id + "'";
            statement.executeUpdate(update);
            cnn.commit();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateQuan(String quan, int id) {
        try {
            Statement statement = cnn.createStatement();
            String update = "UPDATE NHADANGBAN SET quan = '" + quan + "' WHERE id = '" + id + "'";
            statement.executeUpdate(update);
            cnn.commit();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateGhiChu(String ghichu, int id) {
        try {
            Statement statement = cnn.createStatement();
            String update = "UPDATE NHADANGBAN SET ghichu = '" + ghichu + "' WHERE id = '" + id + "'";
            statement.executeUpdate(update);
            cnn.commit();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateDienTich(Float dienTich, int id) {
        try {
            Statement statement = cnn.createStatement();
            String update = "UPDATE NHADANGBAN SET dientich = '" + dienTich + "' WHERE id = '" + id + "'";
            statement.executeUpdate(update);
            cnn.commit();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateSoTang(Float soTang, int id) {
        try {
            Statement statement = cnn.createStatement();
            String update = "UPDATE NHADANGBAN SET sotang = '" + soTang + "' WHERE id = '" + id + "'";
            statement.executeUpdate(update);
            cnn.commit();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateGiaTien(Float giaTien, int id) {
        try {
            Statement statement = cnn.createStatement();
            String update = "UPDATE NHADANGBAN SET giatien = '" + giaTien + "' WHERE id = '" + id + "'";
            statement.executeUpdate(update);
            cnn.commit();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateDaXoa(Integer daXoa, int id) {
        try {
            Statement statement = cnn.createStatement();
            String update = "UPDATE NHADANGBAN SET daxoa = '" + daXoa + "' WHERE id = '" + id + "'";
            statement.executeUpdate(update);
            cnn.commit();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
