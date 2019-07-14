package modelo;

/**
 * Esta clase sirve para cambiar y ver los estados de los articulos
 * @author Johel Guzman Soto, Ana Elena Morales Venegas, Keylor Arias
 * @version 09/07/19
 */
public class EstadoDelArticulo {
    private String descripcion = "pendiente";

    public EstadoDelArticulo() {
        descripcion = "pendiente";
    }
    
    /**
     * Este metodo sirve para poner un nuevo estado al articulo
     * @param estado el nuevo estado al que se quiere pasar
     */
    public void pasarEstado (String estado){
        descripcion = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
