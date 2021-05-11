package sample.components;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableCell;
import sample.models.CancionesDAO;
import sample.view.frmCancion;

import java.util.Optional;


public class CellCustome extends TableCell<CancionesDAO, String> {
    private Button btnCelda;
    private CancionesDAO objCDAO;

    public CellCustome(int opc){

        if(opc==1) {
            btnCelda = new Button("Editar");
            btnCelda.setOnAction(event -> {
                objCDAO = CellCustome.this.getTableView().getItems().get(CellCustome.this.getIndex());
                new frmCancion(CellCustome.this.getTableView(),objCDAO);
            });
        }
        else {
            btnCelda = new Button("Borrar");
            btnCelda.setOnAction(event -> {
                Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
                alerta.setTitle("Mensaje del Sistema :)");
                alerta.setHeaderText("Confirmacion de la accion");
                alerta.setContentText("Realmente deseas borrar el registro?");
                Optional<ButtonType> result = alerta.showAndWait();
                if (result.get() == ButtonType.OK) {
                    objCDAO = CellCustome.this.getTableView().getItems().get(CellCustome.this.getIndex());
                    objCDAO.DELETE();

                    CellCustome.this.getTableView().setItems(objCDAO.SELECT());
                    CellCustome.this.getTableView().refresh();
                }
            });
        }
    }

    @Override
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);
        if( !empty)
            setGraphic(btnCelda);
    }
}
