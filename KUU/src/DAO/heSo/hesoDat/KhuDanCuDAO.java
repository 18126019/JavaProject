package src.DAO.heSo.hesoDat;
import java.sql.*;
import src.application.java.*;
public class KhuDanCuDAO {
	private String tenKhuDanCu;
    private float hesoKhuDanCu;
    private int id = 0;
    //connect database
    CnnDB conn = new CnnDB();
    Connection cnn = conn.getDB();
    
    public KhuDanCuDAO()
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
    public void addKhuDanCu(String tenKhuDanCu, float hesoKhuDanCu)
    {
    	try {
			Statement statement = cnn.createStatement();
			String insertSqlString = "Insert into HESOKHUDANCU(ten, heso)" + "values('" + tenKhuDanCu + "','" + hesoKhuDanCu + "')";
			statement.executeUpdate(insertSqlString);
			cnn.commit();
			statement.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
    	
    }
    public void delKhuDanCu(int id) {
    	try {
			Statement statement = cnn.createStatement();
			String deleteSqlString 	= "DELETE FROM HESOKHUDANCU WHERE ID = " + id;
			statement.executeUpdate(deleteSqlString);
			cnn.commit();
			statement.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
    }
    public void editKhuDanCu(KhuDanCuDAO kdc) {
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
    public ResultSet layKhuDanCu() {
        ResultSet rs = null;
        try {
            Statement statement = cnn.createStatement();
            String selectString = "SELECT * FROM HESOKHUDANCU";
            rs = statement.executeQuery(selectString);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
	public void updateTen(String ten, int id) {
		try {
			Statement statement = cnn.createStatement();
			String update = "UPDATE HESOKHUDANCU SET ten = '" + ten + "' WHERE id = " + id;
			statement.executeUpdate(update);
			cnn.commit();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void updateHeSo(Float heSo, int id) {
		try {
			Statement statement = cnn.createStatement();
			String update = "UPDATE HESOKHUDANCU SET heso = " + heSo + " WHERE id = " + id;
			statement.executeUpdate(update);
			cnn.commit();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}