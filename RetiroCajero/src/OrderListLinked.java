
public class OrderListLinked <T extends Comparable<T>> extends ListLinked<T>    {
	public OrderListLinked() {
		super();
	}
	
	public int search (T item) {
		Node <T> aux=this.getFirst();
		int con=0;
		while (aux!=null && aux.getData().compareTo(item)<0) {
			aux=aux.getNext();
			con++;
		}
		if(aux!=null) {
			if(aux.getData().equals(item))
				return con;
		}
		return -1;
	}

	public void insert (T x) {//Por si la lista está vacia o el elemento a agregar es menor que el primer elemento
		if (this.isEmptyList() || this.getFirst().getData().compareTo(x) >= 0)
		{ 	
			this.insertFirst(x);
		}
		else
		{
			Node<T> aux = this.getFirst();
			while(aux.getNext() != null && aux.getNext().getData().compareTo(x)<0){
				aux = aux.getNext();
			}
			aux.setNext(new Node<T>(x, aux.getNext()));
			this.setCount(getCount()+1);
		}
	}

	
		
	public void remove(T x) {
		Node <T> aux=this.getFirst();
		Node <T> ay=null;

		if (this.getFirst().getData().equals(x)) {
			ay=this.getFirst();
			this.setFirst(this.getFirst().getNext());
			ay=null;
		} 
		else {
			while (aux!=null && aux.getData().compareTo(x)<0) {
				aux=aux.getNext();
			}
			if(aux!=null) {
				if(aux.getNext().getData().equals(x)) {
					ay = aux.getNext();
					aux.setNext(ay.getNext());
					ay=null;
				}
			}
				
		}
	}

}
