package src.DTO.heSo;
import src.application.java.*;
import java.sql.*;
public class DonGiaNnDTO {
	private String duong;
	private String quan;
	private float giaTien;
	private int id = 0;
    //connect database
    CnnDB conn = new CnnDB();
    Connection cnn = conn.getDB();

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
}
