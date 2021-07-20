
public class Cuenta {
	private String numcuenta;
	private double salcon;
	private double saldis;
	private String tipo;
	public Cuenta(String numcuenta, double salcon, double saldis, String tipo) {
		super();
		this.numcuenta = numcuenta;
		this.salcon = salcon;
		this.saldis = saldis;
		this.tipo = tipo;
	}
	public String getNumcuenta() {
		return numcuenta;
	}
	public void setNumcuenta(String numcuenta) {
		this.numcuenta = numcuenta;
	}
	public double getSalcon() {
		return salcon;
	}
	public void setSalcon(double salcon) {
		this.salcon = salcon;
	}
	public double getSaldis() {
		return saldis;
	}
	public void setSaldis(double saldis) {
		this.saldis = saldis;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	@Override
	public String toString() {
		return "Cuenta [numcuenta=" + numcuenta + ", salcon=" + salcon + ", saldis=" + saldis + ", tipo=" + tipo + "]";
	}
	

}
