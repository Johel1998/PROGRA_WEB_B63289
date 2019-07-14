<%-- 
    Document   : ZonaDeBusqueda
    Created on : 05/07/2019, 06:26:36 PM
    Author     : JOHEL
--%>

<%@page import="listaDAO.Lista_Usuarios_DAO"%>
<%@page import="modelo.Usuario"%>
<%@page import="java.util.Iterator"%>
<%@page import="listaDAO.Lista_De_Articulos_DAO"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Articulo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Zona De Busqueda</title>

    </head>
    <body>
        <h1>Zona De Busqueda</h1>
        <a href="Controlador?accion=zonaDeBusqueda">Refrescar</a>
        <br>
        <a href="Controlador?accion=perfil">perfil</a>
        <br>
        <a href="Controlador?accion=zonaDeCarga">Agregar articulo</a>
        <br>
        <a href="Controlador?accion=zonaTrueques">Zona De Trueques</a>
        <br>
        <br>
        <table border="1">
            <thead>
                <tr>
                    <th>Codigo</th>
                    <th>Nombre</th>
                    <th>Precio</th>
                    <th>Dueño</th>
                </tr>
            </thead>
            <%
                List<Articulo> list = Lista_De_Articulos_DAO.getInstance().getListaArticulos();
                Iterator<Articulo> itr = list.iterator();
                String usuario = (String) session.getAttribute("nombreActual");
                Articulo articulo = null;
                Usuario usuarioActual = Lista_Usuarios_DAO.getInstance().buscar(usuario);
                while (itr.hasNext()) {
                    String info = "Ver Informacion";
                    articulo = itr.next();
                    if(usuario.equalsIgnoreCase(articulo.getDuenoDelArticulo())){
                        info = "";
                    }
            %>
            <tbody>
                <tr>
                    <td><%=articulo.getCodigo()%></td>
                    <td><%=articulo.getNombreArticulo()%></td>
                    <td><%=articulo.getPrecio()%></td>
                    <td><%=articulo.getDuenoDelArticulo()%></td>
                    <td>
                       <a href="Controlador?accion=verInformacion&codigo=<%= articulo.getCodigo()%>"><%=info%></a> 
                    </td>
                </tr>
                <%}%>
            </tbody>
        </table>
    </body>
</html>
