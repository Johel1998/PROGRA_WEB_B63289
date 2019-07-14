package listaDAO;

import DAO.Interface_UsuarioDAO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import modelo.Usuario;

/**
 *Esta clase funge como una lista de usuarios 
 * @author Joel Guzman Soto, Ana Elena Morales Venegas, Keylor Arias Gutierrez
 * @version 12/07/19
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
    
    /**
     * Metodo que inserta un usuario a la lista de usuarios
     * @param usuario usuario insertado
     */
    @Override
    public void insertar(Usuario usuario) {
      listaDeUsuarios.add(usuario);
    }
    
    /**
     * Elimina un usuario de la lista
     * @param usuario eliminado
     */
    @Override
    public void eliminar(Usuario usuario) {
        listaDeUsuarios.remove(usuario);
    }
    
    /**
     * Metodo que obtiene la lista de usuarios 
     * @return la lista de usuarios
     */
    @Override
    public List<Usuario> getListaUsuarios() {
     return listaDeUsuarios;
    }
    
    /**
     * Metodo que busca en la lista por correo del usuario
     * @param correo del usuario
     * @return el usuario encontrado
     */
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
    
    /**
     * Metodo que busca en la lista de usuarios si existe un correo con su misma contraseña
     * @param correo del usuario
     * @param password contraseña del usuario
     * @return un booleano en caso de que exista los datos
     */
    @Override
    public boolean login(String correo, String password) {
      return buscar(correo).getPassword().equals(password);
    }
}
