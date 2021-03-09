package userClass;
import java.util.ArrayList;

public class Admin extends User {
	private ArrayList<Customer> listCustomer;
	
	Admin()
	{
		super();
		listCustomer = new ArrayList<>();
	}
	
	Admin(String user, String pass, String ht, String SDT, String mail, ArrayList<Customer> cusList)
	{
		super(user, pass, ht, SDT, mail)
		listCustomer = cusList;
	}
	
	Admin(Admin ad)
	{
		super(ad.username, ad.password, ad.hoTen, ad.sdt, ad.email);
		listCustomer = ad.listCustomer;
	}
	public void addCustomer(Customer Cus) {
		
	}
	
	public void editCustomer() {
		
	}
	
	public void delCustomer() {
		
	}
	public ArrayList<Customer> getListCustomer()
	{
		return this.listCustomer;
	}
	
	public void setlistCustomer(ArrayList<Customer> listCus)
	{
		this.listCustomer = listCus;
	}
	public User searchCustomer() {
		return listCustomer.get(1);
	}
	
	public ArrayList<Customer> sortCustomer()	
	{
		return listCustomer;
	}
}
