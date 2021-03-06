package src.DTO.heSo.hesoDat;
import java.sql.*;
import java.util.ArrayList;

import src.DAO.heSo.hesoDat.HemDAO;
import src.application.java.CnnDB;
public class HemDTO {
	private String tenHem;
    private float hesoHem;
    private int id = 0;
    private ArrayList<HemDTO> dsHemDTO = new ArrayList<>();
    //connect database
    CnnDB conn = new CnnDB();
    Connection cnn = conn.getDB();
    public HemDTO()
    {
        id = 0;
        tenHem = "";
        hesoHem = 0;
    }	
    public HemDTO(int id, String ten, float hs) {
        this.id = id;
    	tenHem = ten;
    	hesoHem = hs;
    }

    public ArrayList<HemDTO> getDsHem() {
        return dsHemDTO;
    }

    public void setDsHem(ArrayList<HemDTO> dsHemDTO) {
        this.dsHemDTO = dsHemDTO;
    }

    public float getHesoHem() {
        return hesoHem;
    }
    public String getTenHem() {
        return tenHem;
    }
    public int getID() {
    	return id;
    }
    public void setHesoHem(float hesoHem) {
        this.hesoHem = hesoHem;
    }
    public void setTenHem(String tenHem) {
        this.tenHem = tenHem;
    }
    public void setID(int id) {
    	this.id = id;
    }

    public ArrayList<HemDTO> danhSachHem(HemDAO hemDAO) {
        ResultSet resultSet = hemDAO.layHem();
        try {
            while (resultSet.next()) {
                HemDTO hsHemDTO = new HemDTO(resultSet.getInt("id"),
                                resultSet.getString("ten"),
                                resultSet.getFloat("heso"));
                this.getDsHem().add(hsHemDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this.getDsHem();
    }

    public void updateTen(HemDAO hemDAO, String ten, int id) {
        hemDAO.updateTen(ten, id);
    }

    public void updateHeSo(HemDAO hemDAO, Float heSo, int id) {
        hemDAO.updateHeSo(heSo, id);
    }

    public void xoaHem(HemDAO hemDAO, int id) {
        hemDAO.delHem(id);
    }

    public void themHem(HemDAO hemDAO, String tenHeSo, Float giatriHeSo) {
        hemDAO.addHem(tenHeSo, giatriHeSo);
    }
}