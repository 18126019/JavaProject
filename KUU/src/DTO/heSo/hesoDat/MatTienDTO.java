package src.DTO.heSo.hesoDat;
import java.sql.*;
import java.util.ArrayList;

import src.DAO.heSo.hesoDat.KhuDanCuDAO;
import src.DAO.heSo.hesoDat.MatTienDAO;
import src.application.java.*;
public class MatTienDTO {
	private String tenMatTien;
    private float hesoMatTien;
    private int id = 0;
    //connect database
    CnnDB conn = new CnnDB();
    Connection cnn = conn.getDB();
    private ArrayList<MatTienDTO> dsMatTienDTO = new ArrayList<>();
    public MatTienDTO(int id, String ten, float heso)
    {
        this.id = id;
        this.tenMatTien =ten;
        this.hesoMatTien = heso;
    }

	public MatTienDTO() {
        this.tenMatTien = "";
        this.hesoMatTien = 0;
	}

    public ArrayList<MatTienDTO> getDsMatTienDTO(){return dsMatTienDTO;}
    public float getHesoMatTien() {
        return hesoMatTien;
    }
    public String getTenMatTien() {
        return tenMatTien;
    }
    public int getId() {
    	return id;
    }
    public void setHesoMatTien(Float hesoMatTien) {
        this.hesoMatTien = hesoMatTien;
    }
    public void setTenMatTien(String tenMatTien) {
        this.tenMatTien = tenMatTien;
    }
    public void setId(int id) {
    	this.id = id;
    }

    public ArrayList<MatTienDTO> danhSachMatTien(MatTienDAO matTienDAO){
        ResultSet resultSet = matTienDAO.layMatTien();
        try {
            while (resultSet.next()) {
                MatTienDTO hsMatTienDTO = new MatTienDTO(resultSet.getInt("id"),
                        resultSet.getString("ten"), resultSet.getFloat("heso"));
                this.getDsMatTienDTO().add(hsMatTienDTO);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return this.getDsMatTienDTO();
    }
}