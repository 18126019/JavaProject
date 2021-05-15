package src.DTO.heSo.hesoDat;
import java.sql.*;
import java.util.ArrayList;

import src.DAO.heSo.hesoDat.HinhDangDAO;
import src.DAO.heSo.hesoDat.KhuDanCuDAO;
import src.application.java.*;
public class KhuDanCuDTO {
	private String tenKhuDanCu;
    private float hesoKhuDanCu;
    private int id = 0;
    private ArrayList<KhuDanCuDTO> dsKhuDanCuDTO = new ArrayList<>();
    //connect database
    CnnDB conn = new CnnDB();
    Connection cnn = conn.getDB();
    
    public KhuDanCuDTO(int id, String ten, float heso)
    {
        this.id = id;
        this.tenKhuDanCu = ten;
        this.hesoKhuDanCu = heso;
    }

	public KhuDanCuDTO() {
        this.tenKhuDanCu = "";
        this.hesoKhuDanCu = 0;
	}

    public ArrayList<KhuDanCuDTO> getDsKhuDanCuDTO(){return dsKhuDanCuDTO;}
    public float getHesoKhuDanCu() {
        return hesoKhuDanCu;
    }
    public String getTenKhuDanCu() {
        return tenKhuDanCu;
    }
    public int getId() {
    	return id;
    }
    public void setHesoKhuDanCu(float hesoKhuDanCu) {
        this.hesoKhuDanCu = hesoKhuDanCu;
    }
    public void setTenKhuDanCu(String tenKhuDanCu) {
        this.tenKhuDanCu = tenKhuDanCu;
    }
    public void setId(int id) {
    	this.id = id;
    }

    public ArrayList<KhuDanCuDTO> danhSachKhuDanCu(KhuDanCuDAO khuDanCuDAO){
        ResultSet resultSet = khuDanCuDAO.layKhuDanCu();
        try {
            while (resultSet.next()) {
                KhuDanCuDTO hsKhuDanCuDTO = new KhuDanCuDTO(resultSet.getInt("id"),
                        resultSet.getString("ten"), resultSet.getFloat("heso"));
                this.getDsKhuDanCuDTO().add(hsKhuDanCuDTO);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return this.getDsKhuDanCuDTO();
    }

    public void xoaKhuDanCu(KhuDanCuDAO khuDanCuDAO, int id) {
        khuDanCuDAO.delKhuDanCu(id);
    }

    public void themKDC(KhuDanCuDAO khuDanCuDAO, String tenHeSo, Float giatriHeSo) {
        khuDanCuDAO.addKhuDanCu(tenHeSo, giatriHeSo);
    }
    public void updateTen(KhuDanCuDAO khuDanCuDAO, String ten, int id) {
        khuDanCuDAO.updateTen(ten, id);
    }
    public void updateHeSo(KhuDanCuDAO khuDanCuDAO, Float heSo, int id) {
        khuDanCuDAO.updateHeSo(heSo, id);
    }
}