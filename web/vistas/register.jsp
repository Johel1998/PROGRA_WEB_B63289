<%-- 
    Document   : Register
    Created on : 05/07/2019, 06:22:36 PM
    Author     : Joel Guzman Soto, Ana Elena Morales Venegas, Keylor Arias Gutierrez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Creacion de Usuario</title>
    </head>
    <body>
        <h1> Por favor llene todos los espacios </h1>
        <form action="Controlador">
            Nombre:
            <br>
            <input type="text" name="nombre">
            <br>
            Apellido: 
            <br>
            <input type="text" name="apellido"><br>
            Correo Electronico:
            <br>
            <input type="text" name="correo"><br>
            Contraseña:
            <br>
            <input type="text" name="password"><br>
            Cedula:
            <br>
            <input type="text" name="cedula"><br>
            Provicia:
            <br>
            <input type="text" name="provincia"><br>
            Canton: 
            <br>
            <input type="text" name="canton"><br>
            Distrito: 
            <br>
            <input type="text" name="distrito"><br>                
            <input type="submit" name="accion" value="registrar">
            
              <a href="Controlador?accion=index">volver</a>
            
        </form>     
    </body>
</html>
