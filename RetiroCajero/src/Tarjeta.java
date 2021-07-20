
public class Tarjeta implements Comparable<Tarjeta>{
	private String numtar;
	private String tipotar;
	private String fecven;
	private String cvv;
	private int clavcaj;
	private Cuenta numcuen;
	private Cliente dni;
	public Tarjeta(String numtar, String tipotar, String fecven, String cvv, int clavcaj, Cuenta numcuen, Cliente dni) {
		super();
		this.numtar = numtar;
		this.tipotar = tipotar;
		this.fecven = fecven;
		this.cvv = cvv;
		this.clavcaj = clavcaj;
		this.numcuen = numcuen;
		this.dni=dni;
		
	}
	public Tarjeta() {
		super();
	}
	public Cliente getDni() {
		return dni;
	}
	public void setDni(Cliente dni) {
		this.dni = dni;
	}
	public String getNumtar() {
		return numtar;
	}
	public void setNumtar(String numtar) {
		this.numtar = numtar;
	}
	public String getTipotar() {
		return tipotar;
	}
	public void setTipotar(String tipotar) {
		this.tipotar = tipotar;
	}
	public String getFecven() {
		return fecven;
	}
	public void setFecven(String fecven) {
		this.fecven = fecven;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	public int getClavcaj() {
		return clavcaj;
	}
	public void setClavcaj(int clavcaj) {
		this.clavcaj = clavcaj;
	}
	public Cuenta getNumcuen() {
		return numcuen;
	}
	public void setNumcuen(Cuenta numcuen) {
		this.numcuen = numcuen;
	}

	
	public int compareTo(Tarjeta x) {
		if(this.getClavcaj()>x.getClavcaj()) return 1;
		if(this.getClavcaj()<x.getClavcaj()) return -1;
		return 0;
	}
	public boolean equals(Object o) {
		if (o instanceof Tarjeta) {
			Tarjeta m = (Tarjeta) o;
			return m.getClavcaj()==this.getClavcaj();
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "Tarjeta [numtar=" + numtar + ", tipotar=" + tipotar + ", fecven=" + fecven + ", cvv=" + cvv
				+ ", clavcaj=" + clavcaj + ", numcuen=" + numcuen + ", dni=" + dni + "]";
	}
	
}