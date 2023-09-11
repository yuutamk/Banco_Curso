package Implementacion;

import java.util.Map;

import Dominio.Cliente;
import Interface.MetodosProcedimientos;

public class ImplementacionGenerica implements MetodosProcedimientos{

	@Override
	public double depositar(double cantidad) {
		return cantidad;
		// TODO Auto-generated method stub
		
	}

	@Override
	public double retirar(double cantidad) {
		return cantidad;
		// TODO Auto-generated method stub
		
	}

	@Override
	public double consultarSaldo() {
		// TODO Auto-generated method stub
		return 0;
	}
	public static long generarNumeroCuentaUnico(Map<Long, Cliente> cuentas) {
		// TODO Auto-generated method stub
		return 0;
	}
}
