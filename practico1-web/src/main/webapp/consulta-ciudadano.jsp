<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <jsp:include page="header.jsp" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TSEE 2023 - Práctico 1 </title>
    </head>
    <body>
        <h2>Consulta de Ciudadano</h2>
        <p>Nombre Completo: ${cNombreCompleto}</p>
        <p>Cédula: ${cCedula}</p>
        <p>Fecha: ${cFecha}</p>
        <p>Correo: ${cCorreo}</p>
        <p>Sector Laboral: ${cSectorLaboral}</p>
        <jsp:include page="footer.jsp" />
    </body>
</html>