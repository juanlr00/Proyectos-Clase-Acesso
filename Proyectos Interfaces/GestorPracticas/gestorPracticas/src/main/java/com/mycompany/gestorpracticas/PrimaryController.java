package com.mycompany.gestorpracticas;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.SpinnerValueFactory.DoubleSpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Actividad;

public class PrimaryController implements Initializable{

    @FXML
    private TextField txtActividad;
    @FXML
    private Spinner<Double> duracion;
    @FXML
    private DatePicker fecha;
    @FXML
    private Button btnAñadir;
    @FXML
    private TableView<Actividad> tabla;
    @FXML
    private TableColumn<Actividad, Long> cId;
    @FXML
    private TableColumn<Actividad, String> cActividad;
    @FXML
    private TableColumn<Actividad, Double> cDuracion;
    @FXML
    private TableColumn<Actividad, Date> cFecha;

    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    @FXML
    private void añadirActividad(ActionEvent event) {
        Actividad a = new Actividad();
        a.setId(0L);
        a.setNombre( txtActividad.getText() );
        a.setDuracion( duracion.getValue() );
        
        LocalDate localDate = fecha.getValue();
        Date fechaConvertida = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        
        a.setFecha( fechaConvertida );
        
        tabla.getItems().add(a);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        SpinnerValueFactory svf = new DoubleSpinnerValueFactory(0,8,1,0.5);
        duracion.setValueFactory(svf);

       // cFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));       
       // cActividad.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        cId.setCellValueFactory(new PropertyValueFactory<>("id"));
        cDuracion.setCellValueFactory(new PropertyValueFactory<>("duracion"));
        
    }
}
