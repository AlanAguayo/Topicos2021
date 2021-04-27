package sample.view;

import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.models.CancionesDAO;
import javafx.scene.control.TableView;

public class FrmCanciones extends Stage {
    private TableView<CancionesDAO> tbvCanciones;
    private Scene escena;

    public FrmCanciones(){
        CrearUI();
        this.setTitle("Gestion de canciones");
        this.setScene(escena);
        this.show();
    }

    private void CrearUI(){
        tbvCanciones = new TableView<>();
        escena = new Scene(tbvCanciones,300,250);
    }
}
