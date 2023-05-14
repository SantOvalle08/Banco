package cuentaBanco.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import cuentaBanco.application.Aplicacion;
import cuentaBanco.model.Banco;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MainSceneController {
	
	//Llamamos a la clase Singleton
	ModelFactoryController mfm = ModelFactoryController.getInstance();
	
	//Llamamos a la clase Banco
	private Banco banco;
	
    //Creamos una variable aplicacion para comunicarme con la aplicacion y me pase datos de la empresa
	private Aplicacion aplicacion;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private TextArea txtResultados;
    
    @FXML
    private Button btnLimpiar;
    
    @FXML
    private Button btnRetirar;

    @FXML
    private Button btnConsultarDatos;

    @FXML
    private Button btnConsultarSaldo;

    @FXML
    private Button btnConsignar;

    @FXML
    private TextField txtNumeroCuenta;

    @FXML
    void consultarDatos(ActionEvent event) {
    	consultarDatos();
    }

    private void consultarDatos() {
    
    try {
    	
    	String texto = txtNumeroCuenta.getText(); // Obtener el texto del JTextField
    	int numeroCuenta = Integer.parseInt(texto); // Convertir el texto a un número entero

    	String datosCuenta = banco.consultarDatosCuenta(numeroCuenta);
    	txtResultados.setText(datosCuenta);
		} catch (Exception e) {
		    e.printStackTrace();
		}
	}

	@FXML
    void consignarDinero(ActionEvent event) {
    	consignarDinero();
    }

    private void consignarDinero() {
    	
    	float saldo = 0.0f;
    	
    	try {

    		String numCuenta = txtNumeroCuenta.getText(); // Obtener el texto del JTextField
        	int numeroCuenta = Integer.parseInt(numCuenta); // Convertir el texto a un número entero

    	    String input = JOptionPane.showInputDialog(null, "Ingrese el saldo a consignar:", "Saldo", JOptionPane.QUESTION_MESSAGE);
    	    saldo = Float.parseFloat(input);
        	String texto = banco.consignarSaldo(numeroCuenta, saldo);
        	txtResultados.setText(texto);
        	
    	} catch (NumberFormatException e) {
    	    JOptionPane.showMessageDialog(null, "Debe ingresar un valor numérico válido para la cuenta.", "Error", JOptionPane.ERROR_MESSAGE);
    	}

	}
    
    @FXML
    void limpiarDatos(ActionEvent event) {
    	limpiarDatos();
    }
    
	private void limpiarDatos() {
		txtNumeroCuenta.setText("");
		txtResultados.setText("");
	}

	@FXML
    void retirarDinero(ActionEvent event) {
    	retirarDinero();
    }

    private void retirarDinero() {
    	float saldo = 0.0f;
    	try {
        	String numCuenta = txtNumeroCuenta.getText(); // Obtener el texto del JTextField
        	int numeroCuenta = Integer.parseInt(numCuenta); // Convertir el texto a un número entero

    	    String input = JOptionPane.showInputDialog(null, "Ingrese el saldo a retirar:", "Saldo", JOptionPane.QUESTION_MESSAGE);
    	    saldo = Float.parseFloat(input);
        	String texto = banco.retirarSaldo(numeroCuenta, saldo);
        	txtResultados.setText(texto);
        	
    	} catch (NumberFormatException e) {
    	    JOptionPane.showMessageDialog(null, "Debe ingresar un valor numérico válido para la cuenta.", "Error", JOptionPane.ERROR_MESSAGE);
    	}

	}

	@FXML
    void consultarSaldo(ActionEvent event) {
    	consultarSaldo();
    }

    private void consultarSaldo() {
    	try {
    	    String input = txtNumeroCuenta.getText();
        	int numeroCuenta = Integer.parseInt(input); // Convertir el texto a un número entero
        	String saldo = banco.consultarSaldo(numeroCuenta);
        	txtResultados.setText(saldo);
    	} catch (NumberFormatException e) {
    	    JOptionPane.showMessageDialog(null, "Debe ingresar un valor numérico válido para la cuenta.", "Error", JOptionPane.ERROR_MESSAGE);
    	}

	}

	@FXML
    void initialize() {
        assert btnRetirar != null : "fx:id=\"btnRetirar\" was not injected: check your FXML file 'MainSceneView.fxml'.";
        assert btnConsultarDatos != null : "fx:id=\"btnConsultarDatos\" was not injected: check your FXML file 'MainSceneView.fxml'.";
        assert btnConsultarSaldo != null : "fx:id=\"btnConsultarSaldo\" was not injected: check your FXML file 'MainSceneView.fxml'.";
        assert btnConsignar != null : "fx:id=\"btnConsignar\" was not injected: check your FXML file 'MainSceneView.fxml'.";
        assert txtNumeroCuenta != null : "fx:id=\"txtNumeroCuenta\" was not injected: check your FXML file 'MainSceneView.fxml'.";

    }

	public void setAplicacion(Aplicacion aplicacion) {

			this.aplicacion = aplicacion;
			this.banco = mfm.getBanco();
			
	}
	
}
