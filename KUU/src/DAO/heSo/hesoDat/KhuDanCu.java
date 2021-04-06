package src.DAO.heSo.hesoDat;
import java.sql.*;
import src.application.java.*;
public class KhuDanCu {
	private String tenKhuDanCu;
    private float hesoKhuDanCu;
    private int id = 0;
    //connect database
    CnnDB conn = new CnnDB();
    Connection cnn = conn.getDB();
    
    public KhuDanCu()
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
    public void addKhuDanCu()
    {
    	try {
			Statement statement = cnn.createStatement();
			String insertSqlString = "Insert into HESOKHUDANCU(ten, heso)" + "values('" + this.getTenKhuDanCu() + "','" + this.getHesoKhuDanCu() + "')";
			statement.executeUpdate(insertSqlString);
			cnn.commit();
			statement.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
    	
    }
    public void delKhuDanCu() {
    	try {
			Statement statement = cnn.createStatement();
			String deleteSqlString 	= "DELETE FROM HESOKHUDANCU WHERE ten = " + "'" + this.getTenKhuDanCu() + "'";
			statement.executeUpdate(deleteSqlString);
			cnn.commit();
			statement.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
    }
    public void editKhuDanCu(KhuDanCu kdc) {
    	try {
			Statement statement = cnn.createStatement();
			String updateSqlString = "Update HESOKHUDANCU SET ten =" + "'" + kdc.getTenKhuDanCu() + "', heso= " + kdc.getHesoKhuDanCu() + " WHERE id = '" + this.getId() + "'";
			statement.executeUpdate(updateSqlString);
			cnn.commit();
			
			statement.close();	
		} catch (SQLException e) {
			System.out.println("Cannot update hem " + e);
		}
	}
}