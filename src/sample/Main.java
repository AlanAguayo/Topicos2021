package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        CrearUI();
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Proyecto TAP");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }


    private void CrearUI(){

        Button btn1,btn2,btn3;
        VBox vBox;
        HBox hBox;

        btn1=new Button("Boton 1");

        btn2=new Button("Boton 2");
        btn3=new Button("Boton 3");

        hBox = new HBox();
        vBox = new VBox();

        hBox.getChildren().addAll(btn1,btn2,btn3);
        hBox.setSpacing(10);
        hBox.setPadding(new Insets(20,20,20,20));

        vBox.getChildren().addAll();
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(20,20,20,20));
    }

}
