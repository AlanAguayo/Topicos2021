package sample.view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.models.CancionesDAO;


public class frmCancion extends Stage {
    private Scene escena;
    private VBox vBox;
    private TextField txtNombre, txtDuracion, txtPortada, txtAnio;
    private TextArea txaLetra;
    private Button btnGuardar;
    private CancionesDAO objCDAO;
    private TableView<CancionesDAO> tbvCanciones;

    public frmCancion(TableView<CancionesDAO> tbvCanciones, CancionesDAO objCDAO){
        this.tbvCanciones = tbvCanciones;
        if(objCDAO != null)
            this.objCDAO = objCDAO;

        else
            this.objCDAO = new CancionesDAO();

        CrearUI();
        this.setTitle("Gestion de Cancion");
        this.setScene(escena);
        this.show();
    }

    private void CrearUI() {
        vBox=new VBox();
        vBox.setSpacing(10.0);
        vBox.setPadding(new Insets(10.0));

        txtNombre = new TextField();
        txtNombre.setText(objCDAO.getNombre_cancion());
        txtNombre.setPromptText("Nombre de la cancion");
        txtDuracion=new TextField();
        txtDuracion.setText(String.valueOf(objCDAO.getDuracion()));
        txtDuracion.setPromptText("Duracion de la cancion");
        txtPortada=new TextField();
        txtPortada.setText(objCDAO.getPortada());
        txtPortada.setPromptText("Portada del disco");
        txtAnio=new TextField();
        txtAnio.setText(String.valueOf(objCDAO.getAnio()));
        txtAnio.setPromptText("Año del lanzamiento");
        txaLetra=new TextArea();
        txaLetra.setText(objCDAO.getLetra());
        txaLetra.setPromptText("Letra de la cancion");
        btnGuardar = new Button("Guardar");
        btnGuardar.setOnAction(event -> {
            objCDAO.setNombre_cancion(txtNombre.getText());
            objCDAO.setDuracion(Integer.parseInt(txtDuracion.getText()));
            objCDAO.setPortada(txtPortada.getText());
            objCDAO.setAnio(Integer.parseInt(txtAnio.getText()));
            objCDAO.setLetra(txaLetra.getText());

            if(objCDAO.getId_cancion()>0)
                objCDAO.UPDATE();
            else
                objCDAO.INSERT();

            tbvCanciones.setItems(objCDAO.SELECT());
            tbvCanciones.refresh();

            this.close();
        });
        vBox.getChildren().addAll(txtNombre,txtDuracion,txtPortada,txtAnio,txaLetra,btnGuardar);
        escena=new Scene(vBox,250,300);
    }

}
