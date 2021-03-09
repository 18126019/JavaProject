package nhaClass;

public class Nha{
	String soNha;
	String duong;
	String phuong;
	String quan;
	float dienTich;
	float soTang;
	String ketCau; // loai nha ( nha cap 1, 2, 3, 4)
	float chieuRongHem;
	float giaTien;
	// hinhAnh: kieu du lieu??
	
	public Nha()
	{
		this.soNha = null;
		this.duong = null;
		this.phuong = null;
		this.quan = null;
		this.dienTich = 0;
		this.soTang = 0;
		this.ketCau = null;
		this.chieuRongHem = 0;
		this.giaTien = 0;
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
	
	public String qetQuan()
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
	
	public String getKetCau()
	{
		return this.ketCau;
	}
	
	public float getChieuRongHem()
	{
		return this.chieuRongHem;
	}
	
	public float getGiaTien()
	{
		return this.giaTien;
	}
	
	public void setSoNha(String sonha)
	{
		this.soNha = sonha;
		
	}
	
	public void setDuong(String dg)
	{
		this.duong = dg;
	}
	
	public void setPhuong(String phg)
	{
		this.phuong = phg;
	}
	
	public void setQuan(String quan)
	{
		this.quan = quan;
	}
	
	public void setDienTich(float dt)
	{
		this.dienTich = dt;
	}
	
	public void setSoTang(float tang)
	{
		this.soTang = tang;
	}
	
	public void setKetCau(String kcau)
	{
		this.ketCau = kcau;
	}
	
	public void setChieuRongHem(float crHem)
	{
		this.chieuRongHem = crHem;
	}
	
	public void setGiaTien(float tien)
	{
		this.giaTien = tien;
	}
	
	public float evaluate() 
	{
		float gia = 0;
		// doi them cong thuc tinh gia nha
		return gia;
	}
	
	public void checkInfo()
	{
			
	}
	
	public void editNha()
	{
		
	}
}