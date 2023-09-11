package Implementacion;

import Dominio.Cliente;
import java.util.Map;

public class GestorCuentas {
	public static long generarNumeroCuentaUnico(Map<Long, Cliente> cuentas) {
	    long nuevoNumeroCuenta;
	    do {
	        nuevoNumeroCuenta = generarNumeroCuentaAleatorio(); // Puedes implementar tu lógica aquí
	    } while (cuentas.containsKey(nuevoNumeroCuenta));
	    return nuevoNumeroCuenta;
	}

	// Función para generar un número de cuenta aleatorio
	private static long generarNumeroCuentaAleatorio() {
	    return (long) (Math.random() * 1000000); // Esto genera un número aleatorio de 6 dígitos
	}
}
