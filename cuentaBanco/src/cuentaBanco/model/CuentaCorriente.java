package cuentaBanco.model;

public class CuentaCorriente extends Cuenta {

	/**
	 * ATRIBUTOS
	 */
	
	protected float sobreGiro;

	public CuentaCorriente(int numeroCuenta, float saldo, float tasa_anual) {
		super(numeroCuenta, saldo, tasa_anual);
		this.sobreGiro = 0;
	}

	public float getSobreGiro() {
		return sobreGiro;
	}

	public void setSobreGiro(float sobreGiro) {
		this.sobreGiro = sobreGiro;
	}

	@Override
	public String toString() {
		return "Cuenta Corriente\n" + super.toString() + "\nsobre giro: " + sobreGiro;
	}
	

    /**
     * Método para retirar saldo de la cuenta bancaria activa
     * @param saldoRetirar el monto a retirar de la cuenta
     * @return un String indicando si la operación fue exitosa o si la cuenta está inactiva
     */
	
	@Override
	public String retirarSaldo(float saldoRetirar) {
		String salida = "";
		if (this.saldo <= saldoRetirar) {
			sobreGiro = saldoRetirar - this.saldo;
			saldo -= saldoRetirar;
			salida = "Retiro exitoso, pero tenga en cuenta que tiene un sobre giro de: " + sobreGiro
					+ "\nSaldo actual: " + this.saldo;
		} else {
			saldo -= saldoRetirar;
			salida = "Retiro exitoso, no presenta sobre giro \nSaldo actual: " + this.saldo;
		}
		cant_retiros++;
		return salida;
	}
	
    
  /**
    * Método para consignar saldo en la cuenta bancaria activa
    * @param saldoConsignar el monto a consignar en la cuenta
    * @return un String indicando si la operación fue exitosa o si la cuenta está inactiva
    */
	
	@Override
	public String consignarSaldo(float saldoConsignar) {
		String salida = "";
		if (this.saldo < 0) {
			salida = "Actualmente presenta un sobre giro de: " + sobreGiro
					+ " por lo que este valor ha sido cobrado al momento de la consignacion \n"
					+ super.consignarSaldo(saldoConsignar);
		} else {
			salida = super.consignarSaldo(saldoConsignar);
		}
		return salida;
	}

}
