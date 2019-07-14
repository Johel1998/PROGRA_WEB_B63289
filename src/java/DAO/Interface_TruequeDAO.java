package DAO;

import java.util.List;
import modelo.Trueque;

/**
 *
 * @author JOHEL
 */
public interface Interface_TruequeDAO {
    public void agregarTrueque(Trueque trueque);
    public void eliminarTrueque(Trueque trueque);
    public Trueque buscarPorCodigo (int codigo);
    public List<Trueque> listarMisTrueques(String nombreUsuario);
    public List<Trueque> getListaTrueques();
    public List <Trueque> listaDeTruequesSolicitados (String nombreUsuario);
}
