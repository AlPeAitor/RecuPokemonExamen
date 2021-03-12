package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class Detalles {

    //cogido del de mochila, por eso tiene vida como dato residual, si me da tiempo lo cambio

    //no esta lo de cambiar imagen segun el seleccionado por falta de tiempo, pero seria mandar la imagen segun el pokemon sleccionado
    // (la imagen no pertenece a la clase pokemon, entonces no puede hacer asi)
    //y despues hacer que la imageview de la pantalla de detalles muestre dicha imagen

    int vida = 0;
    int desc = 0;

    String descP1="Hola, soy Bulbasaur";
    String descP2="Hola, soy Squirtle";
    String descP3="Hola, soy Charmander";
    String descP4="Hola, soy Pikachu";
    String descP5="Hola, soy Diglett";
    String descP6="Hola, soy Articuno";



    @FXML
    public Label label1;

    private Controller principal;

    public void cambiarDesc(int x){
        switch(desc){
            case 1:
                label1.setText(descP1);
                break;
            case 2:
                label1.setText(descP2);
                break;
            case 3:
                label1.setText(descP3);
                break;
            case 4:
                label1.setText(descP4);
                break;
            case 5:
                label1.setText(descP5);
                break;
            case 6:
                label1.setText(descP6);
                break;
        }
    }

    public void marcarFav(ActionEvent event){ principal.marcarFav(); }

    public void mandarInfoDesdeVentana1(int x, int y){
        this.vida = x;
        this.desc =y;

    }

    public void setVentana1(Controller ventana1){
        principal = ventana1;
        principal.recibirInformacion("Ejecutada escena de detalles");
        principal.recibirInformacion("vida mandada: " + vida);
        principal.recibirInformacion("desc mandada: " + desc);

    }
}
