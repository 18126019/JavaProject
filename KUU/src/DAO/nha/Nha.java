package src.DAO.nha;
import src.DAO.heSo.hesoDat.*;
import src.DAO.heSo.hesoNha.*;
import src.DAO.heSo.*;

public class Nha{
	protected String soNha;
	protected String duong;
	protected String phuong;
	protected String quan;
	protected float dienTich;
	protected float soTang;
	protected float giaTien;
	protected int id = 0;
	protected int daXoa = 0;
	// hinhAnh: kieu du lieu??
	
	public Nha() {
		this.soNha = "";
		this.duong = "";
		this.phuong = "";
		this.quan = "";
		this.dienTich = 0;
		this.soTang = 0;
		this.giaTien = 0;
	}
	public Nha(String soNha, String duong, String phuong, String quan, float dienTich, float soTang, float giaTien) {
		this.soNha = soNha;
		this.duong = duong;
		this.phuong = phuong;
		this.quan = quan;
		this.dienTich = dienTich;
		this.soTang = soTang;
		this.giaTien = giaTien;
	}
	public Nha(Nha nha)	{
		this.soNha = nha.soNha;
		this.duong = nha.duong;
		this.phuong = nha.phuong;
		this.quan = nha.quan;
		this.dienTich = nha.dienTich;
		this.soTang = nha.soTang;
		this.giaTien = nha.giaTien;
	}
	
	public String getSoNha()
	{
		return this.soNha;
	}
	public String getDuong()
	{
		return this.duong;
	}
	public String getPhuong()
	{
		return this.phuong;
	}
	public String getQuan()
	{
		return this.quan;
	}
	public float getDienTich()
	{
		return this.dienTich;
	}
	public float getSoTang()
	{
		return this.soTang;
	}
	public float getGiaTien()
	{
		return this.giaTien;
	}
	public int getDaXoa() {
		return daXoa;
	}
	public void setSoNha(String soNha)
	{
		this.soNha = soNha;
	}
	public void setDuong(String duong)
	{
		this.duong = duong;
	}
	public void setPhuong(String phuong)
	{
		this.phuong = phuong;
	}
	public void setQuan(String quan)
	{
		this.quan = quan;
	}
	public void setDienTich(float dienTich)
	{
		this.dienTich = dienTich;
	}
	public void setSoTang(float soTang)
	{
		this.soTang = soTang;
	}
	public void setGiaTien(float giaTien)
	{
		this.giaTien = giaTien;
	}
	public void setDaXoa(int daXoa) {
		this.daXoa = daXoa;
	}
}