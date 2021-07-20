
public class Banco implements Comparable<Banco>{
	private int codban;
	private String nombre;
    private int tel;
    private String dirweb;
    private Cuenta numcuen;
	public Banco(int codban, String nombre, int tel, String dirweb, Cuenta numcuen) {
		super();
		this.codban = codban;
		this.nombre = nombre;
		this.tel = tel;
		this.dirweb = dirweb;
		this.numcuen = numcuen;
	}
	public Banco() {
		super();
	}
	public int getCodban() {
		return codban;
	}
	public void setCodban(int codban) {
		this.codban = codban;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	public String getDirweb() {
		return dirweb;
	}
	public void setDirweb(String dirweb) {
		this.dirweb = dirweb;
	}
	public Cuenta getNumcuen() {
		return numcuen;
	}
	public void setNumcuen(Cuenta numcuen) {
		this.numcuen = numcuen;
	}
	public int compareTo(Banco co1){
        if(this.codban==co1.getCodban()){return 0;}
        else if (this.codban<co1.getCodban()){return -1;}
        return 1;

    }
	@Override
	public String toString() {
		return "Banco [codban=" + codban + ", nombre=" + nombre + ", tel=" + tel + ", dirweb=" + dirweb + ", numcuen="
				+ numcuen + "]";
	}
    
	

}
