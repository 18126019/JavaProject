package heSo.hesoDat;

import java.sql.*;

import application.java.CnnDB;

public class Hem
{
	private String tenHem;
    private float hesoHem;
    private int daXoa = 0;
    private int id;
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
    	daXoa = 0;
    }
    public float getHesoHem() {
        return hesoHem;
    }
    public String getTenHem() {
        return tenHem;
    }
    public int getdaXoa()
    {
    	return daXoa;
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
    public void setdaXoa(int daXoa) {
    	this.daXoa = daXoa;
    }
    public void setID(int id) {
    	this.id = id;
    }

    public void addHem(Hem hem)
    {
    	try {
			Statement statement = cnn.createStatement();
			String insertSqlString = "Insert into HESOHEM(ten, heso, daxoa)" + "values('" + hem.getTenHem() + "','"
					+ hem.getHesoHem() + "','" + this.daXoa + "')";
			statement.executeUpdate(insertSqlString);
			System.out.println("Add Sucessfully");
			String add = "SELECT ID FROM HESOHEM WHERE ten = '" + hem.getTenHem() + "' AND heso = " + hem.getHesoHem();
			ResultSet rs = statement.executeQuery(add);
			while (rs.next()) {
				hem.setID(rs.getInt("ID"));
			}
			cnn.commit();
			statement.close();
		} catch (SQLException e) {
			System.out.println("Cannot insert student");
		}
    	
    }
    public void delHem(Hem hem) {
    	try {
			Statement statement = cnn.createStatement();
			String deleteSqlString = "UPDATE HESOHEM SET daxoa = 1 WHERE ten = " + "'" + hem.getTenHem() + "'";
			statement.executeUpdate(deleteSqlString);
			System.out.println("Del Sucessfully");
			cnn.commit();
			statement.close();
		} catch (SQLException e) {
			System.out.println("Cannot delete student");
		}
    }
    public void editHem(Hem hem, Hem hem2) {
    	try {
			Statement statement = cnn.createStatement();
			if (hem.getdaXoa() == 0) {
				String updateSqlString = "Update HESOHEM SET ten =" + "'" + hem2.getTenHem() + "', heso= " + hem2.getHesoHem() +
						" WHERE id = '" + hem.getID() + "'";
				statement.executeUpdate(updateSqlString);
				cnn.commit();
				System.out.println("Update success");
				statement.close();	
			}
			else {
				System.out.println("Can't update");
			}
		} catch (SQLException e) {
			System.out.println("Cannot update hem " + e);
		}
    }
}