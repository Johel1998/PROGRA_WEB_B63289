package listaDAO;

import DAO.Interface_ArticuloDAO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import modelo.Articulo;

/**
 *
 * @author JOHEL
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

    @Override
    public void insertar(Articulo articulo) {
        articulo.setCodigo(codigoArticulo);
        codigoArticulo++;
        listaDeArticulos.add(articulo);
    }

    @Override
    public void eliminar(Articulo articulo) {
        listaDeArticulos.remove(articulo);
    }

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

    @Override
    public List<Articulo> getListaArticulos() {
        return listaDeArticulos;
    }

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
