package userClass;

public class User {
	private String username;
	private String password;
	private String hoTen;
	private String sdt;
	private String email;
	
	public User()
	{
		this.username = "";
		this.password = "";
		this.hoTen = "";
		this.sdt = "";
		this.email = "";
	}
	
	public User(String user, String pass, String ht, String SDT, String mail)
	{
		this.username = user;
		this.password = pass;
		this.hoTen = ht;
		this.sdt = SDT;
		this.email = mail;
	}
	
	public User(User u)
	{
		this.username = u.username;
		this.password = u.password;
		this.hoTen = u.hoTen;
		this.sdt = u.sdt;
		this.email = this.email;
	}
	public String getUsername() {
		return this.username;
	}
	
	public String getSdt() {
		return this.sdt;
	}
	
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getHoTen() {
		return this.hoTen;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void addNha() {
		
	}
	
	public void editNha() {
		
	}
	
	public void delNha() {
		
	}
	
	public void sortNha() {
		// return ListNha
	}
	
	public void editSdt() {
		
	}
	
	public void editMK()
	{
		
	}
}
