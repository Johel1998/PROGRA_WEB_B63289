/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Loguearse;

/**
 *
 * @author JOHEL
 */
public class Loguearse {
    public boolean registroValido(String... informacionUsuario) {
        for (String informacionUsuario1 : informacionUsuario) {
            if (informacionUsuario1.equals("")) {
                return false;
            }
        }
        return true;
    }
}
