package Main;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;
import Implementacion.Banco;
import Dominio.Cliente;
import Implementacion.GestorCuentas;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
        Scanner scanner = new Scanner(System.in);
        Map<Long, Cliente> cuentas = new HashMap<>();
        Banco banco = new Banco(cuentas);
        GestorCuentas gestorCuentas = new GestorCuentas();

        String nombre;
        String app;
        String apm;
        long numCuenta;
        int saldo;

        boolean salir = false;
        long numeroCuentaActual = -1; 

		do {
			if (numeroCuentaActual == -1) {
				// Menú principal cuando no se ha iniciado sesión
				System.out.println("MENU PRINCIPAL");
				System.out.println("1. Iniciar Sesión");
				System.out.println("2. Dar de Alta Cuenta");
				System.out.println("3. Salir");
				System.out.print("Seleccione una opción: ");
				int opcionPrincipal = scanner.nextInt();

				switch (opcionPrincipal) {
				case 1:
					// Iniciar Sesión
					System.out.print("Ingrese el número de cuenta: ");
					long numeroCuenta = scanner.nextLong();
					if (cuentas.containsKey(numeroCuenta)) {
						numeroCuentaActual = numeroCuenta;
						System.out.println("Sesión iniciada. ¡Bienvenido!");
					} else {
						System.out.println("Número de cuenta no válido.");
					}
					break;
				case 2:
					 do {
					        // Dar de Alta Cuenta
					        System.out.print("Ingrese el nombre del cliente: ");
					        scanner.nextLine();
					        String nombreC = scanner.nextLine();
					        

					        // Generar un número de cuenta único
					        long nuevoNumeroCuenta = GestorCuentas.generarNumeroCuentaUnico(cuentas);

					        Cliente nuevoCliente = new Cliente(nombreC, "", "", nuevoNumeroCuenta, 0);
					        cuentas.put(nuevoNumeroCuenta, nuevoCliente);
					        System.out.println("Cuenta creada con éxito. Su número de cuenta es: " + nuevoNumeroCuenta);

					        // Iniciar sesión automáticamente
					        numeroCuentaActual = nuevoNumeroCuenta;
					        System.out.println("Sesión iniciada. ¡Bienvenido!");

					    } while (numeroCuentaActual == -1);
					break;
				case 3:
					// Salir
					salir = true;
					break;
				default:
					System.out.println("Opción no válida. Intente de nuevo.");
				}
			} else {
				// Menú cuando se ha iniciado sesión
				System.out.println("MENU DE OPERACIONES");
				System.out.println("1. Consultar Saldo");
				System.out.println("2. Realizar Depósito");
				System.out.println("3. Realizar Retiro");
				System.out.println("4. Cerrar Sesión");
				System.out.print("Seleccione una opción: ");
				int opcionOperaciones = scanner.nextInt();

				switch (opcionOperaciones) {
				case 1:
					// Consultar Saldo
					double saldoC = banco.consultarSaldo(numeroCuentaActual);
					if (saldoC >= 0) {
						System.out.println("Su saldo actual es: $" + saldoC);
					} else {
						System.out.println("Número de cuenta no válido.");
					}
					break;
				case 2:
					// Realizar Depósito
	                System.out.print("Ingrese la cantidad a depositar: ");
	                double cantidadDeposito = scanner.nextDouble();
	                boolean depositoExitoso = banco.depositar(numeroCuentaActual, cantidadDeposito);
	                if (depositoExitoso) {
	                    System.out.println("Depósito exitoso.");
	                } else {
	                    System.out.println("Número de cuenta no válido o cantidad no válida.");
	                }
					break;
				case 3:
					// Realizar Retiro
				    System.out.print("Ingrese la cantidad a retirar: ");
				    double cantidadRetiro = scanner.nextDouble();
				    
				    if (cantidadRetiro < 0) {
				        System.out.println("La cantidad a retirar debe ser mayor que cero.");
				    } else {
				        // Verifica que la cuenta tenga suficiente saldo para el retiro
				        Cliente clienteActual = cuentas.get(numeroCuentaActual);
				        if (clienteActual.getSaldo() >= cantidadRetiro) {
				            boolean retiroExitoso = banco.retirar(numeroCuentaActual, cantidadRetiro);
				            if (retiroExitoso) {
				                System.out.println("Retiro exitoso.");
				            } else {
				                System.out.println("Error al realizar el retiro.");
				            }
				        } else {
				            System.out.println("Fondos insuficientes para realizar el retiro.");
				        }
				    }
					break;
				case 4:
					// Cerrar Sesión
					numeroCuentaActual = -1;
					System.out.println("Sesión cerrada. ¡Hasta luego!");
					break;
				default:
					System.out.println("Opción no válida. Intente de nuevo.");
				}
			}
		} while (!salir);
	}


}
