package heSo.hesoNha;
import java.sql.*;
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
    
    public void addTinhTrang(TinhTrang tinhTrang) {
    	try {
			Statement statement = cnn.createStatement();
			String insertSqlString = "Insert into HESOTINHTRANG(ten, heso, daxoa)" + "values('" + tinhTrang.getTenTinhTrang() + "','"
					+ tinhTrang.getHesoTinhTrang() + "','" + this.daXoa + "')";
			statement.executeUpdate(insertSqlString);
			System.out.println("Add Sucessfully");
			String add = "SELECT ID FROM HESOTINHTRANG WHERE ten = '" + tinhTrang.getTenTinhTrang() + "' AND heso = " + tinhTrang.getHesoTinhTrang();
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
    
    public void delTinhTrang(TinhTrang tinhTrang) {
    	try {
			Statement statement = cnn.createStatement();
			String deleteSqlString = "UPDATE HESOTINHTRANG SET daxoa = 1 WHERE ten = " + "'" + tinhTrang.getTenTinhTrang() + "'";
			statement.executeUpdate(deleteSqlString);
			System.out.println("Del Sucessfully");
			cnn.commit();
			statement.close();
		} catch (SQLException e) {
			System.out.println("Cannot delete student");
		}
    }
    
    public void editTinhTrangTinhTrang tinhTrang, TinhTrang tinhTrang2) {
    	try {
			Statement statement = cnn.createStatement();
			if (hem.getdaXoa() == 0) {
				String updateSqlString = "Update HESOHEM SET ten =" + "'" + tinhTrang2.getTenTinhTrang() + "', heso= " + tinhTrang2.getHesoTinhTrang() +
						" WHERE id = '" + tinhTrang.getID() + "'";
				statement.executeUpdate(updateSqlString);
				cnn.commit();
				System.out.println("Update success");
				statement.close();	
			}
			else {
				System.out.println("Can't update");
			}
		} catch (SQLException e) {
			System.out.println("Cannot update tinhTrang " + e);
		}
    }
}
