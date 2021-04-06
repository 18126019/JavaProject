package src.BUS.heSo.hesoNha;
import java.sql.*;
import src.application.java.CnnDB;
public class TinhTrang
{
	private String tenTinhTrang;
    private float hesoTinhTrang;
    private int id = 0;
    //connect database
    CnnDB conn = new CnnDB();
    Connection cnn = conn.getDB();
    
    public TinhTrang()
    {
        this.hesoTinhTrang = 0;
        this.tenTinhTrang = "";
    }

    public TinhTrang(String ten, float hs) {
    	 
    	this.tenTinhTrang = ten;
    	this.hesoTinhTrang = hs;
    }
    
    public float getHesoTinhTrang() {
        return hesoTinhTrang;
    }
    
    public String getTenTinhTrang() {
        return tenTinhTrang;
    }
    
    public int getID() {
    	return this.id;
    }
    
    public void setHesoTinhTrang(float hesoTinhTrang) {
        this.hesoTinhTrang = hesoTinhTrang;
    }
    
    public void setTenTinhTrang(String tenTinhTrang) {
        this.tenTinhTrang = tenTinhTrang;
    }
    
    public void setID(int id) {
    	this.id = id;
    }
    
    public void addTT() {
    	try {
			Statement statement = cnn.createStatement();
			String insertSqlString = "Insert into HESOTINHTRANG(ten, heso) values('" + this.getTenTinhTrang() + "','" + this.getHesoTinhTrang() + "')";
			statement.executeUpdate(insertSqlString);
			System.out.println("Add Sucessfully");
			String add = "SELECT ID FROM HESOTINHTRANG WHERE ten = '" + this.getTenTinhTrang() + "' AND heso = " + this.getHesoTinhTrang();
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
    
    public void delTT() {
    	try {
			Statement statement = cnn.createStatement();
			String deleteSqlString = "DELETE FROM HESOTINHTRANG WHERE ten = " + "'" + this.getTenTinhTrang() + "'";
			statement.executeUpdate(deleteSqlString);
			System.out.println("Delete Sucessfully");
			cnn.commit();
			statement.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
    }
    
    public void editTT(TinhTrang tt) {
    	try {
			Statement statement = cnn.createStatement();
			String updateSqlString = "Update HESOTINHTRANG SET ten =" + "'" + tt.getTenTinhTrang() + "', heso= " + tt.getHesoTinhTrang() +
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
