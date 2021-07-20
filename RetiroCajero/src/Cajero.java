
public class Cajero implements Comparable<Cajero>{
	private Integer codcaj;
	private String direccion;
	
	public Cajero(Integer codcaj, String direccion) {
		super();
		this.codcaj = codcaj;
		this.direccion = direccion;
	}
	public Cajero() {
		super();
	}
	public Integer getCodcaj() {
		return codcaj;
	}
	public void setCodcaj(Integer codcaj) {
		this.codcaj = codcaj;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int compareTo(Cajero co1){
        if(this.codcaj==co1.getCodcaj()){return 0;}
        else if (this.codcaj<co1.getCodcaj()){return -1;}
        return 1;

    }
	@Override
	public String toString() {
		return "Cajero [codcaj=" + codcaj + ", direccion=" + direccion + "]";
	}
	

}
