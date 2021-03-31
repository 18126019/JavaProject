package src.heSo.hesoDat;
import java.sql.*;
import src.application.java.CnnDB;
public class Hem {
	private String tenHem;
    private float hesoHem;
    private int id = 0;
    //connect database
    CnnDB conn = new CnnDB();
    Connection cnn = conn.getDB();
    public Hem()
    {
        tenHem = "";
        hesoHem = 0;
    }	
    public Hem(String ten, float hs ) {
 
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

    public void addHem() {
    	try {
			Statement statement = cnn.createStatement();
			String insertSqlString = "Insert into HESOHEM(ten, heso) values('" + this.getTenHem() + "','" + this.getHesoHem() + "')";
			statement.executeUpdate(insertSqlString);
			System.out.println("Add Sucessfully");
			String add = "SELECT ID FROM HESOHEM WHERE ten = '" + this.getTenHem() + "' AND heso = " + this.getHesoHem();
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
    public void delHem() {
    	try {
			Statement statement = cnn.createStatement();
			String deleteSqlString = "DELETE FROM HESOHEM WHERE ten = " + "'" + this.getTenHem() + "'";
			statement.executeUpdate(deleteSqlString);
			System.out.println("Delete Sucessfully");
			cnn.commit();
			statement.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
    }
    public void editHem(Hem hem) {
    	try {
			Statement statement = cnn.createStatement();
			String updateSqlString = "Update HESOHEM SET ten =" + "'" + hem.getTenHem() + "', heso= " + hem.getHesoHem() +
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