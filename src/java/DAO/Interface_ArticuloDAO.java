package DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import modelo.Articulo;

/**
 *
 * @author JOHEL
 */
public interface Interface_ArticuloDAO {
    public void insertar(Articulo articulo);
    void eliminar(Articulo articulo);
    public Articulo buscarArticuloPorCodigo(int codigo);
    List <Articulo> getListaArticulos();
    List <Articulo> getUsuario (String usuario);
}
