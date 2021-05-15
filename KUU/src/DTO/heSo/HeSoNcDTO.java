package src.DTO.heSo;
import java.sql.*;
import java.util.ArrayList;

import src.DAO.heSo.HeSoNcDAO;
import src.DAO.heSo.hesoNha.KetCauDAO;
import src.DTO.heSo.hesoNha.KetCauDTO;
import src.application.java.CnnDB;

public class HeSoNcDTO {
	private String ten;
    private float heso;
    private int id = 0;
    private ArrayList<HeSoNcDTO> danhsachHeSoNn = new ArrayList<>();
    //connect database
    CnnDB conn = new CnnDB();
    Connection cnn = conn.getDB();

    public HeSoNcDTO(int id, String ten, float heso) {
        this.ten = ten;
        this.heso = heso;
        this.id = id;
    }

    public HeSoNcDTO() {
        this.ten = "";
        this.heso = 0;
    }

    public HeSoNcDTO(String ten, float hs ) {
    	this.ten = ten;
    	this.heso = hs;
    }

    public ArrayList<HeSoNcDTO> getDanhSachHeSoNn() {
        return danhsachHeSoNn;
    }

    public void setDanhSachHeSoNn(ArrayList<HeSoNcDTO> danhSachHeSoNn) {
        this.danhsachHeSoNn = danhSachHeSoNn;
    }

    public float getHeso() {
        return heso;
    }
    
    public String getTen() {
        return this.ten;
    }
    
    public int getID() {
		return this.id;
	}
    
    public void setHeso(float heso) {
        this.heso = heso;
    }
    
    public void setTen(String ten) {
        this.ten = ten;
    }
    
    public void setID(int id) {
		this.id = id;
	}

    public ArrayList<HeSoNcDTO> danhSachHeSoNn(HeSoNcDAO heSoNcDAO){
        ResultSet resultSet = heSoNcDAO.layHeSoNC();
        try {
            while (resultSet.next()) {
                HeSoNcDTO heSoNcDTO = new HeSoNcDTO(resultSet.getInt("id"),
                        resultSet.getString("ten"), resultSet.getFloat("heso"));
                this.getDanhSachHeSoNn().add(heSoNcDTO);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return this.getDanhSachHeSoNn();
    }

    public void themNgoaiCanh(HeSoNcDAO heSoNcDAO, String tenHeSo, Float giatriHeSo) {
        heSoNcDAO.addNC(tenHeSo, giatriHeSo);
    }
}