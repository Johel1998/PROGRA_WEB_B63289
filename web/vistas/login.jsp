<%-- 
    Document   : Login
    Created on : 05/07/2019, 06:23:42 PM
    Author     : JOHEL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Iniciar Seccion</title>
    </head>
    <body>
        <h1>Iniciar Seccion</h1>
        <form action="Controlador">
            Nombre:<br>
            <input type="text" name="nombre"><br>
            Correo: <br>
            <input type="text" name="correo"><br>
            Contraseña: <br>
            <input type="text" name="password"><br>
            <input type="submit" name="accion" value="Iniciar Seccion">
            <a href="Controlador?accion=index">volver</a>
        </form>
    </body>
</html>
