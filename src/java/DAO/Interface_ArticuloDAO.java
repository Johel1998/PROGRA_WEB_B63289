package DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import modelo.Articulo;

/**
 * Esta clase obtiene los metodos que seran implementados en la lista de Articulos
 * @author Johel Guzman Soto, Ana Elena Morales Venegas, Keylor Arias
 * @version 10/07/19
 */
public interface Interface_ArticuloDAO {
    public void insertar(Articulo articulo);
    void eliminar(Articulo articulo);
    public Articulo buscarArticuloPorCodigo(int codigo);
    List <Articulo> getListaArticulos();
    List <Articulo> getUsuario (String usuario);
}
