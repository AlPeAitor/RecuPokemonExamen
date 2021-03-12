package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

//erl marcador de vida dejo de funcionar por algun motivo, asi que lo he deshabilitado

public class Controller {

    int vidaAMandar = 0;
    static int seleccion = 0;
    int desc=0;
    private Detalles detalles;

    String descP1="Hola, soy Bulbasaur";
    String descP2="Hola, soy Squirtle";
    String descP3="Hola, soy Charmander";
    String descP4="Hola, soy Pikachu";
    String descP5="Hola, soy Diglett";
    String descP6="Hola, soy Articuno";



    //pokemon1

    @FXML
    public Label nombreP1;

    @FXML
    public Label nvP1;

    @FXML
    public Label vidaNumerica;

    @FXML
    public ProgressBar psP1;


    //pokemon2
    @FXML
    public Label nombreP2;

    @FXML
    public Label nvP2;

    @FXML
    public Label vidaNumerica2;

    @FXML
    public ProgressBar psP2;

    //pokemon3

    @FXML
    public Label nombreP3;

    @FXML
    public Label nvP3;

    @FXML
    public Label vidaNumerica3;

    @FXML
    public ProgressBar psP3;


    //pokemon4

    @FXML
    public Label nombreP4;

    @FXML
    public Label nvP4;

    @FXML
    public Label vidaNumerica4;

    @FXML
    public ProgressBar psP4;

    //pokemon5

    @FXML
    public Label nombreP5;

    @FXML
    public Label nvP5;

    @FXML
    public Label vidaNumerica5;

    @FXML
    public ProgressBar psP5;

    //pokemon6

    @FXML
    public Label nombreP6;

    @FXML
    public Label nvP6;

    @FXML
    public Label vidaNumerica6;

    @FXML
    public ProgressBar psP6;

    @FXML
    public Button button1;

    @FXML
    public ImageView fav1;

    @FXML
    public ImageView fav2;

    @FXML
    public ImageView fav3;

    @FXML
    public ImageView fav4;

    @FXML
    public ImageView fav5;

    @FXML
    public ImageView fav6;


    private final Pokemon pk1 = new Pokemon("Bulbasaur", 200, 21);
    private final Pokemon pk2 = new Pokemon("Squirtle", 250, 30);
    private final Pokemon pk3 = new Pokemon("Charmander", 300, 40);
    private final Pokemon pk4 = new Pokemon("Pikachu", 350, 50);
    private final Pokemon pk5 = new Pokemon("Diglett", 325, 42);
    private final Pokemon pk6 = new Pokemon("Articuno", 500, 70);


    @FXML
    public void initialize(){
        datosPokemon(nombreP1, nvP1, vidaNumerica, pk1);
        psP1.setProgress((float)pk1.getVidaActual()/pk1.getVidaMaxima());

        datosPokemon(nombreP2, nvP2, vidaNumerica2, pk2);
        psP2.setProgress((float)pk2.getVidaActual()/pk2.getVidaMaxima());

        datosPokemon(nombreP3, nvP3, vidaNumerica3, pk3);
        psP3.setProgress((float)pk3.getVidaActual()/pk3.getVidaMaxima());

        datosPokemon(nombreP4, nvP4, vidaNumerica4, pk4);
        psP4.setProgress((float)pk4.getVidaActual()/pk4.getVidaMaxima());

        datosPokemon(nombreP5, nvP5, vidaNumerica5, pk5);
        psP5.setProgress((float)pk5.getVidaActual()/pk5.getVidaMaxima());

        datosPokemon(nombreP6, nvP6, vidaNumerica6, pk6);
        psP6.setProgress((float)pk6.getVidaActual()/pk6.getVidaMaxima());

        fav1.setOpacity(0);
        fav2.setOpacity(0);
        fav3.setOpacity(0);
        fav4.setOpacity(0);
        fav5.setOpacity(0);
        fav6.setOpacity(0);


    }

    public void datosPokemon(Label nombre, Label nivel, Label vida, Pokemon pk){
        nombre.setText(pk.getNombre());
        nivel.setText("Nv. " + pk.getNivel());
    }

