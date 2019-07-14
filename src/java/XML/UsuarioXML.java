package XML;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import modelo.Usuario;

/**
 *
 * @author Ana Elena
 */
public class UsuarioXML {
    private static XMLEncoder encriptador;
    private static XMLDecoder desencriptador;

    public UsuarioXML() {
        encriptador = null;
        desencriptador = null;
    }
    
    public static ArrayList<Usuario> cargarArchivo (){
        ArrayList<Usuario> listaUsuario = new ArrayList<>();
        try {
            desencriptador = new XMLDecoder(new FileInputStream("archivoXML.xml"));
            listaUsuario = (ArrayList<Usuario>) desencriptador.readObject();
            desencriptador.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        return listaUsuario;
    }
    
    public static void escribirArchivo(ArrayList<Usuario> list) {
        try {
            encriptador = new XMLEncoder(new FileOutputStream("archivoXML.xml"));
            encriptador.writeObject(list);
            encriptador.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
