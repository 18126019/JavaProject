package src.DTO.heSo.hesoNha;
import java.sql.*;
import java.util.ArrayList;

import src.DAO.heSo.hesoDat.HinhDangDAO;
import src.DAO.heSo.hesoNha.KetCauDAO;
import src.DTO.heSo.hesoDat.HinhDangDTO;
import src.application.java.CnnDB;

public class KetCauDTO
{
	private String tenKetCau;
    private float hesoKetCau;
    private int id = 0;
    private ArrayList<KetCauDTO> DsKetCauDTO = new ArrayList<>();
    //connect database
    CnnDB conn = new CnnDB();
    Connection cnn = conn.getDB();
    
    public KetCauDTO()
    {
        this.hesoKetCau = 0;
        this.tenKetCau = "";
    }

    public KetCauDTO(int id, String tenKetCau, float hesoKetCau) {
        this.tenKetCau = tenKetCau;
        this.hesoKetCau = hesoKetCau;
        this.id = id;
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

    public ArrayList<KetCauDTO> getDsKetCauDTO() {
        return DsKetCauDTO;
    }

    public void setDsKetCauDTO(ArrayList<KetCauDTO> dsKetCauDTO) {
        DsKetCauDTO = dsKetCauDTO;
    }

    public ArrayList<KetCauDTO> danhSachKetCau(KetCauDAO ketCauDAO){
        ResultSet resultSet = ketCauDAO.layKetCau();
        try {
            while (resultSet.next()) {
                KetCauDTO ketCauDTO = new KetCauDTO(resultSet.getInt("id"),
                        resultSet.getString("ten"), resultSet.getFloat("heso"));
                this.getDsKetCauDTO().add(ketCauDTO);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return this.getDsKetCauDTO();
    }

    public void themKetCau(KetCauDAO ketCauDAO, String tenHeSo, Float giatriHeSo) {
        ketCauDAO.addKC(tenHeSo, giatriHeSo);
    }
}
