package src.DAO.heSo;
import java.sql.*;
import src.application.java.CnnDB;

public class HeSoNcDAO {
	private String ten;
    private float heso;
    private int id = 0;
    //connect database
    CnnDB conn = new CnnDB();
    Connection cnn = conn.getDB();
    
    public HeSoNcDAO() {
        this.ten = "";
        this.heso = 0;
    }

    public HeSoNcDAO(String ten, float hs ) {
    	this.ten = ten;
    	this.heso = hs;
    }
    
    public float getHeso() {
        return heso;
    }
    
    public String getTen() {
        return this.ten;
    }
    
    public int getID() {
		return this.id;
	}
    
    public void setHeso(float heso) {
        this.heso = heso;
    }
    
    public void setTen(String ten) {
        this.ten = ten;
    }
    
    public void setID(int id) {
		this.id = id;
	}
    public void addNC(String ten, float heso) {
    	try {
			Statement statement = cnn.createStatement();
			String insertSqlString = "Insert into HESONGOAICANH(ten, heso) values('" + ten + "','" + heso + "')";
			statement.executeUpdate(insertSqlString);
			cnn.commit();
			statement.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
    	
    }
    public void delNC() {
    	try {
			Statement statement = cnn.createStatement();
			String deleteSqlString = "DELETE FROM HESONGOAICANH WHERE ten = " + "'" + this.getTen() + "'";
			statement.executeUpdate(deleteSqlString);
			cnn.commit();
			statement.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
    }
    public void editNC(HeSoNcDAO nc) {
    	try {
			Statement statement = cnn.createStatement();
			String updateSqlString = "Update HESONGOAICANH SET ten =" + "'" + nc.getTen() + "', heso= " + nc.getHeso() + " WHERE id = '" + this.getID() + "'";
			statement.executeUpdate(updateSqlString);
			cnn.commit();
			statement.close();	
			}  catch (SQLException e) {
			System.out.println(e);
		}
    }
	public ResultSet layHeSoNC() {
		ResultSet rs = null;
		try {
			Statement statement = cnn.createStatement();
			String selectString = "SELECT * FROM HESONGOAICANH";
			rs = statement.executeQuery(selectString);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
    
}