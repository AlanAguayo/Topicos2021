package sample.view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.plaf.ToolBarUI;

public class Encriptador extends Stage {

    private Scene escena;
private HBox hBox;
private VBox vBox;
private ToolBar tolMenu;
private TextArea txtSalida;
private TextArea txtEntrada;
private Button btnEncriptar;

    public Encriptador(){
        
        CrearUI();
        
        this.setTitle("Funcion de encriptacion con HASH");
        this.setScene(escena);
        this.show();
    }

    private void CrearUI() {
        vBox = new VBox();
        tolMenu = new ToolBar();
        hBox = new HBox();
        txtSalida = new TextArea();
        txtEntrada = new TextArea();
        hBox.getChildren().addAll(txtEntrada,txtSalida);
        btnEncriptar = new Button();
        vBox.getChildren().addAll(tolMenu,hBox,btnEncriptar);

        escena = new Scene(vBox,260,400);

    }

}
