package src.BUS.heSo.hesoNha;
import java.sql.*;
import java.util.ArrayList;

import src.DAO.heSo.hesoDat.HemDAO;
import src.DAO.heSo.hesoNha.KetCauDAO;
import src.DTO.heSo.hesoDat.HemDTO;
import src.DTO.heSo.hesoNha.KetCauDTO;
import src.application.java.CnnDB;

public class KetCauBUS
{
	private String tenKetCau;
    private float hesoKetCau;
    private int id = 0;
    //connect database
    CnnDB conn = new CnnDB();
    Connection cnn = conn.getDB();
    
    public KetCauBUS()
    {
        this.hesoKetCau = 0;
        this.tenKetCau = "";
    }

    public float getHesoKetCau() {
        return hesoKetCau;
    }
    public String getTenKetCau() {
        return tenKetCau;
    }
    public int getID() {
		return id;
	}
    public void setHesoKetCau(float hesoKetCau) {
        this.hesoKetCau = hesoKetCau;
    }
    public void setTenKetCau(String tenKetCau) {
        this.tenKetCau = tenKetCau;
    }
    public void setID(int id) {
		this.id = id;
	}

	public ArrayList<KetCauDTO> danhsachKetCau() {
		KetCauDAO ketCauDAO = new KetCauDAO();
		KetCauDTO ketCauDTO = new KetCauDTO();
		ArrayList<KetCauDTO> dsKetCau = ketCauDTO.danhSachKetCau(ketCauDAO);

		return dsKetCau;
	}
}
