package src.BUS.nguoiDung;
import src.DAO.heSo.hesoDat.HinhDangDAO;
import src.DAO.nguoiDung.QuanTriDAO;
import src.DTO.heSo.hesoDat.HinhDangDTO;
import src.DTO.nguoiDung.QuanTriDTO;
import src.application.java.CnnDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
public class QuanTriBUS extends NguoiDung {
	//connect database
	CnnDB conn = new CnnDB();
	Connection cnn = conn.getDB();

	public QuanTriBUS() {
		super();
	}

	public QuanTriBUS(int id, String ngDung, String mKhau, String ht, String SDT, String mail) {
		super(id, ngDung, mKhau, ht, SDT, mail);

	}

	public QuanTriBUS(QuanTriBUS qTri) {
		super(qTri.id, qTri.tenDangNhap, qTri.matKhau, qTri.hoTen, qTri.sdt, qTri.email);
	}

	public ArrayList<QuanTriDTO> danhSachQuanTri() {
		QuanTriDAO quanTriDAO = new QuanTriDAO();
		QuanTriDTO quanTriDTO = new QuanTriDTO();
		ArrayList<QuanTriDTO> dsQuanTri = quanTriDTO.danhSachQuanTri(quanTriDAO);

		return dsQuanTri;
	}
}
