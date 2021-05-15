package src.DAO.heSo.hesoDat;
import java.sql.*;
import src.application.java.*;
public class MatTienDAO {
	private String tenMatTien;
    private float hesoMatTien;
    private int id = 0;
    //connect database
    CnnDB conn = new CnnDB();
    Connection cnn = conn.getDB();
    
    public MatTienDAO()
    {
        this.tenMatTien = "";
        this.hesoMatTien = 0;
    }
    
    public float getHesoMatTien() {
        return hesoMatTien;
    }
    public String getTenMatTien() {
        return tenMatTien;
    }
    public int getId() {
    	return id;
    }
    public void setHesoMatTien(Float hesoMatTien) {
        this.hesoMatTien = hesoMatTien;
    }
    public void setTenMatTien(String tenMatTien) {
        this.tenMatTien = tenMatTien;
    }
    public void setId(int id) {
    	this.id = id;
    }
    public void addMatTien(String tenMatTien, float hesoMatTien)
    {
    	try {
			Statement statement = cnn.createStatement();
			String insertSqlString = "Insert into HESOMATTIEN(ten, heso)" + "values('" + tenMatTien + "','" + hesoMatTien + "')";
			statement.executeUpdate(insertSqlString);
			cnn.commit();
			statement.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
    	
    }
    public void delMatTien(int id) {
    	try {
			Statement statement = cnn.createStatement();
			String deleteSqlString 	= "DELETE FROM HESOMATTIEN WHERE ID  = " + id;
			statement.executeUpdate(deleteSqlString);
			cnn.commit();
			statement.close();
		} catch (SQLException e) {
			System.out.println("Cannot delete student");
		}
    }
    public void editMatTien(MatTienDAO mt) {
    	try {
			Statement statement = cnn.createStatement();
			String updateSqlString = "Update HESOMATTIEN SET ten =" + "'" + mt.getTenMatTien() + "', heso= " + mt.getHesoMatTien() + " WHERE id = '" + this.getId() + "'";
			statement.executeUpdate(updateSqlString);
			cnn.commit();
			statement.close();	
		} catch (SQLException e) {
			System.out.println("Cannot update hem " + e);
		}
	}
    public ResultSet layMatTien() {
        ResultSet rs = null;
        try {
            Statement statement = cnn.createStatement();
            String selectString = "SELECT * FROM HESOMATTIEN";
            rs = statement.executeQuery(selectString);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
}