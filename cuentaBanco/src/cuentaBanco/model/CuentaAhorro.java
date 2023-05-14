package cuentaBanco.model;

public class CuentaAhorro extends Cuenta {
	
	/**
	 * ATRIBUTOS
	 */
	
    protected boolean cuentaActiva;

    public CuentaAhorro(){
    }

    public CuentaAhorro(boolean cuentaActiva) {
        this.cuentaActiva = cuentaActiva;
    }

    public CuentaAhorro(int numeroCuenta, float saldo, float tasa_anual) {
        super(numeroCuenta, saldo, tasa_anual);
    }

    public boolean isCuentaActiva() {
        return cuentaActiva;
    }

    public void setCuentaActiva(boolean cuentaActiva) {
        this.cuentaActiva = cuentaActiva;
    }

    @Override
    public String toString() {
        return "Cuenta ahorro\n"+ super.toString()+ "\nLa cuenta está activa: " + cuentaActiva;
    }

    
  /**
    * Método para consignar saldo en la cuenta bancaria activa
    * @param saldoConsignar el monto a consignar en la cuenta
    * @return un String indicando si la operación fue exitosa o si la cuenta está inactiva
    */

    @Override
    public String consignarSaldo(float saldoConsignar){
        String salida= "";
        if(this.saldo>=10000){
            cuentaActiva=true;
        }else{
            cuentaActiva=false;
        }

        if(cuentaActiva){
            salida= super.consignarSaldo(saldoConsignar);
        }else{
            salida= "La cuenta está inactiva";
        }
        return salida;
    }

    /**
     * Método para retirar saldo de la cuenta bancaria activa
     * @param saldoRetirar el monto a retirar de la cuenta
     * @return un String indicando si la operación fue exitosa o si la cuenta está inactiva
     */
    
    @Override
    public String retirarSaldo(float saldoRetirar){
        String salida= "";
        if(this.saldo>=10000){
            cuentaActiva=true;
        }else{
            cuentaActiva=false;
        }

        if(cuentaActiva){
            salida= super.retirarSaldo(saldoRetirar);
        }else{
            salida= "La cuenta está inactiva";
        }


        return salida;
    }
    
}
