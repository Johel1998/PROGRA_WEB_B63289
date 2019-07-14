package modelo;

/**
 * Esta clase representa un usuario
 * @author Johel Guzman Soto, Ana Elena Morales Venegas, Keylor Arias
 * @version 08/07/19
 */
public class Usuario {
    private String nombre;
    private String apellido;
    private String password;
    private String cedula;
    private String email;
    private String provincia;
    private String canton;
    private String distrito;

    public Usuario() {
    }

    public Usuario(String nombre, String apellido, String password, String cedula, String email, String provincia, String canton, String distrito) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.password = password;
        this.cedula = cedula;
        this.email = email;
        this.provincia = provincia;
        this.canton = canton;
        this.distrito = distrito;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nombre=" + nombre + ", apellido=" + apellido + ", password=" + password + ", cedula=" + cedula + ", email=" + email + ", provincia=" + provincia + ", canton=" + canton + ", distrito=" + distrito + '}';
    }
    
    public void reiniciarUsuario(){
        nombre = "";
        apellido = "";
        password = "";
        cedula = "";
        email = "";
        provincia = "";
        canton = "";
        distrito = "";
    }
    
}
