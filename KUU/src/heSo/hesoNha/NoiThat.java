package heSo.hesoNha;
import java.sql.*;

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
    
    public void addNoiThat(NoiThat NT)
    {
    	try {
			Statement statement = cnn.createStatement();
			String insertSqlString = "Insert into HESONOITHAT(ten, heso, daxoa)" + "values('" + NT.getTenNoiThat() + "','"
					+ NT.getHesoNoiThat() + "','" + this.daXoa + "')";
			statement.executeUpdate(insertSqlString);
			System.out.println("Add Sucessfully");
			String add = "SELECT ID FROM HESONOITHAT WHERE ten = '" + NT.getTenNoiThat() + "' AND heso = " + NT.getHesoNoiThat();
			ResultSet rs = statement.executeQuery(add);
			while (rs.next()) {
				NT.setID(rs.getInt("ID"));
			}
			cnn.commit();
			statement.close();
		} catch (SQLException e) {
			System.out.println("Khong the chen noi that");
		}
    }
    
    public void delNoiThat(NoiThat NT) {
    	try {
			Statement statement = cnn.createStatement();
			String deleteSqlString = "UPDATE HESONOITHAT SET daxoa = 1 WHERE ten = " + "'" + NT.getTenNoiThat() + "'";
			statement.executeUpdate(deleteSqlString);
			System.out.println("Del Sucessfully");
			cnn.commit();
			statement.close();
		} catch (SQLException e) {
			System.out.println("Khong the xoa noi that");
		}
    }
    
    public void editNoiThat(NoiThat NT1, NoiThat NT2) {
    	try {
			Statement statement = cnn.createStatement();
			if (NT1.getdaXoa() == 0) {
				String updateSqlString = "Update HESONOITHAT SET ten =" + "'" + NT2.getTenNoiThat() + "', heso= " + NT2.getHesoNoiThat() +
						" WHERE id = '" + NT1.getID() + "'";
				statement.executeUpdate(updateSqlString);
				cnn.commit();
				System.out.println("Update success");
				statement.close();	
			}
			else {
				System.out.println("Can't update");
			}
		} catch (SQLException e) {
			System.out.println("Khong the sua noi that " + e);
		}
    }
}