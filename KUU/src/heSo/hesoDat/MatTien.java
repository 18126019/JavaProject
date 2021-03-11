package heSo.hesoDat;

public class MatTien
{
	private String tenMatTien;
    private float hesoMatTien;

    public MatTien()
    {
        this.tenMatTien = "";
        this.hesoMatTien = 0;
    }

    public float getHesoMatTien() {
        return hesoMatTien;
    }
    public String getTenMatTien() {
        return tenMatTien;
    }
    public void setHesoMatTien(Float hesoMatTien) {
        this.hesoMatTien = hesoMatTien;
    }
    public void setTenMatTien(String tenMatTien) {
        this.tenMatTien = tenMatTien;
    }
}