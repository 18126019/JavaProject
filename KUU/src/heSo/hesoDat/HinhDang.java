package heSo.hesoDat;

public class HinhDang
{
	private String tenHinhDang;
    private float hesoHinhDang;

    public HinhDang()
    {
        this.tenHinhDang = "";
        this.hesoHinhDang = 0;
    }

    public float getHesoHinhDang() {
        return hesoHinhDang;
    }
    public String getTenHinhDang() {
        return tenHinhDang;
    }
    public void setHesoHinhDang(float hesoHinhDang) {
        this.hesoHinhDang = hesoHinhDang;
    }
    public void setTenHinhDang(String tenHinhDang) {
        this.tenHinhDang = tenHinhDang;
    }
}