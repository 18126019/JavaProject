package heSo;

public class hesoKhac 
{
	private String tenHesoKhac;
    private float heso;

    public hesoKhac()
    {
        this.tenHesoKhac = "";
        this.heso = 0;
    }

    public float getHeso() {
        return heso;
    }
    public String getTenHesoKhac() {
        return tenHesoKhac;
    }
    public void setHeso(float heso) {
        this.heso = heso;
    }
    public void setTenHesoKhac(String tenHesoKhac) {
        this.tenHesoKhac = tenHesoKhac;
    }
}