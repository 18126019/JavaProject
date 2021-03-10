package nhaClass;
import java.util.ArrayList;

public class listNha {
	ArrayList<Nha> listNha;
	
	public listNha()
	{
		this.listNha = new ArrayList<Nha>();
	}
	
	public listNha(ArrayList<Nha> list)
	{
		this.listNha = list;
	}
	public listNha(listNha ln)
	{
		this.listNha = ln.listNha;
	}
	
	public ArrayList<Nha> getlistNha()
	{
		return this.listNha;
	}
	
	public Nha searchNha()
	{
		return listNha.get(1);
	}
	
	public void addNha()
	{
		
	}
	
	public ArrayList<Nha> sortNha()
	{
		return this.listNha;
	}
}
