package com.mycompany.fxmllogin;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import models.Tarea;
import models.Usuario;

public class SecondaryController implements Initializable{

    @FXML
    private Label label1;
    @FXML
    private TableView<Tarea> tabla;
    @FXML
    private TableColumn<Tarea, Long> colId;
    @FXML
    private TableColumn<Tarea, String> colTarea;
    @FXML
    private TableColumn<Tarea, String> colPrioridad;
    @FXML
    private Label label2;
    @FXML
    private Button btnSalir;

    @FXML
    private void switchToPrimary() throws IOException {
        SessionData.setUsuarioActual(null);
        App.setRoot("primary");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        ObservableList<Tarea> contenido = FXCollections.observableArrayList();
        tabla.setItems(contenido);
        
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colTarea.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colPrioridad.setCellValueFactory(new PropertyValueFactory<>("prioridad"));
         
        //contenido.add( new Tarea(0L,"Hacer cosas","alta", new Usuario() ));
        
        Usuario u = SessionData.getUsuarioActual();

        contenido.addAll( u.getTareas() );
        
        label1.setText( u.getUsername() + " " + u.getEmail());
        label2.setText( u.getTareas().size() + " tareas");
    }

    @FXML
    private void seleccionar(MouseEvent event) {
       Tarea t = tabla.getSelectionModel().getSelectedItem();
       if(t!=null){
           Alert alert = new Alert(Alert.AlertType.INFORMATION);
           alert.setHeaderText( t.getNombre() );
           alert.setContentText( t.getPrioridad());
           alert.showAndWait();
       }
    }

}