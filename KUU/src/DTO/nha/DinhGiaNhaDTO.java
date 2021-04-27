package src.DTO.nha;
import java.sql.*;
import src.application.java.CnnDB;
public class DinhGiaNhaDTO extends Nha {
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

    public DinhGiaNhaDTO() {
        super();
        hem = 0;
        matTien = 0;
        hinhDang = 0;
        khuDanCu = 0;
        ketCau = 0;
        tinhTrangNha = 0;
        noiThat = 0;
    }
    public void setHem(float hem) {
		this.hem = hem;
	}
    public void setHesoKhac(float hesoKhac) {
		this.hesoKhac = hesoKhac;
	}
    public void setHinhDang(float hinhDang) {
		this.hinhDang = hinhDang;
	}
    public void setKetCau(float ketCau) {
		this.ketCau = ketCau;
	}
    public void setKhuDanCu(float khuDanCu) {
		this.khuDanCu = khuDanCu;
	}
    public void setMatTien(float matTien) {
		this.matTien = matTien;
	}
    public void setNoiThat(float noiThat) {
		this.noiThat = noiThat;
	}
    public void setTinhTrangNha(float tinhTrangNha) {
		this.tinhTrangNha = tinhTrangNha;
	}
    public float getHem() {
		return hem;
	}
    public float getHesoKhac() {
		return hesoKhac;
	}
    public float getHinhDang() {
		return hinhDang;
	}
    public float getKetCau() {
		return ketCau;
	}
    public float getKhuDanCu() {
		return khuDanCu;
	}
    public float getMatTien() {
		return matTien;
	}
    public float getNoiThat() {
		return noiThat;
	}
    public float getTinhTrangNha() {
		return tinhTrangNha;
	}
}
