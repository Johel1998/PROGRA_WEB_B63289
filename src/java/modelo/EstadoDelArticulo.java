package modelo;

/**
 *
 * @author Ana Elena
 */
public class EstadoDelArticulo {
    private String descripcion = "pendiente";

    public EstadoDelArticulo() {
        descripcion = "pendiente";
    }
    
    
    public void pasarEstado (String estado){
        descripcion = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
