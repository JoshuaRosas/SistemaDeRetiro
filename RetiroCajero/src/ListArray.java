import java.util.Arrays;

public class ListArray <T> implements TDAList <T>{
	private T []list;
	private int count;
	
	public ListArray(int x) {
		this.list = (T[]) new Object [x];
		this.count = 0;
	}
	@Override
	public boolean isEmptyList() {
		return(this.count==0);
	}
	@Override
	public int length() {
		return this.count;
	}
	@Override
	public void destroyList() {
		this.count=0;
		
	}
	@Override
	public int search(T x) {
		for(int i = 0;i<this.length();i++)
			if(this.list[i].equals(x))
				return i;
		return -1;
	}
	@Override
	public void insertFirst(T x) {
		if(this.isFull())
			System.out.println("La lista esta llena");
		else
			for (int i = this.length()-1;i>=0;i--)
				this.list[i+1]=this.list[i];
			this.list[0]=x;
			this.count++;
		
	}
	@Override
	public void insertLastT(T x) {
		if(this.isFull())
			System.out.println("La lista esta llena");
		else
			this.list[this.count++]=x;
	}
	@Override
	public void remove(T x) {
		int pos = this.search(x);
		if (pos!= -1) {
			for (int i = pos; i<this.length(); i++)
				this.list[i] = this.list[i+1];
			this.count--;
		}	
		else
			System.out.println("No se encontro el elemento");
		
	}
	
	public boolean isFull() {
		return(this.count==this.list.length);
	}
	
	@Override
	public String toString() {
		String st ="";
		for(int i=0;i<this.length();i++)
			st += "\n"+this.list[i]+"\n";
		return st;
	}
	
	public boolean serchlog(T x) {
		for(int i = 0;i<this.length();i++)
			if(this.list[i].equals(x)) {
				System.out.println("Ingreso un codigo repetido, Vuelva a ingresar los datos nuevamente...");
				return true;
			}
		return false;
	}
	
	
	
	

}
