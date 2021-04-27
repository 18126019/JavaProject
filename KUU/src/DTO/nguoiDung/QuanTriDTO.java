package src.DTO.nguoiDung;
import java.sql.*;
import java.util.ArrayList;
import src.application.java.CnnDB;

public class QuanTriDTO extends NguoiDung {
	protected ArrayList<KhachHangDTO> dsKhachHangDTO;
    //connect database
    CnnDB conn = new CnnDB();
    Connection cnn = conn.getDB();
	
    public QuanTriDTO() {
		super();
		dsKhachHangDTO = new ArrayList<>();
	}
	
	public QuanTriDTO(String ngDung, String mKhau, String ht, String SDT, String mail, ArrayList<KhachHangDTO> dsKhachHangDTO) {
		super(ngDung, mKhau, ht, SDT, mail);
		this.dsKhachHangDTO = dsKhachHangDTO;
	}
	
	public QuanTriDTO(QuanTriDTO qTri) {
		super(qTri.tenDangNhap, qTri.matKhau, qTri.hoTen, qTri.sdt, qTri.email);
		dsKhachHangDTO = qTri.dsKhachHangDTO;
	}

	public ArrayList<KhachHangDTO> getDsKhachHang() {
		return this.dsKhachHangDTO;
	}
	public void setDsKhachHang(ArrayList<KhachHangDTO> dsKhachHangDTO) {
		this.dsKhachHangDTO = dsKhachHangDTO;
	}
}
