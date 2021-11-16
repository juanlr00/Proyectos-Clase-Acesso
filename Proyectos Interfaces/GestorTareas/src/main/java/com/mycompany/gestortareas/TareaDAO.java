/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gestortareas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Tarea;

/**
 *
 * @author FranciscoRomeroGuill
 */
public class TareaDAO {

    private Connection con;

    private final String url = "jdbc:mysql://localhost:3306/acceso?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private final String user = "root";
    private final String password = "";

    /* Consultas SQL */
    private final String listAllQuery = "SELECT * FROM tarea";
    private final String addQuery = 
            "INSERT INTO tarea (nombre, prioridad, responsable) " +
            "VALUES ( ?, ?, ?)";  
    
    public TareaDAO() {
        try {
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            Logger.getLogger(TareaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Tarea> listAll() {

        ArrayList<Tarea> salida = new ArrayList<Tarea>();

        try( Statement st = con.createStatement() ){
            
            ResultSet resultado = st.executeQuery(listAllQuery);
            
            while (resultado.next()) {
                Tarea t = new Tarea();
                t.setId( resultado.getInt("id") );
                t.setNombre( resultado.getString("nombre") );
                t.setResponsable( resultado.getString("responsable") );
                t.setPrioridad( resultado.getString("prioridad") );
                
                salida.add(t);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(TareaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return salida;
    }
    

    public Boolean add(Tarea t) {

        Boolean salida = false;
        
        try( PreparedStatement pst = con.prepareStatement(addQuery) ){
        
            pst.setString(1, t.getNombre() );
            pst.setString(2, t.getPrioridad());
            pst.setString(3, t.getResponsable());
        
            salida = (pst.executeUpdate()==1);
            
        }   catch (SQLException ex) {
            Logger.getLogger(TareaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return salida;
    }

}
