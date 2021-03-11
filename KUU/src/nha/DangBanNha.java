package nha;

public class DangBanNha extends Nha {
    protected String ketCau;
    protected String hem;
    protected String matTien;
    protected String ghiChu;

    public DangBanNha()
    {
        super();
        ketCau = "";
        hem = "";
        matTien = "";
        ghiChu = "";
    }
    public String getGhiChu() {
        return ghiChu;
    }
    public String getHem() {
        return hem;
    }
    public String getKetCau() {
        return ketCau;
    }
    public String getMatTien() {
        return matTien;
    }
    public void suaNha()
    {
        //
    }
}
