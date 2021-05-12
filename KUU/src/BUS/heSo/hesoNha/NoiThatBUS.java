package src.BUS.heSo.hesoNha;
import java.sql.*;
import java.util.ArrayList;

import src.DAO.heSo.hesoDat.HemDAO;
import src.DAO.heSo.hesoNha.NoiThatDAO;
import src.DTO.heSo.hesoDat.HemDTO;
import src.DTO.heSo.hesoNha.NoiThatDTO;
import src.application.java.CnnDB;
public class NoiThatBUS
{
	private String tenNoiThat;
    private float hesoNoiThat;
    private int id = 0;
    //connect database
    CnnDB conn = new CnnDB();
    Connection cnn = conn.getDB();
    
    public NoiThatBUS()
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

	public ArrayList<NoiThatDTO> danhsachNoiThat() {
		NoiThatDAO noiThatDAO = new NoiThatDAO();
		NoiThatDTO noiThatDTO = new NoiThatDTO();
		ArrayList<NoiThatDTO> dsNoiThat = noiThatDTO.danhSachNoiThat(noiThatDAO);

		return dsNoiThat;
	}
}