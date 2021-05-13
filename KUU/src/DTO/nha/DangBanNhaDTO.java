package src.DTO.nha;
import src.DAO.nha.DangBanNhaDAO;
import src.application.java.CnnDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class DangBanNhaDTO extends Nha {
    private ArrayList<DangBanNhaDTO> danhsachDangBanNha = new ArrayList<>();
    private int id_khachang;
    private String ghichu;
    private String ketcau;
    private String imgUrl;

    public DangBanNhaDTO(int id, int id_khachang, String soNha, String duong, String phuong, String quan, String ketcau, float dienTich, float soTang, float giaTien, String ghichu, String imgUrl, int daxoa) {
        super(id, soNha, duong, phuong, quan, dienTich, soTang, giaTien, daxoa);
        this.id_khachang = id_khachang;
        this.ghichu = ghichu;
        this.ketcau = ketcau;
        this.imgUrl = imgUrl;
    }

    public ArrayList<DangBanNhaDTO> getDanhsachDangBanNha() {
        return danhsachDangBanNha;
    }

    public int getId() {
        return super.id;
    }
    public int getId_khachang() {
        return id_khachang;
    }

    public void setId_khachang(int id_khachang) {
        this.id_khachang = id_khachang;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public String getKetcau() {
        return ketcau;
    }

    public void setKetcau(String ketcau) {
        this.ketcau = ketcau;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
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
                        resultSet.getString("ghichu"),
                        resultSet.getString("imgurl"),
                        resultSet.getInt("daxoa"));
                this.getDanhsachDangBanNha().add(dangBanNhaDTO);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return this.getDanhsachDangBanNha();
    }

    public void updateSoNha(DangBanNhaDAO dangBanNhaDAO, String soNha, int id) {
        dangBanNhaDAO.update(soNha, id);
    }
}
