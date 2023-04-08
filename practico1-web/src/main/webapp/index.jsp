<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <jsp:include page="header.jsp" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TSEE 2023 - Práctico 1 </title>
    </head>
    <body>
        <form name="datosCiudadano" action="ConsultaCiudadano" method="post">
            <label for="cedula">Buscar Ciudadano: </label>
            <input type="text" name="cedula" id="cedula" required>
            <button type="submit">Enviar</button>
        </form>
        <a href="alta-ciudadano.jsp">Alta de Ciudadano</a><br>
        <a href="baja-ciudadano.jsp">Baja de Ciudadano</a><br>
        <form action="ListaCiudadanos" method="post">
            <button type="submit">Lista de Ciudadanos</button>
        </form>
        <jsp:include page="footer.jsp" />
    </body>
</html>
