package modelo;

/**
 *
 * @author JOHEL
 */
public class Trueque {
    private String nombreDelOfertante;
    private String nombreDelRecibidor;
    private Articulo enviarArticulo;
    private Articulo recibirArticulo;
    private int codigoTrueque;
    private EstadoDelArticulo estado;

    public Trueque() {
    }

    public Trueque(String nombreDelOfertante, String nombreDelRecibidor, Articulo enviarArticulo, Articulo recibirArticulo) {
        this.nombreDelOfertante = nombreDelOfertante;
        this.nombreDelRecibidor = nombreDelRecibidor;
        this.enviarArticulo = enviarArticulo;
        this.recibirArticulo = recibirArticulo;
        estado =  new EstadoDelArticulo();
    }
    
    public int getCodigoTrueque() {
        return codigoTrueque;
    }

    public void setCodigoTrueque(int codigoTrueque) {
        this.codigoTrueque = codigoTrueque;
    }

    public EstadoDelArticulo getEstado() {
        return estado;
    }

    public void setEstado(EstadoDelArticulo estado) {
        this.estado = estado;
    }

    public String getNombreDelOfertante() {
        return nombreDelOfertante;
    }

    public void setNombreDelOfertante(String nombreDelOfertante) {
        this.nombreDelOfertante = nombreDelOfertante;
    }

    public String getNombreDelRecibidor() {
        return nombreDelRecibidor;
    }

    public void setNombreDelRecibidor(String nombreDelRecibidor) {
        this.nombreDelRecibidor = nombreDelRecibidor;
    }

    public Articulo getEnviarArticulo() {
        return enviarArticulo;
    }

    public void setEnviarArticulo(Articulo enviarArticulo) {
        this.enviarArticulo = enviarArticulo;
    }

    public Articulo getRecibirArticulo() {
        return recibirArticulo;
    }

    public void setRecibirArticulo(Articulo recibirArticulo) {
        this.recibirArticulo = recibirArticulo;
    }
}
