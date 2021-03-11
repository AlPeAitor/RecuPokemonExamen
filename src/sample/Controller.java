package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class Controller {

    int vidaAMandar = 0;
    static int seleccion = 0;


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

/*
    //pokemon4

    @FXML
    public Label nombreP4;

    @FXML
    public Label nvP4;

    @FXML
    public Label vidaNumerica4;

    @FXML
    public ProgressBar psP4;

    //pokemon3

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
    public ProgressBar psP6;*/

    @FXML
    public Button button1;


    private final Pokemon pk1 = new Pokemon("Bulbasaur", 200, 21);
    private final Pokemon pk2 = new Pokemon("Squirtle", 250, 30);
    private final Pokemon pk3 = new Pokemon("Charmander", 300, 40);
    private final Pokemon pk4 = new Pokemon("Pikachu", 350, 50);
    private final Pokemon pk5 = new Pokemon("Digglet", 325, 42);
    private final Pokemon pk6 = new Pokemon("Articuno", 500, 70);
   /* public void setNombreP1(Label nombreP1) {
        this.nombreP1 = nombreP1;
    }*/

    @FXML
    public void initialize(){
        datosPokemon(nombreP1, nvP1, vidaNumerica, pk1);
        psP1.setProgress((float)pk1.getVidaActual()/pk1.getVidaMaxima());

        datosPokemon(nombreP2, nvP2, vidaNumerica2, pk2);
        psP2.setProgress((float)pk2.getVidaActual()/pk2.getVidaMaxima());

        datosPokemon(nombreP3, nvP3, vidaNumerica3, pk3);
        psP3.setProgress((float)pk3.getVidaActual()/pk3.getVidaMaxima());
/*
        datosPokemon(nombreP4, nvP4, vidaNumerica4, pk4);
        psP4.setProgress((float)pk4.getVidaActual()/pk4.getVidaMaxima());

        datosPokemon(nombreP5, nvP5, vidaNumerica5, pk5);
        psP5.setProgress((float)pk5.getVidaActual()/pk5.getVidaMaxima());

        datosPokemon(nombreP6, nvP6, vidaNumerica6, pk6);
        psP6.setProgress((float)pk6.getVidaActual()/pk6.getVidaMaxima());*/

        //vidaNumerica= pk.getVidaActual()+"/"+pk.getVidaMaxima()
    }

    public void datosPokemon(Label nombre, Label nivel, Label vida, Pokemon pk){
        nombre.setText(pk.getNombre());
        nivel.setText("Nv. " + pk.getNivel());
        //vida.setText(pk.getVidaActual()+"/"+pk.getVidaMaxima());
    }

    @FXML
    private void onButtonAction(ActionEvent event){

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
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void recibirCura(int x){
        switch (seleccion){
            case 1:
                pk1.setVidaActual(pk1.getVidaActual() + x);
                if (pk1.getVidaActual() > pk1.getVidaMaxima()) {
                    pk1.setVidaActual(pk1.getVidaMaxima());
                }
                //auxVida1.setText(pk1.getVidaActual()+"/"+pk1.getVidaMaxima());
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
        }
    }

    public void recibirInformacion(String info){
        System.out.println(info);
    }

    @FXML
    public void Bulbasaur(){
        vidaAMandar = pk1.getVidaActual();
        System.out.println("vida a mandar: " + vidaAMandar);
        seleccion = 1;
    }

    @FXML
    public void Squirtle(){
        vidaAMandar = pk2.getVidaActual();
        System.out.println("vida a mandar: " + vidaAMandar);
        seleccion = 2;
    }

    @FXML
    public void Charmander(){
        vidaAMandar = pk3.getVidaActual();
        System.out.println("vida a mandar: " + vidaAMandar);
        seleccion = 3;
    }
}
