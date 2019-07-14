<%-- 
    Document   : ZonaDeCarga
    Created on : 05/07/2019, 06:26:37 PM
    Author     : JOHEL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Zona De Carga</title>
    </head>
    <body>
        <h1>Zona De Carga</h1>
        <h2>Agrega tu producto</h2>
        
        <form action="Controlador">
            Nombre Del Producto:<br>
            <input type="text" name="nombreProducto"><br>
            Precio:<br>
            <input type="text" name="precio">
            <br>
            <input type="submit" name="accion" value="Agregar">
        </form>
        <a href="Controlador?accion=zonaDeBusqueda">Volver</a>
        <a href="Controlador?accion=perfil">perfil</a>
    </body>
</html>
