package heSo.hesoDat;

public class KhuDanCu
{
	private String tenKhuDanCu;
    private float hesoKhuDanCu;

    public KhuDanCu()
    {
        this.tenKhuDanCu = "";
        this.hesoKhuDanCu = 0;
    }

    public float getHesoKhuDanCu() {
        return hesoKhuDanCu;
    }
    public String getTenKhuDanCu() {
        return tenKhuDanCu;
    }
    public void setHesoKhuDanCu(float hesoKhuDanCu) {
        this.hesoKhuDanCu = hesoKhuDanCu;
    }
    public void setTenKhuDanCu(String tenKhuDanCu) {
        this.tenKhuDanCu = tenKhuDanCu;
    }
}