<%-- 
    Document   : ZonaDeTrueques
    Created on : 05/07/2019, 06:26:50 PM
    Author     : JOHEL
--%>

<%@page import="java.util.Iterator"%>
<%@page import="listaDAO.Lista_De_Trueques_DAO"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Trueque"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Zona De Trueques</title>
    </head>
    <body>
        <a href="Controlador?accion=zonaTrueques">Actualizar</a>
        <a href="Controlador?accion=zonaDeBusqueda">Volver</a>
        <h1>Truques solicitados</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>Ofertante</th>
                    <th>Producto a Enviar</th>
                    <th>Producto a Recibir</th>
                    <th>Recibidor</th>
                </tr>
            </thead>
            <%
                String usuario = (String) session.getAttribute("nombreActual");
                List<Trueque> listaTrueques = Lista_De_Trueques_DAO.getInstance().listarMisTrueques(usuario);
                Iterator<Trueque> itr = listaTrueques.iterator();
                Trueque trueque = null;
                while(itr.hasNext()){
                    trueque = itr.next();
            %>
            <tbody>
                <tr>
                    <td><%=usuario%></td>
                    <td><%=trueque.getEnviarArticulo().getNombreArticulo()%></td>
                    <td><%=trueque.getRecibirArticulo().getNombreArticulo()%></td>
                    <td><%=trueque.getRecibirArticulo().getDuenoDelArticulo()%></td>
                </tr>
                <%}%>
            </tbody>
        </table>
            <br>
        <h1>Trueques que faltan de aprobar</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>Ofertante</th>
                    <th>Producto a Enviar</th>
                    <th>Producto a Recibir</th>
                    <th>Recibidor</th>
                    <th>Estado</th>
                </tr>
            </thead>
            <%
                
                List<Trueque> list2 = Lista_De_Trueques_DAO.getInstance().listaDeTruequesSolicitados(usuario);
                Iterator<Trueque> itr2 = list2.iterator();
                Trueque trueque2 = null;
                while (itr2.hasNext()) {
                    String aceptar ="Aceptar";
                    String rechazar ="Rechazar";
                    trueque2 = itr2.next();
                    if(!trueque2.getEstado().getDescripcion().equals("pendiente")){
                        aceptar = "";
                        rechazar = "";
                    }
            %>
            <tbody>
                <tr>
                    <td><%=trueque2.getEnviarArticulo().getDuenoDelArticulo()%></td>
                    <td><%=trueque2.getEnviarArticulo().getNombreArticulo()%></td>
                    <td><%=trueque2.getRecibirArticulo().getNombreArticulo()%></td>
                    <td><%=usuario%></td>
                    <td><%=trueque2.getEstado().getDescripcion()%></td>
                    <td><a href="Controlador?accion=aceptar&codigoE=<%= trueque2.getEnviarArticulo().getCodigo()%>&codigoR=<%=trueque2.getRecibirArticulo().getCodigo()%>&codigoTrueque=<%= trueque2.getCodigoTrueque()%>"><%=aceptar%></a></td>
                    <td><a href="Controlador?accion=rechazar&codigoTrueque=<%= trueque2.getCodigoTrueque()%>"><%=rechazar%></a></td>
                </tr>
                <%}%>
            </tbody>
        </table>
    </body>
</html>
