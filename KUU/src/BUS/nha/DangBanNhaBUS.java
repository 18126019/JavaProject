package src.BUS.nha;
import src.DAO.nha.DangBanNhaDAO;
import src.DTO.nha.DangBanNhaDTO;

import java.util.ArrayList;
public class DangBanNhaBUS extends Nha {
    private int id_khachang;
    private String ghichu;
    private String ketcau;
    public DangBanNhaBUS(int id, int id_khachang, String soNha, String duong, String phuong, String quan, String ketcau, float dienTich, float soTang, float giaTien, String ghichu) {
        super(id, soNha, duong, phuong, quan, dienTich, soTang, giaTien);
        this.id_khachang = id_khachang;
        this.ghichu = ghichu;
        this.ketcau = ketcau;
    }

    public DangBanNhaBUS() {

    }

    public ArrayList<DangBanNhaDTO> danhSachDangBanNha() {
        DangBanNhaDAO dangBanNhaDAO = new DangBanNhaDAO();
        DangBanNhaDTO dangBanNhaDTO = new DangBanNhaDTO();
        ArrayList<DangBanNhaDTO> dsDangBanNha = dangBanNhaDTO.danhSachDangBanNha(dangBanNhaDAO);

        return dsDangBanNha;
    }

}
