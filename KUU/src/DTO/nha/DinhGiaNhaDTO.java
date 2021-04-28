package src.DTO.nha;
import java.sql.*;
import java.util.ArrayList;

import src.DAO.nha.DangBanNhaDAO;
import src.DAO.nha.DinhGiaNhaDAO;
import src.application.java.CnnDB;
public class DinhGiaNhaDTO extends Nha {
    private ArrayList<DinhGiaNhaDTO> danhsachDinhGiaNha = new ArrayList<>();
    private float hesoHem;
    private float hesoHinhDang;
    private float hesoKhuDanCu;
    private float hesoMatTien;
    private float hesoKetCau;
    private float hesoNoiThat;
    private float hesoTinhTrang;
    private float dongiaNn;
    private float hesoNc;
    //connect database
    CnnDB conn = new CnnDB();
    Connection cnn = conn.getDB();

    public ArrayList<DinhGiaNhaDTO> getDanhsachDinhGiaNha() {
        return danhsachDinhGiaNha;
    }

    public void setDanhsachDinhGiaNha(ArrayList<DinhGiaNhaDTO> danhsachDinhGiaNha) {
        this.danhsachDinhGiaNha = danhsachDinhGiaNha;
    }

    public DinhGiaNhaDTO() {
        super();
    }
    public DinhGiaNhaDTO(int id, String duong, String quan,
                         float hesoHem, float hesoHinhDang, float hesoKhuDanCu,
                         float hesoMatTien, float hesoKetCau, float hesoNoiThat,
                         float hesoTinhTrang, float dongiaNn, float hesoNc,
                         float giatien, float sotang, float dientich) {

        super(id, duong, quan, dientich, sotang, giatien);
        this.hesoHem = hesoHem;
        this.hesoKetCau = hesoKetCau;
        this.hesoHinhDang = hesoHinhDang;
        this.hesoMatTien = hesoMatTien;
        this.hesoKhuDanCu = hesoKhuDanCu;
        this.hesoNoiThat = hesoNoiThat;
        this.hesoTinhTrang = hesoTinhTrang;
        this.dongiaNn = dongiaNn;
        this.hesoNc = hesoNc;
    }

    public ArrayList<DinhGiaNhaDTO> danhSachDinhGiaNha(DinhGiaNhaDAO dinhGiaNhaDAO){
        ResultSet resultSet = dinhGiaNhaDAO.layDinhGiaNha();
        try {
            while (resultSet.next()) {
                DinhGiaNhaDTO dinhGiaNhaDTO = new DinhGiaNhaDTO(
                        resultSet.getInt("id"),
                        resultSet.getString("duong"),
                        resultSet.getString("quan"),
                        resultSet.getFloat("hesohem"),
                        resultSet.getFloat("hesohinhdang"),
                        resultSet.getFloat("hesokhudancu"),
                        resultSet.getFloat("hesomattien"),
                        resultSet.getFloat("hesoketcau"),
                        resultSet.getFloat("hesonoithat"),
                        resultSet.getFloat("hesotinhtrang"),
                        resultSet.getFloat("dongianhanuoc"),
                        resultSet.getFloat("hesongoaicanh"),
                        resultSet.getFloat("giatien"),
                        resultSet.getFloat("sotang"),
                        resultSet.getFloat("dientich"));
                this.getDanhsachDinhGiaNha().add(dinhGiaNhaDTO);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return this.getDanhsachDinhGiaNha();
    }
}
