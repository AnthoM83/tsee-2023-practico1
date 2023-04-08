<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <jsp:include page="header.jsp" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TSEE 2023 - Práctico 1 </title>
    </head>
    <body>
        <h2>Baja de Ciudadano</h2>
        <form name="datosCiudadano" action="BajaCiudadano" method="post">
            <label for="cedula">Ingrese la cédula del ciudadano que desea dar de baja: </label><br>
            <input type="text" name="cedula" id="cedula" required><br>
            <button type="submit">Enviar</button>
        </form>
        <jsp:include page="footer.jsp" />
    </body>
</html>