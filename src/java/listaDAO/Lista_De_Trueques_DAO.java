package listaDAO;

import DAO.Interface_TruequeDAO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import modelo.Trueque;

/**
 *Esta clase funge como una lista de usuarios 
 * @author Joel Guzman Soto, Ana Elena Morales Venegas, Keylor Arias Gutierrez
 * @version 13/07/19
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
    
    /**
     * Metodo que agrega un nuevo trueque a la lista 
     * @param nuevoTrueque trueque agregado
     */
    @Override
    public void agregarTrueque(Trueque nuevoTrueque) {
        nuevoTrueque.setCodigoTrueque(codigoDelTrueque);
        codigoDelTrueque++;
        listaDeTrueques.add(nuevoTrueque);
    }
    
    /**
     * Metodo que elimina el trueque de la lista
     * @param truequeEliminado que se desea eliminar
     */
    @Override
    public void eliminarTrueque(Trueque truequeEliminado) {
     listaDeTrueques.remove(truequeEliminado);
    }
    
    /**
     * Metodo que busca por codigo en la lista
     * @param codigoDelTrueque que se desea encontra con base al trueque
     * @return el trueque con el que se coincidio
     */
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
    
    /**
     * Metodo que muestra los trueques que se han hecho 
     * @param nombreUsuario usuario por el que se desea buscar los trueques
     * @return la lista de los trueques
     */
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
        
    /**
     * Metodo que devuelve la lista de trueques
     * @return la lista de trueques
     */
    @Override
    public List<Trueque> getListaTrueques() {
     return listaDeTrueques;
    }
    
    /**
     * Metodo que muestra la lista de trueques solicitados 
     * @param nombreUsuario nombre por el cual se va a buscar los trueques
     * @return la lista de trueques
     */
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
