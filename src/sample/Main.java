package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private static Stage escena;

    //mirar si quitar esto
    public static Stage getStage(){return escena;}

    @Override
    public void start(Stage primaryStage) throws Exception{
        try {
            Parent root = FXMLLoader.load(getClass().getResource("PantallaInicial.fxml"));
            escena = primaryStage;
            escena.setTitle("Pokemon");
            escena.setScene(new Scene(root, 1000, 576));
            escena.setResizable(false);
            escena.show();
        } catch (IOException e){
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
        launch(args);
    }
}
