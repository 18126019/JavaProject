package src.DAO.heSo.hesoNha;
import java.sql.*;
import src.application.java.CnnDB;
public class TinhTrangDAO
{
	private String tenTinhTrang;
    private float hesoTinhTrang;
    private int id = 0;
    //connect database
    CnnDB conn = new CnnDB();
    Connection cnn = conn.getDB();
    
    public TinhTrangDAO()
    {
        this.hesoTinhTrang = 0;
        this.tenTinhTrang = "";
    }

    public TinhTrangDAO(String ten, float hs) {
    	 
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
			cnn.commit();
			statement.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
    }
    
    public void editTT(TinhTrangDAO tt) {
    	try {
			Statement statement = cnn.createStatement();
			String updateSqlString = "Update HESOTINHTRANG SET ten =" + "'" + tt.getTenTinhTrang() + "', heso= " + tt.getHesoTinhTrang() + " WHERE id = '" + this.getID() + "'";
			statement.executeUpdate(updateSqlString);
			cnn.commit();
			statement.close();	
			}  catch (SQLException e) {
			System.out.println(e);
		}
    }
    public ResultSet layTinhTrang() {
        ResultSet rs = null;
        try {
            Statement statement = cnn.createStatement();
            String selectString = "SELECT * FROM HESOTINHTRANG";
            rs = statement.executeQuery(selectString);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
}
