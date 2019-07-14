<%-- 
    Document   : verInformacion
    Created on : Jul 12, 2019, 4:57:55 PM
    Author     : Joel Guzman Soto, Ana Elena Morales Venegas, Keylor Arias Gutierrez
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="listaDAO.Lista_De_Articulos_DAO"%>
<%@page import="modelo.Articulo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Informacion Articulo</title>
    </head>
    <body>
        <a href="Controlador?accion=ZonaDeBusqueda">Volver</a>
        <h1>Articulo</h1>
        <br>
        <br>
        <table border="1">
            <thead>
                <tr>Codigo:</tr>
                <th>Nombre:</th>
                <th>Precio:</th>
                <th>Dueño:</th>
            </thead>
            <%
                int codigo = Integer.parseInt((String) request.getAttribute("codigoProducto"));
                Articulo dichoArticulo = (Articulo) Lista_De_Articulos_DAO.getInstance().buscarArticuloPorCodigo(codigo);
            %>
            <tbody>
                <tr>
                    <td><%=dichoArticulo.getCodigo()%></td>
                    <td><%=dichoArticulo.getNombreArticulo()%></td>
                    <td><%=dichoArticulo.getPrecio()%></td>
                    <td><%=dichoArticulo.getDuenoDelArticulo()%></td>
                </tr>
            </tbody>
        </table>
                    <h2>Mis articulos</h2>
                    <table border="1">
                        <thead>
                            <tr>
                                <th>Codigo:</th>
                                <th>Nombre:</th>
                                <th>Precio:</th>
                            </tr>
                        </thead>
                        <%
                            String usuario = (String) session.getAttribute("nombreActual");
                            List<Articulo> list = Lista_De_Articulos_DAO.getInstance().getUsuario(usuario);
                            Iterator<Articulo> i = list.iterator();
                            Articulo articulo = null;
                            while (i.hasNext()) {
                                articulo = i.next();
                        %>
                        <tbody>
                            <tr>
                                <td><%=articulo.getCodigo()%></td>
                                <td><%=articulo.getNombreArticulo()%></td>
                                <td><%=articulo.getPrecio()%></td>
                                <td>
                                    <a href="Controlador?accion=ofrecerArticulo&codigo=<%= articulo.getCodigo()%>&codigo2=<%=dichoArticulo.getCodigo()%>">Ofrecer articulo</a>
                                </td>
                            </tr>
                            <%}%>
                        </tbody>
                    </table>
    </body>
</html>
