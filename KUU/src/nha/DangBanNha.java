package nha;
import java.sql.*;
public class DangBanNha extends Nha {
	protected int maNguoiDung;
    protected String ketCau;
    protected String hem;
    protected String matTien;
    protected String ghiChu;
    private int id = 0;
    //connect database
    CnnDB conn = new CnnDB();
    Connection cnn = conn.getDB();
    public DangBanNha()
    {
        super();
        maNguoiDung = 0;
        ketCau = "";
        hem = "";
        matTien = "";
        ghiChu = "";
    }
    public String getGhiChu() {
        return ghiChu;
    }
    public String getHem() {
        return hem;
    }
    public String getKetCau() {
        return ketCau;
    }
    public String getMatTien() {
        return matTien;
    }
    public int getID() {
    	return id;
    }
    public int getMaNguoiDung()
    {
    	return this.maNguoiDung;
    }
    
    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
    public void setHem(String hem) {
        this.hem = hem;
    }
    public void setKetCau(String ketCau) {
        this.ketCau = ketCau ;
    }
    public void setMatTien(String matTien) {
        this.matTien = matTien;
    }
    public void setMaNguoiDung(int MaNguoiDung)
    {
    	this.maNguoiDung = MaNguoiDung;
    }
    public void setID(int id) {
    	this.id = id;
    }
    
    public void themDangBanNha(DangBanNha dbn)
    {
    	/*try {
			Statement statement = cnn.createStatement();
			String insertSqlString = "Insert into NHADANGBAN(manguoidung, sotang, dientich, ketcau, giatien,sonha, duong, phuong, quan, ghichu, daxoa)" 
			+ "values(" 
			+ dbn.getMaNguoiDung() + ",'"
			+ dbn.getSoTang() + "','" + this.daXoa + "')";
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
		}*/
    }
    
  
}
