package src.heSo.hesoDat;
import java.sql.*;
import src.application.java.*;
public class MatTien {
	private String tenMatTien;
    private float hesoMatTien;
    private int id = 0;
    //connect database
    CnnDB conn = new CnnDB();
    Connection cnn = conn.getDB();
    
    public MatTien()
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
    public void addMatTien()
    {
    	try {
			Statement statement = cnn.createStatement();
			String insertSqlString = "Insert into HESOMATTIEN(ten, heso)" + "values('" + this.getTenMatTien() + "','" + this.getHesoMatTien() + "')";
			statement.executeUpdate(insertSqlString);
			System.out.println("Add Sucessfully");
			String add = "SELECT ID FROM HESOMATTIEN WHERE ten = '" + this.getTenMatTien() + "' AND heso = " + this.getHesoMatTien();
			ResultSet rs = statement.executeQuery(add);
			while (rs.next()) {
				this.setId(rs.getInt("ID"));
			}
			cnn.commit();
			statement.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
    	
    }
    public void delMatTien() {
    	try {
			Statement statement = cnn.createStatement();
			String deleteSqlString 	= "DELETE FROM HESOMATTIEN WHERE ten = " + "'" + this.getTenMatTien() + "'";
			statement.executeUpdate(deleteSqlString);
			System.out.println("Delete Sucessfully");
			cnn.commit();
			statement.close();
		} catch (SQLException e) {
			System.out.println("Cannot delete student");
		}
    }
    public void editMatTien(MatTien mt) {
    	try {
			Statement statement = cnn.createStatement();
			String updateSqlString = "Update HESOMATTIEN SET ten =" + "'" + mt.getTenMatTien() + "', heso= " + mt.getHesoMatTien() +
					" WHERE id = '" + this.getId() + "'";
			statement.executeUpdate(updateSqlString);
			cnn.commit();
			System.out.println("Update success");
			statement.close();	
		} catch (SQLException e) {
			System.out.println("Cannot update hem " + e);
		}
	}
}