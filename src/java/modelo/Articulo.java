package modelo;

import java.awt.Image;

/**
 * Esta clase representa un articulo
 * @author Johel Guzman Soto, Ana Elena Morales Venegas, Keylor Arias
 * @version 08/07/19
 */
public class Articulo {
    private String propietarioDelArticulo;
    private String nombreArticulo;
    private int codigo;
    private int precio;
    private boolean enTrueque;

    public Articulo() {
    }

    public Articulo(String propietario, String nombreArticulo, int precio) {
        this.propietarioDelArticulo = propietario;
        this.nombreArticulo = nombreArticulo;
        this.precio = precio;
        this.enTrueque = false;
    }
    
    public String getDuenoDelArticulo() {
        return propietarioDelArticulo;
    }

    public void setDuenoDelArticulo(String nickUsuarioP) {
        this.propietarioDelArticulo = nickUsuarioP;
    }

    public boolean isEnTrueque() {
        return enTrueque;
    }

    public void setEnTrueque(boolean enTrueque) {
        this.enTrueque = enTrueque;
    }

    public String getNombreArticulo() {
        return nombreArticulo;
    }

    public void setNombreArticulo(String nombreArticulo) {
        this.nombreArticulo = nombreArticulo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Articulo{" + "duenoDelArticulo=" + propietarioDelArticulo + ", nombreArticulo=" + nombreArticulo + ", codigo=" + codigo + ", precio=" + precio + ", enTrueque=" + enTrueque + '}';
    }
}
