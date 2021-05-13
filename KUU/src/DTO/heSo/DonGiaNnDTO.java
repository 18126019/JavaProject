package src.DTO.heSo;
import src.DAO.heSo.DonGiaNnDAO;
import src.DAO.heSo.HeSoNcDAO;
import src.application.java.*;
import java.sql.*;
import java.util.ArrayList;

public class DonGiaNnDTO {
	private String duong;
	private String quan;
	private float giaTien;
	private int id = 0;
	private ArrayList<DonGiaNnDTO> danhsachDonGiaNn = new ArrayList<>();
    //connect database
    CnnDB conn = new CnnDB();
    Connection cnn = conn.getDB();

    public DonGiaNnDTO(int id, String duong, String quan, float giaTien) {
        this.duong = duong;
        this.quan = quan;
        this.giaTien = giaTien;
        this.id = id;
    }

    public ArrayList<DonGiaNnDTO> getDanhsachDonGiaNn() {
        return danhsachDonGiaNn;
    }

    public void setDanhsachDonGiaNn(ArrayList<DonGiaNnDTO> danhsachDonGiaNn) {
        this.danhsachDonGiaNn = danhsachDonGiaNn;
    }

    public DonGiaNnDTO() {
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


    public ArrayList<DonGiaNnDTO> danhSachDonGiaNn(DonGiaNnDAO donGiaNnDAO){
        ResultSet resultSet = donGiaNnDAO.layDonGiaNN();
        try {
            while (resultSet.next()) {
                DonGiaNnDTO donGiaNnDTO = new DonGiaNnDTO(resultSet.getInt("id"),
                        resultSet.getString("duong"),
                        resultSet.getString("quan"), resultSet.getFloat("dongia"));
                this.getDanhsachDonGiaNn().add(donGiaNnDTO);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return this.getDanhsachDonGiaNn();
    }
}
