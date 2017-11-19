package application;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.Scene;
import java.awt.BorderLayout;
import java.util.Random;
import javafx.scene.layout.Border;
import javafx.scene.layout.*;

public class Pierwszaklasa extends Application{

	public static void main(String[] args) {
		launch(args);

	}
	public void start (Stage Poczatkowe)throws Exception
	{
		Pane root=new Pane();
		Poczatkowe.setTitle("d");
	     Scene scena=new Scene(root,300,300);
	    // idzie z klasy stworzenrootieklawiszy();
	    Klawisze k=new Klawisze();
	     k.stworzklawiszeiakcje(root);
	     scena.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	     
	    
	    Poczatkowe.setScene(scena);
		Poczatkowe.show();
		
	}

}


// scena.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//w³asny kakulator 
//Stworzenie wygladu