package src.DAO.heSo.hesoDat;
import java.sql.*;
import src.application.java.CnnDB;
public class HemDAO {
	private String tenHem;
    private float hesoHem;
    private int id = 0;
    //connect database
    CnnDB conn = new CnnDB();
    Connection cnn = conn.getDB();
    public HemDAO()
    {
        tenHem = "";
        hesoHem = 0;
    }	
    public HemDAO(String ten, float hs ) {
 
    	tenHem = ten;
    	hesoHem = hs;
    }
    public float getHesoHem() {
        return hesoHem;
    }
    public String getTenHem() {
        return tenHem;
    }
    public int getID() {
    	return id;
    }
    public void setHesoHem(float hesoHem) {
        this.hesoHem = hesoHem;
    }
    public void setTenHem(String tenHem) {
        this.tenHem = tenHem;
    }
    public void setID(int id) {
    	this.id = id;
    }

    public void addHem(String tenHem, float hesoHem) {
    	try {
			Statement statement = cnn.createStatement();
			String insertSqlString = "Insert into HESOHEM(ten, heso) values(N'" + tenHem + "','" + hesoHem + "')";
			statement.executeUpdate(insertSqlString);
			System.out.println("Add Sucessfully");
			cnn.commit();
			statement.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
    	
    }
    public void delHem(int id) {
    	try {
			Statement statement = cnn.createStatement();
			String deleteSqlString = "DELETE FROM HESOHEM WHERE id = " + id;
			statement.executeUpdate(deleteSqlString);
			cnn.commit();
			statement.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
    }
    public void editHem(HemDAO hemDAO) {
    	try {
			Statement statement = cnn.createStatement();
			String updateSqlString = "Update HESOHEM SET ten =" + "'" + hemDAO.getTenHem() + "', heso= " + hemDAO.getHesoHem() + " WHERE id = '" + this.getID() + "'";
			statement.executeUpdate(updateSqlString);
			cnn.commit();
			statement.close();	
		
			}  catch (SQLException e) {
			System.out.println(e);
		}
    }
    public ResultSet layHem() {
        ResultSet rs = null;
        try {
            Statement statement = cnn.createStatement();
            String selectString = "SELECT * FROM HESOHEM";
            rs = statement.executeQuery(selectString);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public void updateTen(String ten, int id) {
        try {
            Statement statement = cnn.createStatement();
            String update = "UPDATE HESOHEM SET ten = '" + ten + "' WHERE id = " + id;
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
            String update = "UPDATE HESOHEM SET heso = " + heSo + " WHERE id = " + id;
            statement.executeUpdate(update);
            cnn.commit();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}