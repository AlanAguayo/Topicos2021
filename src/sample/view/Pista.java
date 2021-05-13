package sample.view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.components.Corredor;

public class Pista extends Stage {

    Scene escena;
    private VBox vBox;
    private ProgressBar[] carriles;
    private Corredor[] corredores;
    private String [] nomCorredores = {"Homero","Flash","Quick Silver","Bob Esponja","Shrek"};

    public Pista(){
        CrearUI();
        this.setTitle("Pista de atletismo :)");
        this.setScene(escena);
        this.show();
    }

    private void CrearUI() {
        vBox = new VBox();
        vBox.setSpacing(10.0);
        vBox.setPadding(new Insets(10.0));
        carriles = new ProgressBar[5];
        corredores = new Corredor[5];
        for(int i = 0;i<carriles.length;i++){
            carriles[i]=new ProgressBar(0);
            carriles[i].setPrefWidth(180.0);
            corredores[i]= new Corredor(nomCorredores[i], carriles[i]);
            corredores[i].start();
            vBox.getChildren().add(carriles[i]);
        }
        escena = new Scene(vBox,200,300);
    }
}
