package listaDAO;

import DAO.Interface_TruequeDAO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import modelo.Trueque;

/**
 *
 * @author JOHEL
 */
public class Lista_De_Trueques_DAO implements Interface_TruequeDAO{
    public List<Trueque> listaDeTrueques;
    private int codigoDelTrueque;
    private static Lista_De_Trueques_DAO instance;

    public Lista_De_Trueques_DAO() {
        listaDeTrueques = new ArrayList<>();
        codigoDelTrueque = 1;
    }
    
    public static Lista_De_Trueques_DAO getInstance() {
        if (instance == null) {
            instance = new Lista_De_Trueques_DAO();
        }
        return instance;
    }
    
    @Override
    public void agregarTrueque(Trueque nuevoTrueque) {
        nuevoTrueque.setCodigoTrueque(codigoDelTrueque);
        codigoDelTrueque++;
        listaDeTrueques.add(nuevoTrueque);
    }

    @Override
    public void eliminarTrueque(Trueque truequeEliminado) {
     listaDeTrueques.remove(truequeEliminado);
    }

    @Override
    public Trueque buscarPorCodigo(int codigoDelTrueque) {
        Iterator itr = listaDeTrueques.iterator();
        while (itr.hasNext()) {
            Trueque nuevoT = (Trueque) itr.next();
            if (nuevoT.getCodigoTrueque()== codigoDelTrueque) {
                return nuevoT;
            }
        }
        return null;
    }

    @Override
    public List<Trueque> listarMisTrueques(String nombreUsuario) {
        Iterator itr = listaDeTrueques.iterator();
        List<Trueque> susTrueques = new ArrayList<>();
        while (itr.hasNext()) {
            Trueque nuevoTrueque = (Trueque) itr.next();
            if (nuevoTrueque.getNombreDelOfertante().equalsIgnoreCase(nombreUsuario)) {
                susTrueques.add(nuevoTrueque);
            }
        }
        return susTrueques;
    }

    @Override
    public List<Trueque> getListaTrueques() {
     return listaDeTrueques;
    }

    @Override
    public List<Trueque> listaDeTruequesSolicitados(String nombreUsuario) {
     Iterator it = listaDeTrueques.iterator();
        List<Trueque> tusTrueques = new ArrayList<>();
        while (it.hasNext()) {
            Trueque nuevoTrueque = (Trueque) it.next();
            if (nuevoTrueque.getNombreDelRecibidor().equalsIgnoreCase(nombreUsuario)) {
                tusTrueques.add(nuevoTrueque);
            }
        }
        return tusTrueques;
    }
}
