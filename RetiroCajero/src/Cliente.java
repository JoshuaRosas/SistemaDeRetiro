
public class Cliente {
	private  String titu;
	private String dni;
	private String direc;
	public Cliente(String titu, String dni, String direc) {
		super();
		this.titu = titu;
		this.dni = dni;
		this.direc = direc;
	}
	public Cliente() {
		super();
	}
	public String getTitu() {
		return titu;
	}
	public void setTitu(String titu) {
		this.titu = titu;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getDirec() {
		return direc;
	}
	public void setDirec(String direc) {
		this.direc = direc;
	}
	@Override
	public String toString() {
		return "Cliente [titu=" + titu + ", dni=" + dni + ", direc=" + direc + "]";
	}
	

}
