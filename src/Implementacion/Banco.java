package Implementacion;

import java.util.Map;

import Dominio.Cliente;

public class Banco extends ImplementacionGenerica {
	private Map<Long, Cliente> cuentas;
	
	public Banco(Map<Long, Cliente> cuentas) {
        this.cuentas = cuentas;
    }
	 public double consultarSaldo(long numeroCuenta) {
	        if (cuentas.containsKey(numeroCuenta)) {
	            Cliente cliente = cuentas.get(numeroCuenta);
	            return cliente.getSaldo();
	        } else {
	            return -1; // Devuelve un valor negativo para indicar que la cuenta no existe
	        }
	    }

	    public boolean depositar(long numeroCuenta, double cantidad) {
	        if (cuentas.containsKey(numeroCuenta)) {
	            Cliente cliente = cuentas.get(numeroCuenta);
	            double saldoActual = cliente.getSaldo();
	            saldoActual += cantidad;
	            cliente.setSaldo(saldoActual);
	            return true;
	        } else {
	            return false; // Devuelve false para indicar que la cuenta no existe
	        }
	    }

	    public boolean retirar(long numeroCuenta, double cantidad) {
	        if (cuentas.containsKey(numeroCuenta)) {
	            Cliente cliente = cuentas.get(numeroCuenta);
	            double saldoActual = cliente.getSaldo();
	            if (saldoActual >= cantidad) {
	                saldoActual -= cantidad;
	                cliente.setSaldo(saldoActual);
	                return true;
	            } else {
	                return false; // Devuelve false para indicar fondos insuficientes
	            }
	        } else {
	            return false; // Devuelve false para indicar que la cuenta no existe
	        }
	    }
	public long darDeAltaCuenta(Cliente nuevoCliente, Map<Long, Cliente> cuentas) {
		// TODO Auto-generated method stub
		return 0;
	}

}
