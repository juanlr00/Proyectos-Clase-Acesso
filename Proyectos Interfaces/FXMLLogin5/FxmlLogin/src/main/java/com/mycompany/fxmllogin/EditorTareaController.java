/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.fxmllogin;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import models.Tarea;
import org.hibernate.Session;
import org.hibernate.Transaction;
/**
 * FXML Controller class
 *
 * @author FranciscoRomeroGuill
 */
public class EditorTareaController implements Initializable {


    @FXML
    private TextField txtNombre;
    @FXML
    private ChoiceBox<String> prioridad;
    @FXML
    private Button btnAceptar;
    @FXML
    private Label labelId;
    @FXML
    private Button btnBorrar;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        prioridad.getItems().addAll("Alta","Media","Baja");
        prioridad.getSelectionModel().selectFirst();
        
        Tarea t = SessionData.getTareaActual();
        if(t!=null){
            txtNombre.setText( t.getNombre() );
            prioridad.setValue( t.getPrioridad() );
            labelId.setText( t.getId() +"");
        }
    }    
    
    @FXML
    private void aceptar(ActionEvent event) {
        
        Tarea t = SessionData.getTareaActual();
        if(t!=null){                
            SessionData.getTareaActual().setNombre( txtNombre.getText() );
            SessionData.getTareaActual().setPrioridad( prioridad.getValue() );
        
            Session s = HibernateUtil.getSessionFactory().openSession();
            Transaction tr = s.beginTransaction();
            s.update(SessionData.getTareaActual() );
            tr.commit();
        }else{
            
            t = new Tarea();
            t.setNombre( txtNombre.getText() );
            t.setPrioridad( prioridad.getValue());
            t.setUsuario( SessionData.getUsuarioActual() );
            
            Session s = HibernateUtil.getSessionFactory().openSession();
            Transaction tr = s.beginTransaction();
            s.save(t);
            tr.commit();
        }
        
        try {
            App.setRoot("secondary");
        } catch (IOException ex) {
            Logger.getLogger(EditorTareaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void borrar(ActionEvent event) {
        
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction tr = s.beginTransaction();
        s.remove( SessionData.getTareaActual() );
        tr.commit();
        try {
            App.setRoot("secondary");
        } catch (IOException ex) {
            Logger.getLogger(EditorTareaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
