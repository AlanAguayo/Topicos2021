package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.awt.*;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        CrearUI(primaryStage);


    }


    public static void main(String[] args) {
        launch(args);
    }


    private void CrearUI(Stage primaryStage){

        //Parte 1 hbox,vbox
        Button btn1,btn2,btn3;

        btn1=new Button("Boton 1");
        btn2=new Button("Boton 2");
        btn3=new Button("Boton 3");

        HBox hBox = new HBox();

        hBox.getChildren().addAll(btn1,btn2,btn3);
        hBox.setSpacing(10);
        hBox.setPadding(new Insets(20));

        Scene scene = new Scene(hBox,400,70);

        /*

        VBox vBox = new VBox();
        vBox.getChildren().addAll(btn1,btn2,btn3);
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(20,20,20,20));





        Scene scene = new Scene(vBox,400,70);



        //Parte 2 flowpane
        FlowPane flow = new FlowPane(Orientation.VERTICAL);
        flow.getChildren().addAll(btn1,btn2,btn3);

        Scene scene= new Scene(flow,400,70);

        //Parte 3 gridpane
        GridPane grid = new GridPane();
        grid.add(new Button("Posicion 0, 0"), 0, 0);
        grid.add(new Button("Posicion 1, 0"), 1, 0);
        grid.add(new Button("Posicion 0, 1"), 0, 1);
        grid.add(new Button("Posicion 1, 1"), 1, 1);
        grid.add(new Button("Posicion 0, 2"), 0, 2);
        grid.add(new Button("Posicion 1, 2"), 1, 2);
        grid.add(new Button("Posicion Col 2 Fila 0"), 2, 2);
        Scene scene=new Scene(grid);

        //Parte 4 anchorpane
        AnchorPane anchor = new AnchorPane();

        AnchorPane.setTopAnchor(btn1,15.0);
        AnchorPane.setRightAnchor(btn1,15.0);
        AnchorPane.setBottomAnchor(btn2,30.0);
        AnchorPane.setLeftAnchor(btn2,100.0);

        anchor.getChildren().addAll(btn1,btn2,btn3);

       Scene scene=new Scene(anchor);

        //Parte 5 stackpane
        StackPane stack = new StackPane();
        stack.getChildren().addAll(btn1,btn2,btn3);
        Scene scene =new Scene(stack);

        //Parte 6 titlepane
        TilePane tile = new TilePane();
        tile.setHgap(8);
        tile.setPrefColumns(4);
        tile.getChildren().addAll(btn1,btn2,btn3);
        Scene scene = new Scene(tile);

        */

        //Parte 7 color y tamaño

        btn1.setMaxWidth(100);
        btn1.setMaxHeight(200);

        btn1.setStyle("-fx-background-color: #00ff00");



        primaryStage.setTitle("Proyecto TAP");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

}
