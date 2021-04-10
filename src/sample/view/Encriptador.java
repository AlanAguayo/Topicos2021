package sample.view;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToolBar;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.swing.*;
import javax.swing.plaf.ToolBarUI;
import java.io.*;

public class Encriptador extends Stage implements EventHandler<KeyEvent> {

    private Scene escena;
    private HBox hBox;
    private VBox vBox;
    private ToolBar tolMenu;
    private TextArea txtSalida;
    private TextArea txtEntrada;
    private Button btnEncriptar;
    private Button btnTolAbrir;
    private FileChooser fileChooser;
    private char array[];

    public Encriptador() {
        CrearUI();

        this.setTitle("Funcion de encriptacion con HASH");
        this.setScene(escena);
        this.show();
    }

    private void CrearUI() {
        vBox = new VBox();
        tolMenu = new ToolBar();
        btnTolAbrir = new Button();
        ImageView imv = new ImageView("sample/assets/Open.png");
        imv.setFitHeight(35);
        imv.setPreserveRatio(true);
        btnTolAbrir.setGraphic(imv);
        btnTolAbrir.setOnAction(event -> abrirArchivo());
        tolMenu.getItems().add(btnTolAbrir);

        hBox = new HBox();
        txtEntrada = new TextArea();
        txtEntrada.setOnKeyPressed(this);


        txtSalida = new TextArea();
        txtSalida.setEditable(false);

        hBox.getChildren().addAll(txtEntrada, txtSalida);
        btnEncriptar = new Button("Encriptar Entrada");
        btnEncriptar.setOnAction(event -> encriptarEntrada());
        vBox.getChildren().addAll(tolMenu, hBox, btnEncriptar);



        escena = new Scene(vBox, 600, 300);

    }

    private void encriptarEntrada() {

        fileChooser=new FileChooser();
        fileChooser.setTitle("Encriptar");
        File file = fileChooser.showSaveDialog(this);

        if(file!=null){

            char array[];
            array=txtEntrada.getText().toCharArray();

            for(int i = 0;i<array.length;i++){
                array[i]=(char)(array[i]+(char)6);
            }


            guardarTexto(String.valueOf(array),file);
        }
    }

    private void abrirArchivo() {
        fileChooser = new FileChooser();
        fileChooser.setTitle("Buscar archivo a encriptar");
        File file = fileChooser.showSaveDialog(this);

        if(file!=null){
            FileReader fr = null;
            BufferedReader br = null;
            String texto = "";
            try {
                fr = new FileReader(file);
                br = new BufferedReader(fr);
                String st = br.readLine();
                while (st != null) {
                    texto = texto + st + "\n";
                    st = br.readLine();
                }
            } catch (Exception e) {
                txtSalida.appendText(e.toString());
                txtEntrada.appendText(e.toString());
            } finally {
                try {
                    fr.close();
                } catch (Exception e2) {
                    txtSalida.appendText(e2.toString());
                    txtEntrada.appendText(e2.toString());
                }
            }
            txtSalida.appendText(texto);


            array=texto.toCharArray();

            for(int i =0; i<array.length;i++){

                array[i]=(char)(array[i]-(char) 6);
            }

            txtEntrada.setText(String.valueOf(array));


        }

        }


    @Override
    public void handle(KeyEvent event) {

        array=event.getText().toCharArray();



        if(event.getCode().ordinal()==1) {
            txtSalida.setText(txtSalida.getText().substring(0,txtSalida.getText().length()-1));
        }




        for(int i =0; i<array.length;i++){

            array[i]=(char)(array[i]+(char) 6);
        }

        txtSalida.appendText(String.valueOf(array));


        /*txtSalida.appendText(event.getCode().ordinal()+"");
        switch(event.getCode().toString()){
            case "A":
                txtSalida.appendText("A");
                break;
            case "B":
                txtSalida.appendText("B");
                break;
                */

        }


    private void guardarTexto(String content, File file) {
        try {
            PrintWriter writer;
            writer = new PrintWriter(file);
            writer.println(content);
            writer.close();
        } catch (IOException ex) {
        }
        }
    }