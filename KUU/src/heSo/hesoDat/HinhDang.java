package src.heSo.hesoDat;
import java.sql.*;
import src.application.java.*;
public class HinhDang {
	private String tenHinhDang;
    private float hesoHinhDang;
    private int id = 0;
    //connect database
    CnnDB conn = new CnnDB();
    Connection cnn = conn.getDB();
    
    public HinhDang()
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

    public void addHinhDang() {
    	try {
			Statement statement = cnn.createStatement();
			String insertSqlString = "Insert into HESOHINHDANG(ten, heso)" + "values('" + this.getTenHinhDang() + "','" + this.getHesoHinhDang() + "')";
			statement.executeUpdate(insertSqlString);
			System.out.println("Add Sucessfully");
			String add = "SELECT ID FROM HESOHINHDANG WHERE ten = '" + this.getTenHinhDang() + "' AND heso = " + this.getHesoHinhDang();
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

    public void delHinhDang() {
    	try {
			Statement statement = cnn.createStatement();
			String deleteSqlString 	= "DELETE FROM HESOHINHDANG WHERE ten = " + "'" + this.getTenHinhDang() + "'";
			statement.executeUpdate(deleteSqlString);
			System.out.println("Delete Sucessfully");
			cnn.commit();
			statement.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
    }
    public void editHinhDang(HinhDang hd) {
    	try {
			Statement statement = cnn.createStatement();
			String updateSqlString = "Update HESOHINHDANG SET ten =" + "'" + hd.getTenHinhDang() + "', heso= " + hd.getHesoHinhDang() +
					" WHERE id = '" + this.getId() + "'";
			statement.executeUpdate(updateSqlString);
			cnn.commit();
			System.out.println("Update success");
			statement.close();	
		} catch (SQLException e) {
			System.out.println(e);
		}
    }
}