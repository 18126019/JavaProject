package src.BUS.heSo;
import src.DAO.heSo.DonGiaNnDAO;
import src.DAO.heSo.hesoDat.HinhDangDAO;
import src.DTO.heSo.DonGiaNnDTO;
import src.DTO.heSo.hesoDat.HinhDangDTO;
import src.application.java.*;
import java.sql.*;
import java.util.ArrayList;

public class DonGiaNnBUS {
	private String duong;
	private String quan;
	private float giaTien;
	private int id = 0;
    //connect database
    CnnDB conn = new CnnDB();
    Connection cnn = conn.getDB();

   public DonGiaNnBUS() {
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


	public ArrayList<DonGiaNnDTO> danhsachDonGiaNn() {
		DonGiaNnDAO donGiaNnDAO = new DonGiaNnDAO();
		DonGiaNnDTO donGiaNnDTO = new DonGiaNnDTO();
		ArrayList<DonGiaNnDTO> dsDonGiaNn = donGiaNnDTO.danhSachDonGiaNn(donGiaNnDAO);

		return dsDonGiaNn;
	}
}
