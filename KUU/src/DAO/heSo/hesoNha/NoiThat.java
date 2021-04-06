package src.DAO.heSo.hesoNha;
import java.sql.*;
import src.application.java.CnnDB;
public class NoiThat
{
	private String tenNoiThat;
    private float hesoNoiThat;
    private int id = 0;
    //connect database
    CnnDB conn = new CnnDB();
    Connection cnn = conn.getDB();
    
    public NoiThat()
    {
        this.hesoNoiThat = 0;
        this.tenNoiThat = "";
    }

    public float getHesoNoiThat() {
        return hesoNoiThat;
    }
    public String getTenNoiThat() {
        return tenNoiThat;
    }
    public int getID() {
    	return id;
    }
    public void setHesoNoiThat(float hesoNoiThat) {
        this.hesoNoiThat = hesoNoiThat;
    }
    public void setTenNoiThat(String tenNoiThat) {
        this.tenNoiThat = tenNoiThat;
    }
    public void setID(int id) {
    	this.id = id;
    }
    
    public void addNT() {
    	try {
			Statement statement = cnn.createStatement();
			String insertSqlString = "Insert into HESONOITHAT(ten, heso) values('" + this.getTenNoiThat() + "','" + this.getHesoNoiThat() + "')";
			statement.executeUpdate(insertSqlString);
			cnn.commit();
			statement.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
    	
    }
    public void delNT() {
    	try {
			Statement statement = cnn.createStatement();
			String deleteSqlString = "DELETE FROM HESONOITHAT WHERE ten = " + "'" + this.getTenNoiThat() + "'";
			statement.executeUpdate(deleteSqlString);
			cnn.commit();
			statement.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
    }
    public void editNT(NoiThat nt) {
    	try {
			Statement statement = cnn.createStatement();
			String updateSqlString = "Update HESONOITHAT SET ten =" + "'" + nt.getTenNoiThat() + "', heso= " + nt.getHesoNoiThat() + " WHERE id = '" + this.getID() + "'";
			statement.executeUpdate(updateSqlString);
			cnn.commit();
			statement.close();	
			}  catch (SQLException e) {
			System.out.println(e);
		}
    }
}