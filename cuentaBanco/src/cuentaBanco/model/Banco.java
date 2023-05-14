package cuentaBanco.model;

import java.util.ArrayList;
import java.util.List;

public class Banco {
	
	private Cuenta cuenta;
	
	private String nombre;
	private List<Cuenta> listaCuentas= new ArrayList <Cuenta>();

	
	public Banco(String nombre) 
	{
		super();
		this.nombre = nombre;
	}

	public Banco() {
		super();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	public List<Cuenta> getListaCuentas() {
		return listaCuentas;
	}

	public void setListaCuentas(List<Cuenta> listaCuentas) {
		this.listaCuentas = listaCuentas;
	}
	
//------------------------------------------------------------------------------------------------------
	
	/**
	 *  Metodo para consignar saldo.
	 */
	
	public String consignarSaldo(int numeroCuenta, float saldoConsignar) {
    	for (Cuenta cuenta : listaCuentas) {
            if (cuenta.getNumeroCuenta() == numeroCuenta) {
                return cuenta.consignarSaldo(saldoConsignar);
            	}
        }
        return "No se encontró la cuenta con el número " + numeroCuenta;
		// cuenta.consignarSaldo(saldoConsignar);
	}
	
	/**
	 * Metodo para consultar los datos de una cuenta
	 * @param numeroCuenta
	 * @return datosCuenta si existe , sino retorna que no se encontro la cuenta.
	 */
	
    public String consultarDatosCuenta(int numeroCuenta) {
    	for (Cuenta cuenta : listaCuentas) {
            if (cuenta.getNumeroCuenta() == numeroCuenta) {
                return cuenta.toString();
            }
        }
        return "No se encontró la cuenta con el número " + numeroCuenta;
    }

	public String consultarSaldo(int numeroCuenta) {
    	for (Cuenta cuenta : listaCuentas) {
            if (cuenta.getNumeroCuenta() == numeroCuenta) {
                return "El saldo de la cuenta es:\n"+cuenta.consultarSaldo();
            }
        }
        return "No se encontró la cuenta con el número " + numeroCuenta;
    }
	
	public String retirarSaldo (int numeroCuenta, float saldoRetirar) 
	{
    	for (Cuenta cuenta : listaCuentas) {
            if (cuenta.getNumeroCuenta() == numeroCuenta) {
                return cuenta.retirarSaldo(saldoRetirar);
            }
        }
        return "No se encontró la cuenta con el número " + numeroCuenta;
    }

}
