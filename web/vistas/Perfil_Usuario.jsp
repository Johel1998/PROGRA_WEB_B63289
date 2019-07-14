<%-- 
    Document   : Perfil_Usuario
    Created on : Jul 9, 2019, 4:25:26 PM
    Author     : Joel Guzman Soto, Ana Elena Morales Venegas, Keylor Arias Gutierrez
--%>



<%@page import="modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Perfil</title>
        
    </head>
    
    <body>
        <h1>PERFIL</h1>
        <br>
        <br>
        <% Usuario usuario = (Usuario) request.getAttribute("actualUser"); %> 
        <br>
        <a>Nombre: <%= usuario.getNombre()%></a>
        <br>
        <a>Apellido: <%= usuario.getApellido()%></a>
        <br>
        <a>Cedula: <%= usuario.getCedula()%></a>
        <br>
        <a>Correo: <%= usuario.getEmail()%></a>
        <br>
        <a>Provincia: <%= usuario.getProvincia()%></a>
        <br>
        <a>Canton: <%= usuario.getCanton()%></a>
        <br>
        <a>Distrito: <%= usuario.getDistrito()%></a>
        <br>
        <br>
        <br>
        <a href="Controlador?accion=zonaDeBusqueda">Zona de Busqueda</a>
        <br>
        <input type="submit" name="accion" value="Cerrar Seccion">
    </body>
</html>
