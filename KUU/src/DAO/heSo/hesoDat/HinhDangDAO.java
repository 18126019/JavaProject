package src.DAO.heSo.hesoDat;
import java.sql.*;
import src.application.java.*;
public class HinhDangDAO {
	private String tenHinhDang;
    private float hesoHinhDang;
    private int id = 0;
    //connect database
    CnnDB conn = new CnnDB();
    Connection cnn = conn.getDB();
    
    public HinhDangDAO()
    {
        this.tenHinhDang = "";
        this.hesoHinhDang = 0;
    }
	public int getId() {
		return id;
	}
    public float getHesoHinhDang() {
        return hesoHinhDang;
    }
    public String getTenHinhDang() {
        return tenHinhDang;
    }
	public void setHesoHinhDang(float hesoHinhDang) {
		this.hesoHinhDang = hesoHinhDang;
	}
	public void setTenHinhDang(String tenHinhDang) {
		this.tenHinhDang = tenHinhDang;
	}
	public void setId(int id) {
		this.id = id;
	}

    public void addHinhDang(String tenHinhDang, float hesoHinhDang) {
    	try {
			Statement statement = cnn.createStatement();
			String insertSqlString = "Insert into HESOHINHDANG(ten, heso)" + "values('" + tenHinhDang + "','" + hesoHinhDang + "')";
			statement.executeUpdate(insertSqlString);
			System.out.println("Add Sucessfully");
			cnn.commit();
			statement.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
    }

    public void delHinhDang(int id) {
    	try {
			Statement statement = cnn.createStatement();
			String deleteSqlString 	= "DELETE FROM HESOHINHDANG WHERE ID = " + id;
			statement.executeUpdate(deleteSqlString);
			System.out.println("Delete Sucessfully");
			cnn.commit();
			statement.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
    }
    public void editHinhDang(HinhDangDAO hd) {
    	try {
			Statement statement = cnn.createStatement();
			String updateSqlString = "Update HESOHINHDANG SET ten =" + "'" + hd.getTenHinhDang() + "', heso= " + hd.getHesoHinhDang() + " WHERE id = '" + this.getId() + "'";
			statement.executeUpdate(updateSqlString);
			cnn.commit();
			System.out.println("Update success");
			statement.close();	
		} catch (SQLException e) {
			System.out.println(e);
		}
    }
	public ResultSet layHinhDang() {
		ResultSet rs = null;
		try {
			Statement statement = cnn.createStatement();
			String selectString = "SELECT * FROM HESOHINHDANG";
			rs = statement.executeQuery(selectString);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
}