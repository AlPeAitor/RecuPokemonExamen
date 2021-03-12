package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Mochila {

    private Controller principal;
    private int vida;

    @FXML
    public Label label1;

    @FXML
    public Button button1;

    @FXML
    public ImageView pocion1;


    public void curacion1(ActionEvent event){ principal.recibirCura(10); }

    public void curacion2(ActionEvent event){
        principal.recibirCura(20);
    }

    public void curacion3(ActionEvent event){ principal.recibirCura((int)(vida*0.1)); }

    public void curacion4(ActionEvent event){
        principal.recibirCura((int)(vida*0.2));
    }

    public void mandarInfoDesdeVentana1(int x){
        this.vida = x;
    }

    public void setVentana1(Controller ventana1){
        principal = ventana1;
        principal.recibirInformacion("Ejecutada escena de mochila");
        principal.recibirInformacion("vida mandada: " + vida);
    }
}
