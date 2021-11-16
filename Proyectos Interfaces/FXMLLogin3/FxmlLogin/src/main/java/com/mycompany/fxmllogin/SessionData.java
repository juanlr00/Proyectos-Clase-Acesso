/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fxmllogin;

import models.Usuario;

/**
 *
 * @author FranciscoRomeroGuill
 */
public class SessionData {
    
    private static Usuario usuarioActual;

    public static Usuario getUsuarioActual() {
        return usuarioActual;
    }

    public static void setUsuarioActual(Usuario usuario_actual) {
        SessionData.usuarioActual = usuario_actual;
    }    
}
