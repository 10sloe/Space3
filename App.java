import javafx.application.Application;

import javafx.stage.Stage;
import javafx.scene.Scene;

import javafx.scene.layout.*;
import javafx.scene.control.*;

import javafx.geometry.Insets;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.geometry.Pos;

/**
 * Hauptanwendung
 */

public class App extends Application {

    public void start(Stage stage)
    {
        Canvas canvas = new Canvas(800, 500);         // Zeichenfläche
        GraphicsContext gc = canvas.getGraphicsContext2D(); // Graphikkontext der Zeichenfläche

        Spielsteuerung skizze = new Spielsteuerung(gc);     //Meine Zeichnung!

        // Das Menu
        VBox vbox = new VBox(10);

        Button button1 = new Button("Start");
        //Button button2 = new Button("Reset");

        button1.setPrefWidth(100);
        //button2.setPrefWidth(100);

        button1.setOnAction(e -> {
                skizze.start();
                canvas.requestFocus();
            }
        );               
        //button2.setOnAction(e -> skizze.reset());

        // Sorgt dafür, dass das Canvas den Fokus erhalten kann
        canvas.setFocusTraversable(true);

        // Falls eine Taste runtergedrückt wird
        canvas.setOnKeyPressed(e -> {
                skizze.gedrueckt(e);
            });

        // Falls die Taste losgelassen wird
        canvas.setOnKeyReleased(e -> {
                skizze.losgelassen(e);
            });

        vbox.getChildren().add(button1);
        //vbox.getChildren().add(button2);
        vbox.setPadding(new Insets(30,30,30,30));

        // Oberfläche zusammenbauen
        Pane root = new Pane();  

        root.getChildren().addAll(canvas,vbox);

        vbox.setLayoutX(640);
        vbox.setLayoutY(20);        

        // Fenster
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("SpaceInvaders!");
        stage.show();

        canvas.requestFocus();
        

    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}
