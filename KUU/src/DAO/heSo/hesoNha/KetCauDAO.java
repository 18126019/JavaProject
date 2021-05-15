package src.DAO.heSo.hesoNha;
import java.sql.*;
import src.application.java.CnnDB;

public class KetCauDAO
{
	private String tenKetCau;
    private float hesoKetCau;
    private int id = 0;
    //connect database
    CnnDB conn = new CnnDB();
    Connection cnn = conn.getDB();
    
    public KetCauDAO()
    {
        this.hesoKetCau = 0;
        this.tenKetCau = "";
    }

    public float getHesoKetCau() {
        return hesoKetCau;
    }
    public String getTenKetCau() {
        return tenKetCau;
    }
    public int getID() {
		return id;
	}
    public void setHesoKetCau(float hesoKetCau) {
        this.hesoKetCau = hesoKetCau;
    }
    public void setTenKetCau(String tenKetCau) {
        this.tenKetCau = tenKetCau;
    }
    public void setID(int id) {
		this.id = id;
	}
 
    public void addKC(String tenKetCau, float hesoKetCau) {
    	try {
			Statement statement = cnn.createStatement();
			String insertSqlString = "Insert into HESOKETCAU(ten, heso) values('" + tenKetCau + "','" + hesoKetCau + "')";
			statement.executeUpdate(insertSqlString);
			cnn.commit();
			statement.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
    	
    }
    public void delKC() {
    	try {
			Statement statement = cnn.createStatement();
			String deleteSqlString = "DELETE FROM HESOKETCAU WHERE ten = " + "'" + this.getTenKetCau() + "'";
			statement.executeUpdate(deleteSqlString);
			cnn.commit();
			statement.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
    }
    public void editKC(KetCauDAO kc) {
    	try {
			Statement statement = cnn.createStatement();
			String updateSqlString = "Update HESOKETCAU SET ten =" + "'" + kc.getTenKetCau() + "', heso= " + kc.getHesoKetCau() + " WHERE id = '" + this.getID() + "'";
			statement.executeUpdate(updateSqlString);	
			cnn.commit();	
			statement.close();	
			}  catch (SQLException e) {
			System.out.println(e);
		}
    }
	public ResultSet layKetCau() {
		ResultSet rs = null;
		try {
			Statement statement = cnn.createStatement();
			String selectString = "SELECT * FROM HESOKETCAU";
			rs = statement.executeQuery(selectString);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
}
