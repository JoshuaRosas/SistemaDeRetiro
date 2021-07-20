import java.util.ArrayList;
import java.util.Arrays;
public class ListLinked <T extends Comparable<T>> implements TDAList <T> {
	private Node <T> first;
	private int count;
	
	public ListLinked() {
		super();
		this.first = null;
		this.count = 0;
	}

	@Override
	public boolean isEmptyList() {
		return this.first==null;
	}

	@Override
	public int length() {
		return this.count;
	}

	@Override
	public void destroyList() {
		while(this.first != null)
			this.first = first.getNext();
	}

	@Override
	public int search(T x) {
		Node <T> ay = this.first;
		for(int i=0; ay !=null; ay = ay.getNext(),i++)
			if(ay.getData().equals(x))
				return i;
		return -1;
	}
	public T searchData(T data) {
		Node<T> nodo=this.first;
		while(nodo!=null && !nodo.getData().equals(data)) {
			nodo=nodo.getNext();
		}
		if (nodo!=null)
			return nodo.getData();
		return null;
	}
	
	public Node<T> modi(T x) {
		Node <T> ay = this.first;
		for(int i=0; ay !=null; ay = ay.getNext(),i++)
			if(ay.getData().equals(x))
				return ay;
		return null;
	}
	public Node<T> getNodeAt(Node<T> ser){
		Node <T> ay = this.first;
		while(ay!=null) {
			if(ay.getData()==ser.getData()) {
				return ser;
			}
			ay=ay.getNext();
		}
		return null;
	}

	@Override
	public void insertFirst(T x) {
		this.first = new Node<T>(x,this.first);
		this.count++;
	}

	@Override
	public void insertLastT(T x) {
		if(this.isEmptyList())
			this.insertFirst(x);
		else {
			Node<T> lastNode = this.getLastNode();
			lastNode.setNext(new Node<T>(x));
			this.count++;
		}		
	}
	
	@Override
	public void remove(T x) {
		if(this.first==null)
			return;
		if(this.search(x)<0)
			return;
		Node <T> con = this.first;
		Node <T> ay = null;
		
		if (this.first.getData().equals(x)) {
			ay=this.first;
			this.first=this.first.getNext();
			ay=null;
		} 
		else{
			while(con.getNext().getData().equals(x)==false){
				 con=con.getNext();
			}
			
			ay = con.getNext();
			con.setNext(ay.getNext());
			ay=null;
		}
		this.count--;
	}	

	@Override
	public String toString() {
		Node <T> ay = this.first;
		String str="";
		for(int i=0; ay !=null; ay = ay.getNext(),i++)
			str+="\nPosicion: "+ i +" Objeto: "+ ay.getData();
		return str;	
	}
	
	//PreCondicion: lista no debe estas vacia
	private Node<T> getLastNode(){
		Node<T> ay= this.first;
		while(ay.getNext()!=null)
			ay=ay.getNext();
		return ay;
	}

	public Node<T> getFirst() {
		return first;
	}

	public void setFirst(T x) {
		this.first.setData(x);
	}
	public void setFirst(Node<T>x) {
		this.first=x;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	
	
		
		
		
}
	
	
	

