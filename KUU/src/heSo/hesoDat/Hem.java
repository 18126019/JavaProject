package heSo.hesoDat;

public class Hem
{
	private String tenHem;
    private float hesoHem;

    public Hem()
    {
        tenHem = "";
        hesoHem = 0;
    }

    public float getHesoHem() {
        return hesoHem;
    }
    public String getTenHem() {
        return tenHem;
    }
    public void setHesoHem(float hesoHem) {
        this.hesoHem = hesoHem;
    }
    public void setTenHem(String tenHem) {
        this.tenHem = tenHem;
    }
}