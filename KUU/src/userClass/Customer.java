package userClass;
import java.util.ArrayList;

import nhaClass.listNha;

public class Customer extends User {
	private ArrayList<listNha> listNha;
	
	Customer()
	{
		super();
		this.listNha = new ArrayList<listNha>();
	}
	Customer(String user, String pass, String ht, String SDT, String mail, ArrayList<listNha> ln)
	{
		super(user, pass, ht, SDT, mail);
		this.listNha = ln;
	}
	Customer(Customer cus)
	{
		super(cus.username, cus.password, cus.hoTen, cus.sdt, cus.email);
		this.listNha = cus.listNha;
	}

	public ArrayList<listNha> getListNha() {
		return listNha;
	}

	public void setListNha(ArrayList<listNha> listNha) {
		this.listNha = listNha;
	}
}
