package sample.view;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;




public class Calculadora extends Stage implements EventHandler {
    
    private Scene escena;
    private TextField txtOperacion;
    private HBox[] hBoxes;
    private Button[] arBotones;
    private VBox vBox;
    private char[] arNumeros = {'7','8','9','/','4','5','6','*','1','2','3','+','0','.','=','-'};

    Float data = 0f;
    int operacion = -1;
    boolean bandera=true;

    
    public Calculadora() {
        CrearUI();
        
        this.setTitle("Calculadora");
        this.setScene(escena);
        this.show();
    }

    private void CrearUI() {
        vBox = new VBox();
        hBoxes = new HBox[4];
        arBotones = new Button [16];

        txtOperacion = new TextField();
        txtOperacion.setEditable(false);
        txtOperacion.setPrefHeight(50);
        txtOperacion.setPromptText("0");
        txtOperacion.setFocusTraversable(false);

        int pos=0;
        for(int i=0;i< hBoxes.length;i++){
            hBoxes[i]=new HBox();
            hBoxes[i].setSpacing(10);
            hBoxes[i].setPadding(new Insets(5));
            for (int j = 0; j < 4; j++) {
                arBotones[pos] = new Button(arNumeros[pos]+"");
                arBotones[pos].addEventHandler(MouseEvent.MOUSE_CLICKED,new EventoCalcu(arNumeros[pos]));
                /*arBotones[pos].addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {


                    //botones
                    @Override
                    public void handle(MouseEvent event) {

                        System.out.println("Tercer Evento");


                    }
                });*/
                arBotones[pos].setPrefSize(50,50);
                hBoxes[i].getChildren().add(arBotones[pos]);
                pos++;
            }
        }
        vBox.getChildren().addAll((txtOperacion),hBoxes[0],hBoxes[1],hBoxes[2],hBoxes[3]);
        vBox.setPadding(new Insets(8,5,5,5));

        for(int i=0;i< arBotones.length;i++){
            arBotones[i]=new Button();
        }



        escena = new Scene(vBox,250,250);
    }

    @Override
    public void handle(Event event) {
        System.out.println("Primer Evento");
    }

    class EventoCalcu implements EventHandler{

        char tecla;
        public EventoCalcu(char tecla){
            this.tecla=tecla;
        }

        @Override
        public void handle(Event event) {





                switch (tecla){

                    case '1':
                        if(bandera==false){
                            txtOperacion.setText("");
                            bandera=true;
                        }
                        txtOperacion.setText(txtOperacion.getText()+tecla+"");
                        break;
                    case '2':
                        if(bandera==false){
                            txtOperacion.setText("");
                            bandera=true;
                        }
                        txtOperacion.setText(txtOperacion.getText()+tecla+"");
                        break;
                    case '3':
                        if(bandera==false){
                            txtOperacion.setText("");
                            bandera=true;
                        }
                        txtOperacion.setText(txtOperacion.getText()+tecla+"");
                        break;
                    case '4':
                        if(bandera==false){
                            txtOperacion.setText("");
                            bandera=true;
                        }
                        txtOperacion.setText(txtOperacion.getText()+tecla+"");
                        break;
                    case '5':
                        if(bandera==false){
                            txtOperacion.setText("");
                            bandera=true;
                        }
                        txtOperacion.setText(txtOperacion.getText()+tecla+"");
                        break;
                    case '6':
                        if(bandera==false){
                            txtOperacion.setText("");
                            bandera=true;
                        }
                        txtOperacion.setText(txtOperacion.getText()+tecla+"");
                        break;
                    case '7':
                        if(bandera==false){
                            txtOperacion.setText("");
                            bandera=true;
                        }
                        txtOperacion.setText(txtOperacion.getText()+tecla+"");
                        break;
                    case '8':
                        if(bandera==false){
                            txtOperacion.setText("");
                            bandera=true;
                        }
                        txtOperacion.setText(txtOperacion.getText()+tecla+"");
                        break;
                    case '9':
                        if(bandera==false){
                            txtOperacion.setText("");
                            bandera=true;
                        }
                        txtOperacion.setText(txtOperacion.getText()+tecla+"");
                        break;
                    case '0':
                        if(bandera==false){
                            txtOperacion.setText("");
                            bandera=true;
                        }
                        txtOperacion.setText(txtOperacion.getText()+tecla+"");
                        break;
                    case '/':
                        data = Float.parseFloat(txtOperacion.getText());
                        operacion =4;
                        txtOperacion.setText("");
                        break;
                    case '*':
                        data = Float.parseFloat(txtOperacion.getText());
                        operacion =3;
                        txtOperacion.setText("");
                        break;
                    case '+':
                        data = Float.parseFloat(txtOperacion.getText());
                        operacion =1;
                        txtOperacion.setText("");
                        break;
                    case '-':
                        data = Float.parseFloat(txtOperacion.getText());
                        operacion =2;
                        txtOperacion.setText("");
                        break;
                    case '=':

                            Float secundaOp = Float.parseFloat(txtOperacion.getText());
                        switch (operacion){
                            case 1:
                                Float ans=data+secundaOp;
                                txtOperacion.setText(String.valueOf(ans));
                                break;
                            case 2:
                                ans=data-secundaOp;
                                txtOperacion.setText(String.valueOf(ans));
                                break;
                            case 3:
                                ans=data*secundaOp;
                                txtOperacion.setText(String.valueOf(ans));
                                break;
                                case 4:
                                ans=data/secundaOp;
                                txtOperacion.setText(String.valueOf(ans));
                                    break;

                        }
                        bandera=false;

                        break;
                    case '.':
                        if(bandera==false){
                            txtOperacion.setText("");
                            bandera=true;
                        }
                        if(txtOperacion.getText().contains(".")){

                        }else{
                            txtOperacion.setText(txtOperacion.getText()+tecla+"");
                            break;
                        }

                }









        }
    }
    
}
