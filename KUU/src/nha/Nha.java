package nha;
import heSo.hesoDat.*;
import heSo.hesoNha.*;
import heSo.*;

public class Nha{
	protected String soNha;
	protected String duong;
	protected String phuong;
	protected String quan;
	protected float dienTich;
	protected float soTang;
	protected float giaTien;
	// hinhAnh: kieu du lieu??
	
	public Nha()
	{
		this.soNha = "";
		this.duong = "";
		this.phuong = "";
		this.quan = "";
		this.dienTich = 0;
		this.soTang = 0;
		this.giaTien = 0;
	}
	public Nha(String soNha, String duong, String phuong, String quan, float dienTich, float soTang, float giaTien)
	{
		this.soNha = soNha;
		this.duong = duong;
		this.phuong = phuong;
		this.quan = quan;
		this.dienTich = dienTich;
		this.soTang = soTang;
		this.giaTien = giaTien;
	}
	public Nha(Nha nha)
	{
		this.soNha = nha.soNha;
		this.duong = nha.duong;
		this.phuong = nha.phuong;
		this.quan = nha.quan;
		this.dienTich = nha.dienTich;
		this.soTang = nha.soTang;
		this.giaTien = nha.giaTien;
	}
	
	// public String getSoNha()
	// {
	// 	return this.soNha;
	// }
	// public String getDuong()
	// {
	// 	return this.duong;
	// }
	// public String getPhuong()
	// {
	// 	return this.phuong;
	// }
	// public String qetQuan()
	// {
	// 	return this.quan;
	// }
	// public float getDienTich()
	// {
	// 	return this.dienTich;
	// }
	// public float getSoTang()
	// {
	// 	return this.soTang;
	// }
	// public float getGiaTien()
	// {
	// 	return this.giaTien;
	// }
	// public void setSoNha(String sonha)
	// {
	// 	this.soNha = sonha;	
	// }
	// public void setDuong(String dg)
	// {
	// 	this.duong = dg;
	// }
	// public void setPhuong(String phg)
	// {
	// 	this.phuong = phg;
	// }
	// public void setQuan(String quan)
	// {
	// 	this.quan = quan;
	// }
	// public void setDienTich(float dt)
	// {
	// 	this.dienTich = dt;
	// }
	// public void setSoTang(float tang)
	// {
	// 	this.soTang = tang;
	// }
	// public void setGiaTien(float tien)
	// {
	// 	this.giaTien = tien;
	// }
}