package listaDAO;

import DAO.Interface_UsuarioDAO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import modelo.Usuario;

/**
 *
 * @author JOHEL
 */
public class Lista_Usuarios_DAO implements Interface_UsuarioDAO{
    private static Lista_Usuarios_DAO instance;
    public List<Usuario> listaDeUsuarios;

    public Lista_Usuarios_DAO() {
    listaDeUsuarios = new ArrayList<>();
    }
    
    public static Lista_Usuarios_DAO getInstance() {
        if (instance == null) {
            instance = new Lista_Usuarios_DAO();
        }
        return instance;
    }
    
    @Override
    public void insertar(Usuario usuario) {
      listaDeUsuarios.add(usuario);
    }

    @Override
    public void eliminar(Usuario usuario) {
        listaDeUsuarios.remove(usuario);
    }

    @Override
    public List<Usuario> getListaUsuarios() {
     return listaDeUsuarios;
    }

    @Override
    public Usuario buscar(String correo) {
        Iterator itr = listaDeUsuarios.iterator();
        while (itr.hasNext()) {
            Usuario nuevoUsuario = (Usuario) itr.next();
            if (nuevoUsuario.getEmail().equalsIgnoreCase(correo)) {
                return nuevoUsuario;
            }
        }
        return null;
    }

    @Override
    public boolean login(String correo, String password) {
      return buscar(correo).getPassword().equals(password);
    }
}
