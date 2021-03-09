package package1;
import java.util.ArrayList;

public class Customer extends User {
	private ArrayList<listNha> listNha;
	
	Customer()
	{
		super();
		this.listNha = new ArrayList<listNha>();
	}

	public ArrayList<listNha> getListNha() {
		return listNha;
	}

	public void setListNha(ArrayList<listNha> listNha) {
		this.listNha = listNha;
	}
}
