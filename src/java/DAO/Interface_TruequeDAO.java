package DAO;

import java.util.List;
import modelo.Trueque;

/**
 *Esta clase representa la interfaz de trueques con sus respectivos metodos
 * @author Joel Guzman Soto, Ana Elena Morales Venegas, Keylor Arias Gutierrez
 * @version 10/07/19
 */
public interface Interface_TruequeDAO {
    public void agregarTrueque(Trueque trueque);
    public void eliminarTrueque(Trueque trueque);
    public Trueque buscarPorCodigo (int codigo);
    public List<Trueque> getMisTrueques(String nombreUsuario);
    public List<Trueque> getListaTrueques();
    public List <Trueque> getTruequesQueMeSolicitaron (String nombreUsuario);
}
