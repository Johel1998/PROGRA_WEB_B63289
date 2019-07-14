package DAO;

import java.util.List;
import modelo.Usuario;

/**
 *Esta clase representa la interfaz de usuarios con sus respectivos metodos
 * @author Joel Guzman Soto, Ana Elena Morales Venegas, Keylor Arias Gutierrez
 * @version 10/07/19
 */
public interface Interface_UsuarioDAO {
    public void insertar (Usuario usuario);
    public void eliminar (Usuario usuario);
    public List<Usuario> getListaUsuarios();
    public Usuario buscar (String correo);
    public boolean login(String correo, String password);
}
