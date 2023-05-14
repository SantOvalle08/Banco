module CuentaBancoJavaFX {
	
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.base;
	requires javafx.graphics;
	requires java.desktop;
	exports cuentaBanco.controllers;
	
	opens cuentaBanco.controllers to javafx.fxml;
	opens cuentaBanco.application to javafx.graphics, javafx.fxml;
}
