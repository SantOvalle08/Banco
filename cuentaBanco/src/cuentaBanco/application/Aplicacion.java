package cuentaBanco.application;
	
import cuentaBanco.controllers.MainSceneController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;


public class Aplicacion extends Application {
	
	private Stage primaryStage;

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		mostrarVentanaPrincipal();
	}

	//Tiene una serie de codigo que siempre es igual
	
	private void mostrarVentanaPrincipal() {
		try {

			FXMLLoader loader = new FXMLLoader();
			//De donde se va a cargar la intefaz
			loader.setLocation(Aplicacion.class.getResource("/cuentaBanco/views/MainSceneView.fxml"));
			//Definimos el anchorPane
			AnchorPane anchorPane = (AnchorPane)loader.load();
			//Obtenemos el controlador
			MainSceneController mainSceneController = loader.getController();
			//Para decir que el controlador pueda acceder a aplicacion
			mainSceneController.setAplicacion(this);
			//Para crear la escena (Panel principal). Le decimos el layout que va a cargar
			Scene scene = new Scene(anchorPane);
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		launch(args);
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}



}