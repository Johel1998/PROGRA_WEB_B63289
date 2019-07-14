package DAO;

import java.util.List;
import modelo.Usuario;

/**
 *
 * @author Ana Elena
 */
public interface Interface_UsuarioDAO {
    public void insertar (Usuario usuario);
    public void eliminar (Usuario usuario);
    public List<Usuario> getListaUsuarios();
    public Usuario buscar (String correo);
    public boolean login(String correo, String password);
}
