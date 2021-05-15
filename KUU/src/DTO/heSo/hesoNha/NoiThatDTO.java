package src.DTO.heSo.hesoNha;
import java.sql.*;
import java.util.ArrayList;

import src.DAO.heSo.hesoDat.HemDAO;
import src.DAO.heSo.hesoNha.NoiThatDAO;
import src.DTO.heSo.hesoDat.HemDTO;
import src.application.java.CnnDB;
public class NoiThatDTO
{
	private String tenNoiThat;
    private float hesoNoiThat;
    private int id = 0;
    private ArrayList<NoiThatDTO> danhSachNoiThat = new ArrayList<>();

    public NoiThatDTO(int id,String tenNoiThat, float hesoNoiThat) {
        this.tenNoiThat = tenNoiThat;
        this.hesoNoiThat = hesoNoiThat;
        this.id = id;
    }

    public ArrayList<NoiThatDTO> getDanhSachNoiThat() {
        return danhSachNoiThat;
    }

    public void setDanhSachNoiThat(ArrayList<NoiThatDTO> danhSachNoiThat) {
        this.danhSachNoiThat = danhSachNoiThat;
    }

    //connect database
    CnnDB conn = new CnnDB();
    Connection cnn = conn.getDB();
    
    public NoiThatDTO()
    {
        this.hesoNoiThat = 0;
        this.tenNoiThat = "";
    }

    public float getHesoNoiThat() {
        return hesoNoiThat;
    }
    public String getTenNoiThat() {
        return tenNoiThat;
    }
    public int getID() {
    	return id;
    }
    public void setHesoNoiThat(float hesoNoiThat) {
        this.hesoNoiThat = hesoNoiThat;
    }
    public void setTenNoiThat(String tenNoiThat) {
        this.tenNoiThat = tenNoiThat;
    }
    public void setID(int id) {
    	this.id = id;
    }

    public ArrayList<NoiThatDTO> danhSachNoiThat(NoiThatDAO noiThatDAO) {
        ResultSet resultSet = noiThatDAO.layNoiThat();
        try {
            while (resultSet.next()) {
                NoiThatDTO noiThatDTO = new NoiThatDTO(resultSet.getInt("id"),
                        resultSet.getString("ten"),
                        resultSet.getFloat("heso"));
                this.getDanhSachNoiThat().add(noiThatDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this.getDanhSachNoiThat();
    }

    public void themNoiThat(NoiThatDAO noiThatDAO, String tenHeSo, Float giatriHeSo) {
        noiThatDAO.addNT(tenHeSo, giatriHeSo);
    }
}