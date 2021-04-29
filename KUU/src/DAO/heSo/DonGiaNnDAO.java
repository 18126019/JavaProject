package src.DAO.heSo;
import src.application.java.*;
import java.sql.*;

public class DonGiaNnDAO {
	private String duong;
	private String quan;
	private float giaTien;
	private int id = 0;
    //connect database
    CnnDB conn = new CnnDB();
    Connection cnn = conn.getDB();

   public DonGiaNnDAO() {
       duong = "";
       quan = "";
       giaTien = 0;
   }
   public int getID() {
	return id;
   }
   public void setID(int id) {
	this.id = id;
   }
   public String getDuong() {
	   return this.duong;
   }
   public String getQuan() {
	   return this.quan;
   }
   public float getGiaTien() {
	   return this.giaTien;
   }
   public void setDuong(String duong) {
	   this.duong = duong;
   }
   public void setQuan(String quan) {
	   this.quan = quan;
   }
   public void setGiaTien(float giaTien) {
	   this.giaTien = giaTien;
   }

   public void addDonGiaNN() {
   	try {
			Statement statement = cnn.createStatement();
			String insertSqlString = "Insert into DONGIANHANUOC(duong, quan, dongia)" + "values('" + this.getDuong() + "','" + this.getQuan() + "','" + this.getGiaTien() + "')";
			statement.executeUpdate(insertSqlString);
			cnn.commit();
			statement.close();
		} catch (SQLException e) {
			System.out.println("Cannot insert hem");
		}
   }

   public void delDonGiaNN() {
   	try {
			Statement statement = cnn.createStatement();
			String deleteSqlString = "DELETE FROM DONGIANHANUOC WHERE duong = " + "'" + this.getDuong() + "' AND quan = " + this.getQuan() + "'";
			statement.executeUpdate(deleteSqlString);
			cnn.commit();
			statement.close();
		} catch (SQLException e) {
			System.out.println("Cannot delete student");
		}
   }
   public void editDonGiaNN(DonGiaNnDAO dgnn) {
   	try {
			Statement statement = cnn.createStatement();
			String updateSqlString = "Update DONGIANHANUOC SET duong =" + "'" + this.getDuong() + "', quan= " + this.getQuan() + " WHERE id = '" + this.getID() + "'";
			statement.executeUpdate(updateSqlString);
			cnn.commit();
			statement.close();	
		} catch (SQLException e) {
			System.out.println(e);
		}
   }
   public ResultSet layDonGiaNN() {
   	ResultSet rs = null;
   	try {
   		Statement statement = cnn.createStatement();
   		String selectString = "SELECT * FROM DONGIANHANUOC";
   		rs = statement.executeQuery(selectString);
	} catch (SQLException e) {
   		e.printStackTrace();
	}
   	return rs;
   }

}
