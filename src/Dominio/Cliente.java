package Dominio;

public class Cliente {
	private String nombre;
	private String app;
	private String apm;
	private long numCuenta;
	private int saldo;
	
	public Cliente() {
	}

	public Cliente(String nombre, String app, String apm, long numCuenta, int saldo) {
		this.nombre = nombre;
		this.app = app;
		this.apm = apm;
		this.numCuenta = numCuenta;
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", app=" + app + ", apm=" + apm + ", numCuenta=" + numCuenta + ", saldo="
				+ saldo + "]\n";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApp() {
		return app;
	}

	public void setApp(String app) {
		this.app = app;
	}

	public String getApm() {
		return apm;
	}

	public void setApm(String apm) {
		this.apm = apm;
	}

	public long getNumCuenta() {
		return numCuenta;
	}

	public void setNumCuenta(long numCuenta) {
		this.numCuenta = numCuenta;
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldoActual) {
		this.saldo = (int) saldoActual;
	}
	
	
}
