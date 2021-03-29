package src.nha;
import src.heSo.hesoDat.*;
import src.heSo.hesoNha.*;
import src.heSo.HeSoNC;
import java.sql.*;
import src.application.java.CnnDB;
public class DinhGiaNha extends Nha {
    protected float hem;
    protected float matTien;
    protected float hinhDang;
    protected float khuDanCu;
    protected float ketCau;
    protected float tinhTrangNha;
    protected float noiThat;
    protected float hesoKhac;
    //connect database
    CnnDB conn = new CnnDB();
    Connection cnn = conn.getDB();

    public DinhGiaNha() {
        super();
        hem = 0;
        matTien = 0;
        hinhDang = 0;
        khuDanCu = 0;
        ketCau = 0;
        tinhTrangNha = 0;
        noiThat = 0;
    }
    public float dinhGia() {
        float donGiaNN = 5; //example
        float giaNha = (this.dienTich * this.soTang) * donGiaNN * this.ketCau * this.tinhTrangNha * this.noiThat;
        float giaDat = this.dienTich * this.hem * this.matTien * this.hinhDang * this.khuDanCu;

        return (giaNha + giaDat) * this.hesoKhac;
    }
}