    @FXML
    private void onButtonAction(ActionEvent event) throws IOException{

        if (seleccion==0) {
        }else if(pk1.getVidaActual()<pk1.getVidaMaxima() || pk2.getVidaActual() < pk2.getVidaMaxima() || pk3.getVidaActual() < pk3.getVidaMaxima() || pk4.getVidaActual() < pk4.getVidaMaxima() || pk5.getVidaActual() < pk5.getVidaMaxima() || pk6.getVidaActual() < pk6.getVidaMaxima()) {
            try {
                Stage stage = new Stage();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Mochila.fxml"));
                GridPane root = (GridPane) loader.load();
                Scene scene = new Scene(root, 570, 400);
                stage.setResizable(false);
                stage.setScene(scene);
                stage.show();

                Mochila controller = loader.getController();
                controller.mandarInfoDesdeVentana1(vidaAMandar);
                controller.setVentana1(this);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            Alert customAlert = new Alert(Alert.AlertType.NONE);
            customAlert.setTitle("¡Enhorabuena, ha curado a todos sus Pokemons!");

            customAlert.getDialogPane().getButtonTypes().addAll(ButtonType.FINISH);
            showAlert(customAlert);
        }
    }

    @FXML
    private void onButtonDetallesAction(ActionEvent event) throws IOException{

        if (seleccion==0) {
        }else {
            try {
                Stage stage = new Stage();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Detalles.fxml"));
                GridPane root = (GridPane) loader.load();
                Scene scene = new Scene(root, 570, 400);
                stage.setResizable(false);
                stage.setScene(scene);
                stage.show();

                Detalles controller = loader.getController();
                controller.mandarInfoDesdeVentana1(vidaAMandar, desc);
                controller.setVentana1(this);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void marcarFav(){
        switch (seleccion){
            case 1:
                fav1.setOpacity(1);
                break;
            case 2:
                fav2.setOpacity(1);
                break;
            case 3:
                fav3.setOpacity(1);
                break;
            case 4:
                fav4.setOpacity(1);
                break;
            case 5:
                fav5.setOpacity(1);
                break;
            case 6:
                fav6.setOpacity(1);
                break;
        }

    }

    public void recibirCura(int x){
        switch (seleccion){
            case 1:
                pk1.setVidaActual(pk1.getVidaActual() + x);
                if (pk1.getVidaActual() > pk1.getVidaMaxima()) {
                    pk1.setVidaActual(pk1.getVidaMaxima());
                }
                psP1.setProgress((float) pk1.getVidaActual() / pk1.getVidaMaxima());
                System.out.println("pokemon uno ha sido curado " + x + " puntos");
                break;

            case 2:
                pk2.setVidaActual(pk2.getVidaActual() + x);
                if (pk2.getVidaActual() > pk2.getVidaMaxima()) {
                    pk2.setVidaActual(pk2.getVidaMaxima());
                }
                psP2.setProgress((float) pk2.getVidaActual() / pk2.getVidaMaxima());
                System.out.println("pokemon dos ha sido curado " + x + " puntos");
                break;
            case 3:
                pk3.setVidaActual(pk3.getVidaActual() + x);
                if (pk3.getVidaActual() > pk3.getVidaMaxima()) {
                    pk3.setVidaActual(pk3.getVidaMaxima());
                }
                psP3.setProgress((float) pk3.getVidaActual() / pk3.getVidaMaxima());
                System.out.println("pokemon tres ha sido curado " + x + " puntos");
                break;
            case 4:
                pk4.setVidaActual(pk4.getVidaActual() + x);
                if (pk4.getVidaActual() > pk4.getVidaMaxima()) {
                    pk4.setVidaActual(pk4.getVidaMaxima());
                }
                psP4.setProgress((float) pk4.getVidaActual() / pk4.getVidaMaxima());
                System.out.println("pokemon cuatro ha sido curado " + x + " puntos");
                break;
            case 5:
                pk5.setVidaActual(pk5.getVidaActual() + x);
                if (pk5.getVidaActual() > pk5.getVidaMaxima()) {
                    pk5.setVidaActual(pk5.getVidaMaxima());
                }
                psP5.setProgress((float) pk5.getVidaActual() / pk5.getVidaMaxima());
                System.out.println("pokemon cinco ha sido curado " + x + " puntos");
                break;
            case 6:
                pk6.setVidaActual(pk6.getVidaActual() + x);
                if (pk6.getVidaActual() > pk6.getVidaMaxima()) {
                    pk6.setVidaActual(pk6.getVidaMaxima());
                }
                psP6.setProgress((float) pk6.getVidaActual() / pk6.getVidaMaxima());
                System.out.println("pokemon seis ha sido curado " + x + " puntos");
                break;
        }
    }

    public void recibirInformacion(String info){
        System.out.println(info);
    }

    @FXML
    public void Bulbasaur(){
        vidaAMandar = pk1.getVidaMaxima();
        System.out.println("vida a mandar: " + vidaAMandar);
        seleccion = 1;
        button1.setText("Mochila");
        nombreP1.setTextFill(Color.BLUE);
        nombreP2.setTextFill(Color.BLACK);
        nombreP3.setTextFill(Color.BLACK);
        nombreP4.setTextFill(Color.BLACK);
        nombreP5.setTextFill(Color.BLACK);
        nombreP6.setTextFill(Color.BLACK);
        desc=1;
        detalles.cambiarDesc(1);


    }

    @FXML
    public void Squirtle(){
        vidaAMandar = pk2.getVidaMaxima();
        System.out.println("vida a mandar: " + vidaAMandar);
        seleccion = 2;
        button1.setText("Mochila");
        nombreP1.setTextFill(Color.BLACK);
        nombreP2.setTextFill(Color.BLUE);
        nombreP3.setTextFill(Color.BLACK);
        nombreP4.setTextFill(Color.BLACK);
        nombreP5.setTextFill(Color.BLACK);
        nombreP6.setTextFill(Color.BLACK);
        desc=2;
        detalles.cambiarDesc(2);
    }

    @FXML
    public void Charmander(){
        vidaAMandar = pk3.getVidaMaxima();
        System.out.println("vida a mandar: " + vidaAMandar);
        seleccion = 3;
        button1.setText("Mochila");
        nombreP1.setTextFill(Color.BLACK);
        nombreP2.setTextFill(Color.BLACK);
        nombreP3.setTextFill(Color.BLUE);
        nombreP4.setTextFill(Color.BLACK);
        nombreP5.setTextFill(Color.BLACK);
        nombreP6.setTextFill(Color.BLACK);
        desc=3;
        detalles.cambiarDesc(3);
    }

    @FXML
    public void Pikachu(){
        vidaAMandar = pk4.getVidaMaxima();
        System.out.println("vida a mandar: " + vidaAMandar);
        seleccion = 4;
        button1.setText("Mochila");
        nombreP1.setTextFill(Color.BLACK);
        nombreP2.setTextFill(Color.BLACK);
        nombreP3.setTextFill(Color.BLACK);
        nombreP4.setTextFill(Color.BLUE);
        nombreP5.setTextFill(Color.BLACK);
        nombreP6.setTextFill(Color.BLACK);
        desc=4;
        detalles.cambiarDesc(4);
    }

    @FXML
    public void Diglett(){
        vidaAMandar = pk5.getVidaMaxima();
        System.out.println("vida a mandar: " + vidaAMandar);
        seleccion = 5;
        button1.setText("Mochila");
        nombreP1.setTextFill(Color.BLACK);
        nombreP2.setTextFill(Color.BLACK);
        nombreP3.setTextFill(Color.BLACK);
        nombreP4.setTextFill(Color.BLACK);
        nombreP5.setTextFill(Color.BLUE);
        nombreP6.setTextFill(Color.BLACK);
        desc=5;
        detalles.cambiarDesc(5);
    }

    @FXML
    public void Articuno(){
        vidaAMandar = pk6.getVidaMaxima();
        System.out.println("vida a mandar: " + vidaAMandar);
        seleccion = 6;
        button1.setText("Mochila");
        nombreP1.setTextFill(Color.BLACK);
        nombreP2.setTextFill(Color.BLACK);
        nombreP3.setTextFill(Color.BLACK);
        nombreP4.setTextFill(Color.BLACK);
        nombreP5.setTextFill(Color.BLACK);
        nombreP6.setTextFill(Color.BLUE);
        desc=6;
        detalles.cambiarDesc(6);
    }

    //public void cambiarDesc(ActionEvent event){detalles.cambiarDesc();}


    private void showAlert(Alert alert) throws IOException {
        Optional<ButtonType> resultado = alert.showAndWait();
        if(resultado.isEmpty()) {
            System.out.println("Ha presionado la X");
        }else if (resultado.get() == ButtonType.FINISH) {
            Platform.exit();
        } else {
            System.out.println("Resultado = OTROS: " + resultado.get().getText());
        }
    }
}
