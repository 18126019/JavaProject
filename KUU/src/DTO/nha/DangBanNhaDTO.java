package src.DTO.nha;
import java.sql.*;
import java.util.ArrayList;

import src.DAO.nguoiDung.QuanTriDAO;
import src.DAO.nha.DangBanNhaDAO;
import src.DTO.nguoiDung.QuanTriDTO;
import src.application.java.CnnDB;
public class DangBanNhaDTO extends Nha {
    private ArrayList<DangBanNhaDTO> danhsachDangBanNha = new ArrayList<>();
    private int id_khachang;
    private String ghichu;
    private String ketcau;
    public DangBanNhaDTO(int id, int id_khachang, String soNha, String duong, String phuong, String quan, String ketcau, float dienTich, float soTang, float giaTien, String ghichu) {
        super(id, soNha, duong, phuong, quan, dienTich, soTang, giaTien);
        this.id_khachang = id_khachang;
        this.ghichu = ghichu;
        this.ketcau = ketcau;
    }

    public ArrayList<DangBanNhaDTO> getDanhsachDangBanNha() {
        return danhsachDangBanNha;
    }

    public void setDanhsachDangBanNha(ArrayList<DangBanNhaDTO> danhsachDangBanNha) {
        this.danhsachDangBanNha = danhsachDangBanNha;
    }

    //connect database
    CnnDB conn = new CnnDB();
    Connection cnn = conn.getDB();
    public DangBanNhaDTO()
    {
        super();
    }

    public ArrayList<DangBanNhaDTO> danhSachDangBanNha(DangBanNhaDAO dangBanNhaDAO){
        ResultSet resultSet = dangBanNhaDAO.layDangBanNha();
        try {
            while (resultSet.next()) {
                DangBanNhaDTO dangBanNhaDTO = new DangBanNhaDTO(
                        resultSet.getInt("id"),
                        resultSet.getInt("manguoidung"),
                        resultSet.getString("sonha"),
                        resultSet.getString("duong"),
                        resultSet.getString("phuong"),
                        resultSet.getString("quan"),
                        resultSet.getString("ketcau"),
                        resultSet.getFloat("dientich"),
                        resultSet.getFloat("sotang"),
                        resultSet.getFloat("giatien"),
                        resultSet.getString("ghichu"));
                this.getDanhsachDangBanNha().add(dangBanNhaDTO);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return this.getDanhsachDangBanNha();
    }
}
