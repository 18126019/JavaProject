package src.BUS.nha;
import java.sql.*;
import java.util.ArrayList;

import src.DAO.nha.DangBanNhaDAO;
import src.DAO.nha.DinhGiaNhaDAO;
import src.DTO.nha.DangBanNhaDTO;
import src.DTO.nha.DinhGiaNhaDTO;
import src.application.java.CnnDB;
public class DinhGiaNhaBUS extends Nha {
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


    public DinhGiaNhaBUS(int id, String duong, String quan,
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

    public ArrayList<DinhGiaNhaDTO> danhSachDinhGiaNha() {
        DinhGiaNhaDAO dinhGiaNhaDAO = new DinhGiaNhaDAO();
        DinhGiaNhaDTO dinhGiaNhaDTO = new DinhGiaNhaDTO();
        ArrayList<DinhGiaNhaDTO> dsDinhGiaNha = dinhGiaNhaDTO.danhSachDinhGiaNha(dinhGiaNhaDAO);

        return dsDinhGiaNha;
    }
}
