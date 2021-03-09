package userClass;
import java.util.ArrayList;

public class Admin extends User {
	private ArrayList<User> listCustomer;
	
	public void addUser(User u) {
		
	}
	
	public void editUser() {
		
	}
	
	public void delUser() {
		
	}
	public ArrayList<User> getListCustomer()
	{
		return this.listCustomer;
	}
	
	public void setlistCustomer(ArrayList<User> listCus)
	{
		this.listCustomer = listCus;
	}
	public User searchUser() {
		return listCustomer.get(1);
	}
	
	public ArrayList<User> sortUser()	
	{
		return listCustomer;
	}
}
