package src.DTO.heSo.hesoDat;
import java.sql.*;
import java.util.ArrayList;

import src.DAO.heSo.hesoDat.HemDAO;
import src.DAO.heSo.hesoDat.HinhDangDAO;
import src.application.java.*;
public class HinhDangDTO {
	private String tenHinhDang;
    private float hesoHinhDang;
    private int id = 0;
	private ArrayList<HinhDangDTO> dsHinhDangDTO = new ArrayList<>();
    //connect database
    CnnDB conn = new CnnDB();
    Connection cnn = conn.getDB();
    
    public HinhDangDTO(int id, String ten, float heso)
    {
    	this.id = id;
        this.tenHinhDang = ten;
        this.hesoHinhDang = heso;
    }

	public HinhDangDTO() {
		this.tenHinhDang = "";
		this.hesoHinhDang = 0;
	}

	public ArrayList<HinhDangDTO> getDsHinhDangDTO(){return dsHinhDangDTO;}
	public int getId() {
		return id;
	}
    public float getHesoHinhDang() {
        return hesoHinhDang;
    }
    public String getTenHinhDang() {
        return tenHinhDang;
    }
	public void setHesoHinhDang(float hesoHinhDang) {
		this.hesoHinhDang = hesoHinhDang;
	}
	public void setTenHinhDang(String tenHinhDang) {
		this.tenHinhDang = tenHinhDang;
	}
	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<HinhDangDTO> danhSachHinhDang(HinhDangDAO hinhDangDAO){
    	ResultSet resultSet = hinhDangDAO.layHinhDang();
    	try {
    		while (resultSet.next()) {
			    HinhDangDTO hsHinhDangDTO = new HinhDangDTO(resultSet.getInt("id"),
					    resultSet.getString("ten"), resultSet.getFloat("heso"));
			    this.getDsHinhDangDTO().add(hsHinhDangDTO);
		    }
	    }catch (SQLException e){
    		e.printStackTrace();
	    }
    	return this.getDsHinhDangDTO();
	}

    public void xoaHinhDang(HinhDangDAO hinhDangDAO, int id) {
    	hinhDangDAO.delHinhDang(id);
    }

    public void themHinhDang(HinhDangDAO hinhDangDAO, String tenHeSo, Float giatriHeSo) {
    	hinhDangDAO.addHinhDang(tenHeSo, giatriHeSo);
    }
	public void updateTen(HinhDangDAO hinhDangDAO, String ten, int id) {
		hinhDangDAO.updateTen(ten, id);
	}
	public void updateHeSo(HinhDangDAO hinhDangDAO, Float heSo, int id) {
		hinhDangDAO.updateHeSo(heSo, id);
	}
}