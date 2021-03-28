package heSo.hesoNha;
import java.sql.*;

public class KetCau
{
	private String tenKetCau;
    private float hesoKetCau;
    private int id = 0;
    //connect database
    CnnDB conn = new CnnDB();
    Connection cnn = conn.getDB();
    
    public KetCau()
    {
        this.hesoKetCau = 0;
        this.tenKetCau = "";
    }

    public float getHesoKetCau() {
        return hesoKetCau;
    }
    public String getTenKetCau() {
        return tenKetCau;
    }
    public void setHesoKetCau(float hesoKetCau) {
        this.hesoKetCau = hesoKetCau;
    }
    public void setTenKetCau(String tenKetCau) {
        this.tenKetCau = tenKetCau;
    }

    public void addKetCau(KetCau kc)
    {
    	try {
			Statement statement = cnn.createStatement();
			String insertSqlString = "Insert into HESOKETCAU(ten, heso, daxoa)" + "values('" + kc.getTenKetCau() + "','"
					+ kc.getHesoKetCau() + "','" + this.daXoa + "')";
			statement.executeUpdate(insertSqlString);
			System.out.println("Add Sucessfully");
			String add = "SELECT ID FROM HESOKETCAU WHERE ten = '" + kc.getTenKetCau() + "' AND heso = " + kc.getHesoKetCau();
			ResultSet rs = statement.executeQuery(add);
			while (rs.next()) {
				kc.setID(rs.getInt("ID"));
			}
			cnn.commit();
			statement.close();
		} catch (SQLException e) {
			System.out.println("Khong the chen ket cau");
		}
    }
    
    public void delKetCau(KetCau kc) {
    	try {
			Statement statement = cnn.createStatement();
			String deleteSqlString = "UPDATE HESOKETCAU SET daxoa = 1 WHERE ten = " + "'" + kc.getTenKetCau() + "'";
			statement.executeUpdate(deleteSqlString);
			System.out.println("Del Sucessfully");
			cnn.commit();
			statement.close();
		} catch (SQLException e) {
			System.out.println("Khong the xoa ket cau");
		}
    }
    
    public void editKetCau(KetCau KC1, KetCau KC2) {
    	try {
			Statement statement = cnn.createStatement();
			if (KC1.getdaXoa() == 0) {
				String updateSqlString = "Update HESOKETCAU SET ten =" + "'" + KC2.getTenKetCau() + "', heso= " + KC2.getHesoKetCau() +
						" WHERE id = '" + KC1.getID() + "'";
				statement.executeUpdate(updateSqlString);
				cnn.commit();
				System.out.println("Update success");
				statement.close();	
			}
			else {
				System.out.println("Can't update");
			}
		} catch (SQLException e) {
			System.out.println("Khong the cap nhap ket cau " + e);
		}
    }
}
