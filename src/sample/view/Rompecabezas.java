package sample.view;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import javax.swing.*;


public class Rompecabezas extends Stage implements EventHandler {

    private String arImagenes2[] = {"2x2fila-1-col-1.jpg", "2x2fila-1-col-2.jpg", "2x2fila-2-col-1.jpg", "2x2fila-2-col-2.jpg"};
    private String arImagenes3[] = {"3x3fila-1-col-1.jpg", "3x3fila-1-col-2.jpg", "3x3fila-1-col-3.jpg", "3x3fila-2-col-1.jpg", "3x3fila-2-col-2.jpg", "3x3fila-2-col-3.jpg", "3x3fila-3-col-1.jpg", "3x3fila-3-col-2.jpg", "3x3fila-3-col-3.jpg"};
    private String arImagenes4[] = {"4x4fila-1-col-1.jpg", "4x4fila-1-col-2.jpg", "4x4fila-1-col-3.jpg", "4x4fila-1-col-4.jpg", "4x4fila-2-col-1.jpg", "4x4fila-2-col-2.jpg", "4x4fila-2-col-3.jpg", "4x4fila-2-col-4.jpg", "4x4fila-3-col-1.jpg", "4x4fila-3-col-2.jpg", "4x4fila-3-col-3.jpg", "4x4fila-3-col-4.jpg", "4x4fila-4-col-1.jpg", "4x4fila-4-col-2.jpg", "4x4fila-4-col-3.jpg", "4x4fila-4-col-4.jpg"};
    private String arImagenes[];
    private String arImagenesAux[];

    private String arAsignacion[][];

    private BorderPane borderPane;
    private GridPane tablero;
    private Button[][] btnTarjetas;
    private HBox hBox;
    private Label lblTarjetas;
    private TextField txtTarjetas;
    private Button btnMezclar;
    private Scene escena;
    private int noPiezas;
    private boolean bandera = false; //Cartas que llevas de intercambio
    private int xTemp, yTemp = 0;

    public Rompecabezas() {
        CrearUI();
        this.setTitle("Rompecabezas");
        this.setScene(escena);
        this.show();
    }

    private void CrearUI() {
        borderPane = new BorderPane();

        lblTarjetas = new Label("Cantidad de piezas");
        txtTarjetas = new TextField();
        btnMezclar = new Button("Mezclar Tarjetas");
        btnMezclar.addEventHandler(MouseEvent.MOUSE_CLICKED, this);
        hBox = new HBox();
        hBox.getChildren().addAll(lblTarjetas, txtTarjetas, btnMezclar);

        borderPane.setTop(hBox);

        tablero = new GridPane();
        borderPane.setCenter(tablero);

        escena = new Scene(borderPane, 800, 600);

    }

    @Override
    public void handle(Event event) {
        noPiezas = Integer.parseInt(txtTarjetas.getText());
        btnTarjetas = new Button[noPiezas][noPiezas];
        arAsignacion = new String[noPiezas][noPiezas];

        switch (noPiezas) {
            case 2:
                arImagenes = arImagenes2;
                arImagenesAux = new String[arImagenes2.length];
                break;
            case 3:
                arImagenes = arImagenes3;
                arImagenesAux = new String[arImagenes3.length];
                break;
            case 4:
                arImagenes = arImagenes4;
                arImagenesAux = new String[arImagenes4.length];
                break;
            default:
                JOptionPane.showMessageDialog(null, "No hay rompecabezas de ese tamaño");
                break;
        }
        revolver();

        for (int i = 0; i < noPiezas; i++) {
            for (int j = 0; j < noPiezas; j++) {

                Image img = new Image("sample/assets/Rompecabezas/" + arAsignacion[i][j]);

                ImageView imv = new ImageView(img);
                imv.setFitHeight(145);
                imv.setPreserveRatio(true);

                btnTarjetas[i][j] = new Button();
                int finalj = j;
                int finali = i;
                btnTarjetas[i][j].setGraphic(imv);
                btnTarjetas[i][j].setOnAction(event1 -> intercambio(finali, finalj));


                tablero.add(btnTarjetas[i][j], j, i);



            }
        }

    }

    private void intercambio(int i, int j) {
        if (!bandera) {
            bandera = !bandera;
            xTemp = i;
            yTemp = j;
        } else {


            Image img = new Image("sample/assets/Rompecabezas/" + arAsignacion[i][j]);
            ImageView imv = new ImageView(img);
            imv.setFitHeight(145);
            imv.setPreserveRatio(true);


            Image img2 = new Image("sample/assets/Rompecabezas/" + arAsignacion[xTemp][yTemp]);
            ImageView imv2 = new ImageView(img2);
            imv2.setFitHeight(145);
            imv2.setPreserveRatio(true);


            btnTarjetas[xTemp][yTemp].setGraphic(imv);
            btnTarjetas[i][j].setGraphic(imv2);

            String asignacionTemp = arAsignacion[i][j];
            arAsignacion[i][j] = arAsignacion[xTemp][yTemp];
            arAsignacion[xTemp][yTemp] = asignacionTemp;

            bandera = !bandera;

        }
        comprobacion();
    }

    private void revolver() {


        for (int i = 0; i < noPiezas; i++) {
            for (int j = 0; j < noPiezas; j++) {
                arAsignacion[i][j] = new String();
            }
        }
        int posx, posy = 0;
        for (int i = 0; i < arImagenes.length; ) {
            posx = (int) (Math.random() * noPiezas);
            posy = (int) (Math.random() * noPiezas);

            if (arAsignacion[posx][posy].equals("")) {
                arAsignacion[posx][posy] = arImagenes[i];
                i++;
            }

        }

    }

    private void comprobacion() {
        boolean comp = true;


        int cont = 0;
        for (int i = 0; i < noPiezas; i++) {
            for (int j = 0; j < noPiezas; j++) {

                arImagenesAux[cont] = arAsignacion[i][j];

                cont++;

            }
        }

        int i = 0;


        while (comp == true && i < arImagenes.length) {
            for (i = 0; i < arImagenes.length; i++) {

                if (!arImagenesAux[i].equals(arImagenes[i])) {

                    comp = false;
                }
            }
        }


        if (comp) {
            //JOptionPane.showMessageDialog(null, "Termino el rompecabezas. Felicidades!!!");
            Alert alerta=new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Mensaje del Sistema");
            alerta.setHeaderText("Lograste completar el rompecabezas!!");
            alerta.setContentText("Vuelva Pronto :D");
            alerta.showAndWait();
        }


    }
}
