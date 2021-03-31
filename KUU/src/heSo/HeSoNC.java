package src.heSo;
import java.sql.*;
import src.application.java.CnnDB;

public class HeSoNC {
	private String ten;
    private float heso;
    private int id = 0;
    //connect database
    CnnDB conn = new CnnDB();
    Connection cnn = conn.getDB();
    
    public HeSoNC() {
        this.ten = "";
        this.heso = 0;
    }

    public HeSoNC(String ten, float hs ) {
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
    
    public void addNC() {
    	try {
			Statement statement = cnn.createStatement();
			String insertSqlString = "Insert into HESONGOAICANH(ten, heso) values('" + this.getTen() + "','" + this.getHeso() + "')";
			statement.executeUpdate(insertSqlString);
			System.out.println("Add Sucessfully");
			String add = "SELECT ID FROM HESONGOAICANH WHERE ten = '" + this.getTen() + "' AND heso = " + this.getHeso();
			ResultSet rs = statement.executeQuery(add);
			while (rs.next()) {
				this.setID(rs.getInt("ID"));
			}
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
			System.out.println("Delete Sucessfully");
			cnn.commit();
			statement.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
    }
    public void editNC(HeSoNC nc) {
    	try {
			Statement statement = cnn.createStatement();
			String updateSqlString = "Update HESONGOAICANH SET ten =" + "'" + nc.getTen() + "', heso= " + nc.getHeso() +
					" WHERE id = '" + this.getID() + "'";
			statement.executeUpdate(updateSqlString);
			
			cnn.commit();
			System.out.println("Update success");
			statement.close();	
		
			}  catch (SQLException e) {
			System.out.println(e);
		}
    }
    
}