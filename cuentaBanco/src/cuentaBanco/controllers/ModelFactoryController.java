package cuentaBanco.controllers;

import cuentaBanco.model.Banco;
import cuentaBanco.model.Cuenta;
import cuentaBanco.model.CuentaAhorro;
import cuentaBanco.model.CuentaCorriente;

public class ModelFactoryController {
	
	Banco banco =  null;

	private static class SingletonHolder {
		// El constructor de Singleton puede ser llamado desde aquí al ser protected
		private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
	}

	// Metodo para obtener la instancia de la clase
	public static ModelFactoryController getInstance() {
		return SingletonHolder.eINSTANCE;
	}

	public ModelFactoryController() {
		System.out.println("invocación clase singleton");
		inicializarDatos();
	}
	
	private void inicializarDatos() {
		banco = new Banco("Mi Banco");
        Cuenta cuenta= new Cuenta(12345,50000, 175 );
        banco.getListaCuentas().add(cuenta);
        CuentaAhorro cuenta2= new CuentaAhorro(123,30000, 175);
        banco.getListaCuentas().add((CuentaAhorro) cuenta2);
        CuentaCorriente cuenta3= new CuentaCorriente(45,40000, 175);
        banco.getListaCuentas().add((CuentaCorriente) cuenta3);

	}

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}
	
	
}
