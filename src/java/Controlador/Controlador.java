package Controlador;

import DAO.Interface_ArticuloDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import listaDAO.Lista_De_Articulos_DAO;
import listaDAO.Lista_De_Trueques_DAO;
import listaDAO.Lista_Usuarios_DAO;
import modelo.Articulo;
import modelo.Trueque;
import modelo.Usuario;

/**
 *
 * @author JOHEL
 */
//@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {

    public String index = "index.jsp";
    public String login = "vistas/login.jsp";
    public String registro = "vistas/register.jsp";
    public String zonaDeCarga = "vistas/zonaDeCarga.jsp";
    public String perfil = "vistas/Perfil_Usuario.jsp";
    public String zonaTrueques = "vistas/zonaDeTrueques.jsp";
    public String zonaDeBusqueda = "vistas/zonaDeBusqueda.jsp";
    public String verInformacion = "vistas/mostrarInformacionArt.jsp";

    public Articulo articulo = new Articulo();
    public Trueque trueque = new Trueque();
    public Usuario usuario = new Usuario();

    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso = "";
        String accion = request.getParameter("accion");
        switch (accion) {
            case "login":
                acceso = login;
                break;
            case "index":
                acceso = index;
                break;
            case "register":
                acceso = registro;
                break;
            case "Cerrar Seccion"://NO FUNCIONA
                usuario.reiniciarUsuario();
                acceso = index;
                break;
            case "zonaDeBusqueda":
                acceso = zonaDeBusqueda;
                break;
            case "zonaDeCarga":
                acceso = zonaDeCarga;
                break;
            case "perfil":
                request.setAttribute("actualUser", usuario);
                acceso = perfil;
                break;
            case "zonaDeTrueques":
                acceso = zonaDeCarga;
                break;
            case "registrar":
                try {
                    String nombre = request.getParameter("nombre");
                    String apellido = request.getParameter("apellido");
                    String correo = request.getParameter("correo");
                    String password = request.getParameter("password");
                    String cedula = request.getParameter("cedula");
                    String provincia = request.getParameter("provincia");
                    String canton = request.getParameter("canton");
                    String distrito = request.getParameter("distrito");
                    usuario = new Usuario(nombre, apellido, password, cedula, correo, provincia, canton, distrito);
                    Lista_Usuarios_DAO.getInstance().insertar(usuario);
                    acceso = login;
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "Iniciar Seccion":
                request.getSession().setAttribute("nombreActual", request.getParameter("correo"));
                String correo = request.getParameter("correo");
                String password = request.getParameter("password");
                boolean seEntro = Lista_Usuarios_DAO.getInstance().login(correo, password);
                if (seEntro == true) {
                    usuario=Lista_Usuarios_DAO.getInstance().buscar(correo);
                    request.setAttribute("actualUser", usuario);
                    acceso = zonaDeBusqueda;
                }
                break;
            case "Agregar":
                String nombreDelArticulo = request.getParameter("nombreProducto");
                int precio = Integer.parseInt(request.getParameter("precio"));
                String usuario = (String) request.getSession().getAttribute("nombreActual");
                articulo = new Articulo(usuario, nombreDelArticulo, precio);
                Lista_De_Articulos_DAO.getInstance().insertar(articulo);
                acceso = zonaDeBusqueda;
                break;
            case "verInformacion":
                request.setAttribute("codigoProducto", request.getParameter("codigo"));
                acceso = verInformacion;
                break;
            case "zonaTrueques":
                acceso = zonaTrueques;
                break;
//            case "informacion":
//                request.setAttribute("codigoProducto", request.getParameter("codigo"));
//                acceso = verInformacion;
//                break;
            case "ofrecerArticulo":
                int codigoOfertante = Integer.parseInt(request.getParameter("codigo"));
                int codigoRecibidor = Integer.parseInt(request.getParameter("codigo2"));
                Articulo articuloOfertante = Lista_De_Articulos_DAO.getInstance().buscarArticuloPorCodigo(codigoOfertante);
                Articulo articuloRecibidor = Lista_De_Articulos_DAO.getInstance().buscarArticuloPorCodigo(codigoRecibidor);
                articuloOfertante.setEnTrueque(true);
                articuloRecibidor.setEnTrueque(true);
                trueque = new Trueque(articuloOfertante.getDuenoDelArticulo(), articuloRecibidor.getDuenoDelArticulo(), articuloOfertante, articuloRecibidor);
                Lista_De_Trueques_DAO.getInstance().agregarTrueque(trueque);
                acceso = zonaTrueques;
                break;
            case "aceptar":
                int codigoE = Integer.parseInt(request.getParameter("codigoE"));
                int codigoR = Integer.parseInt(request.getParameter("codigoR"));
                int codigoTrueque = Integer.parseInt(request.getParameter("codigoTrueque"));
                Lista_De_Trueques_DAO.getInstance().buscarPorCodigo(codigoTrueque).getEstado().pasarEstado("ACEPTADO");
                Lista_De_Articulos_DAO.getInstance().eliminar(Lista_De_Articulos_DAO.getInstance().buscarArticuloPorCodigo(codigoE));
                Lista_De_Articulos_DAO.getInstance().eliminar(Lista_De_Articulos_DAO.getInstance().buscarArticuloPorCodigo(codigoR));
                acceso=zonaTrueques;
                break;
            case "rechazar":
                int codigoTrueque2 = Integer.parseInt(request.getParameter("codigoTrueque"));
                Lista_De_Trueques_DAO.getInstance().buscarPorCodigo(codigoTrueque2).getEstado().pasarEstado("RECHAZADO");
                acceso = zonaTrueques;
                break;
        }   
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
