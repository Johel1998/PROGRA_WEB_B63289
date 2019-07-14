package listaDAO;

import DAO.Interface_ArticuloDAO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import modelo.Articulo;

/**
 * Esta clase representa una lista de articulos
 * @author Johel Guzman Soto, Ana Elena Morales Venegas, Keylor Arias
 * @version 11/07/19
 */
public class Lista_De_Articulos_DAO implements Interface_ArticuloDAO {

    private static Lista_De_Articulos_DAO instance;
    private int codigoArticulo;
    public List<Articulo> listaDeArticulos;

    public Lista_De_Articulos_DAO() {
        listaDeArticulos = new ArrayList<>();
        codigoArticulo = 1;
    }

    public static Lista_De_Articulos_DAO getInstance() {
        if (instance == null) {
            instance = new Lista_De_Articulos_DAO();
        }
        return instance;
    }

    /**
     * Este metodo es implementado de la interfaz y agrega un articulo en la lista, al igual que
     * aumenta el codigo del articulo
     * @param articulo articulo que se insertara en la lista
     */
    @Override
    public void insertar(Articulo articulo) {
        articulo.setCodigo(codigoArticulo);
        codigoArticulo++;
        listaDeArticulos.add(articulo);
    }

    /**
     * Este metodo es implementado de la interfaz y elimina un articulo en la lista
     * @param articulo articulo que se eliminara en la lista
     */
    @Override
    public void eliminar(Articulo articulo) {
        listaDeArticulos.remove(articulo);
    }

    /**
     * Este metodo busca un articulo de acuerdo a su respectivo codigo
     * @param codigoDelArticulo el codigo del articulo que se desea buscar
     * @return retorna el articulo si se encuentra, si no retorna null
     */
    @Override
    public Articulo buscarArticuloPorCodigo(int codigoDelArticulo) {
        Iterator itr = listaDeArticulos.iterator();
        while (itr.hasNext()) {
            Articulo articulo = (Articulo) itr.next();
            if (articulo.getCodigo() == codigoDelArticulo) {
                return articulo;
            }
        }
        return null;
    }

    /**
     * Metodo que sirve para obtener la lista de los articulos 
     * @return retorna la lista de los articulos
     */
    @Override
    public List<Articulo> getListaArticulos() {
        return listaDeArticulos;
    }

    /**
     * Metodo que obtiene los articulos de un usuario en especifico
     * @param usuario nombre del usuario
     * @return retorna su lista de articulos
     */
    @Override
    public List<Articulo> getUsuario(String usuario) {
        Iterator itr = listaDeArticulos.iterator();
        List<Articulo> nuevaLista = new ArrayList<>();
        while (itr.hasNext()) {
            Articulo nuevoArticulo = (Articulo) itr.next();
            if (nuevoArticulo.getDuenoDelArticulo().equalsIgnoreCase(usuario)) {
                nuevaLista.add(nuevoArticulo);
            }
        }
        return nuevaLista;
    }
}
