package heSo.hesoNha;

public class NoiThat
{
	private String tenNoiThat;
    private float hesoNoiThat;

    public NoiThat()
    {
        this.hesoNoiThat = 0;
        this.tenNoiThat = "";
    }

    public float getHesoNoiThat() {
        return hesoNoiThat;
    }
    public String getTenNoiThat() {
        return tenNoiThat;
    }
    public void setHesoNoiThat(float hesoNoiThat) {
        this.hesoNoiThat = hesoNoiThat;
    }
    public void setTenNoiThat(String tenNoiThat) {
        this.tenNoiThat = tenNoiThat;
    }
}