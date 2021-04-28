package src.DTO.nguoiDung;
import java.sql.*;
import java.util.ArrayList;

import src.DAO.nguoiDung.KhachHangDAO;
import src.DAO.nguoiDung.QuanTriDAO;
import src.application.java.CnnDB;

public class QuanTriDTO extends NguoiDung {
	private ArrayList<QuanTriDTO> danhsachQuanTri = new ArrayList<>();

	public ArrayList<QuanTriDTO> getDanhsachQuanTri() {
		return danhsachQuanTri;
	}

	public void setDanhsachQuanTri(ArrayList<QuanTriDTO> danhsachQuanTri) {
		this.danhsachQuanTri = danhsachQuanTri;
	}

	//connect database
    CnnDB conn = new CnnDB();
    Connection cnn = conn.getDB();
	
    public QuanTriDTO() {
		super();
	}
	
	public QuanTriDTO(int id, String ngDung, String mKhau, String ht, String SDT, String mail) {
		super(id, ngDung, mKhau, ht, SDT, mail);
	}

	public QuanTriDTO(QuanTriDTO qTri) {
		super(qTri.id, qTri.tenDangNhap, qTri.matKhau, qTri.hoTen, qTri.sdt, qTri.email);
	}

	public ArrayList<QuanTriDTO> danhSachQuanTri(QuanTriDAO quanTriDAO){
		ResultSet resultSet = quanTriDAO.layQuanTriVien();
		try {
			while (resultSet.next()) {
				QuanTriDTO quanTriDTO = new QuanTriDTO(
						resultSet.getInt("id"),
						resultSet.getString("taikhoan"),
						resultSet.getString("matkhau"),
						resultSet.getString("ten"),
						resultSet.getString("sodienthoai"),
						resultSet.getString("email"));
				this.getDanhsachQuanTri().add(quanTriDTO);
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
		return this.getDanhsachQuanTri();
	}
}
