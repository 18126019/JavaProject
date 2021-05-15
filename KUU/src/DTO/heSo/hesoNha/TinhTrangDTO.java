package src.DTO.heSo.hesoNha;
import java.sql.*;
import java.util.ArrayList;

import src.DAO.heSo.hesoDat.HemDAO;
import src.DAO.heSo.hesoNha.TinhTrangDAO;
import src.DTO.heSo.hesoDat.HemDTO;
import src.application.java.CnnDB;
public class TinhTrangDTO
{
	private String tenTinhTrang;
    private float hesoTinhTrang;
    private int id = 0;
    private ArrayList<TinhTrangDTO> danhsachTinhTrang = new ArrayList<>();

    public TinhTrangDTO( int id, String tenTinhTrang, float hesoTinhTrang) {
        this.tenTinhTrang = tenTinhTrang;
        this.hesoTinhTrang = hesoTinhTrang;
        this.id = id;
    }

    public ArrayList<TinhTrangDTO> getDanhsachTinhTrang() {
        return danhsachTinhTrang;
    }

    public void setDanhsachTinhTrang(ArrayList<TinhTrangDTO> danhsachTinhTrang) {
        this.danhsachTinhTrang = danhsachTinhTrang;
    }

    //connect database
    CnnDB conn = new CnnDB();
    Connection cnn = conn.getDB();
    
    public TinhTrangDTO()
    {
        this.hesoTinhTrang = 0;
        this.tenTinhTrang = "";
    }

    public TinhTrangDTO(String ten, float hs) {
    	 
    	this.tenTinhTrang = ten;
    	this.hesoTinhTrang = hs;
    }
    
    public float getHesoTinhTrang() {
        return hesoTinhTrang;
    }
    
    public String getTenTinhTrang() {
        return tenTinhTrang;
    }
    
    public int getID() {
    	return this.id;
    }
    
    public void setHesoTinhTrang(float hesoTinhTrang) {
        this.hesoTinhTrang = hesoTinhTrang;
    }
    
    public void setTenTinhTrang(String tenTinhTrang) {
        this.tenTinhTrang = tenTinhTrang;
    }
    
    public void setID(int id) {
    	this.id = id;
    }

    public ArrayList<TinhTrangDTO> danhSachHem(TinhTrangDAO tinhTrangDAO) {
        ResultSet resultSet = tinhTrangDAO.layTinhTrang();
        try {
            while (resultSet.next()) {
                TinhTrangDTO tinhTrangDTO = new TinhTrangDTO(resultSet.getInt("id"),
                        resultSet.getString("ten"),
                        resultSet.getFloat("heso"));
                this.getDanhsachTinhTrang().add(tinhTrangDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this.getDanhsachTinhTrang();
    }

    public void themTinhTrang(TinhTrangDAO tinhTrangDAO, String tenHeSo, Float giatriHeSo) {
        tinhTrangDAO.addTT(tenHeSo, giatriHeSo);
    }

    public void xoaTinhTrang(TinhTrangDAO tinhTrangDAO, int id) {
        tinhTrangDAO.delTT(id);
    }

    public void updateTen(TinhTrangDAO tinhTrangDAO, String tenTinhTrang, int id) {
        tinhTrangDAO.updateTen(tenTinhTrang, id);
    }

    public void updateHeSo(TinhTrangDAO tinhTrangDAO, Float hesoTinhTrang, int id) {
        tinhTrangDAO.updateHeSo(hesoTinhTrang, id);
    }
}
