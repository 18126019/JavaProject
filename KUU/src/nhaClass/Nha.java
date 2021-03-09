package nhaClass;

public class Nha{
	private String soNha;
	private String duong;
	private String phuong;
	private String quan;
	private float dienTich;
	private float soTang;
	private String ketCau; // loai nha ( nha cap 1, 2, 3, 4)
	private float chieuRongHem;
	private float giaTien;
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
	public Nha(String soNha, String duong, String phuong, String quan, float dienTich, float soTang, String ketCau, float chieuRongHem, float giaTien)
	{
		this.soNha = soNha;
		this.duong = duong;
		this.phuong = phuong;
		this.quan = quan;
		this.dienTich = dienTich;
		this.soTang = soTang;
		this.ketCau = ketCau;
		this.chieuRongHem = chieuRongHem;
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
		this.ketCau = nha.ketCau;
		this.chieuRongHem = nha.chieuRongHem;
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
		float giaDat = 0;
		float donGiaNN = 1 // example 
		float HSD = 1; // example (co the co nhieu HSD - tuy thuoc vao hinh dang va vi tri cua nha)
		giaDat = this.dienTich * donGiaNN * HSD;
		
		float giaNha = 0;
		float dienTichSan = this.dienTich * this.soTang;
		float giaXayDung = 1 // example
		float HSN = 1; // example (co the co nhieu HSN - tuy thuoc vao ket cau nha, muc do vat lieu hoan thien, muc do nha cu moi )
		giaNha = dienTichSan * giaXayDung * HSN;
		
		return giaDat + giaNha;
	}
	
	public void checkInfo()
	{
			
	}
	
	public void editNha()
	{
		
	}
}