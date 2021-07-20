
public interface  TDAList <T> {
	boolean isEmptyList();
	int length();
	void destroyList();
	int search(T x);
	void insertFirst(T x);
	void insertLastT (T x);
	void remove(T x);
}
