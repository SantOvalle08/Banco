package cuentaBanco.model;

import java.util.Objects;

public class Cuenta {

	/**
	 * ATRIBUTOS
	 */
	
	protected int numeroCuenta;
	protected float saldo;
	protected int cant_consignaciones;
	protected int cant_retiros;
	protected float tasa_anual;
	protected float comision_mensual;

	public Cuenta() {
	}

	public Cuenta(int numeroCuenta, float saldo, float tasa_anual) {
		this.numeroCuenta = numeroCuenta;
		this.saldo = saldo;
		this.tasa_anual = tasa_anual;
		this.cant_consignaciones = 0;
		this.cant_retiros = 0;
		this.comision_mensual = 0;
	}
	
	public int getNumeroCuenta() {
		return numeroCuenta;
	}
	
	public void setNumeroCuenta(int numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}
	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public int getCant_consignaciones() {
		return cant_consignaciones;
	}

	public void setCant_consignaciones(int cant_transacciones) {
		this.cant_consignaciones = cant_transacciones;
	}

	public int getCant_retiros() {
		return cant_retiros;
	}

	public void setCant_retiros(int cant_retiros) {
		this.cant_retiros = cant_retiros;
	}

	public float getTasa_anual() {
		return tasa_anual;
	}

	public void setTasa_anual(float tasa_anual) {
		this.tasa_anual = tasa_anual;
	}

	public float getComision_mensual() {
		return comision_mensual;
	}

	public void setComision_mensual(float comision_mensual) {
		this.comision_mensual = comision_mensual;
	}
	
	

	@Override
	public int hashCode() {
		return Objects.hash(numeroCuenta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cuenta other = (Cuenta) obj;
		return numeroCuenta == other.numeroCuenta;
	}

	@Override
	public String toString() {
		return "Detalles de Cuenta: \nNumero de cuenta: "+numeroCuenta+"\nSaldo: " + saldo + "\nCantidad de transacciones: " + cant_consignaciones
				+ "\nCantidad de retiros: " + cant_retiros + "\nTasa anual(Porcentaje): " + tasa_anual
				+ "\nComision mensual: " + comision_mensual;
	}
	
	/**
	 * Metodo para consignar saldo en una cuenta
	 * @param saldoConsignar: el saldo a consignar.
	 * @return msg + saldo.
	 */
	
	public String consignarSaldo(float saldoConsignar) {
		saldo += saldoConsignar;
		cant_consignaciones++;
		return "Consignacion exitosa \nSu nuevo saldo es: " + saldo;
	}

	/**
	 * Metodo para retirar saldo de una cuenta, si es mayor 
	 * @param saldoRetirar
	 * @return
	 */
	
	public String retirarSaldo(float saldoRetirar) {
		String salida = "";
		if (saldo >= saldoRetirar) {
			saldo -= saldoRetirar;
			cant_retiros++;
			salida = "El retiro ha sido exitoso \nSu nuevo saldo es: " + saldo;
			;
		} else {
			salida = "No se puede retirar un saldo que no existe en la cuenta";
		}
		return salida;
	}
	
	/**
	 * Metodo que calcula el interes Mensual de la cuenta
	 * @return interesMensual
	 */
	
	public double calcularInteresMensual() {
		double interesMensual = (saldo * (tasa_anual / 100.0)) / 12;
		saldo += interesMensual;
		cant_consignaciones++;
		return interesMensual;
	}
	
	/**
	 * Metodo que calcula el extracto Mensual de la cuenta
	 * @return extractoMensual
	 */
	
	public String extractoMensual() {
		String salida = "";
		saldo -= comision_mensual;
		return salida;
	}
	
	/**
	 * 	Metodo que consulta solo el saldo de la cuenta
	 *  @return saldo de la cuenta
	 */
	
	public String consultarSaldo () {
		return ""+saldo;
	}
}
