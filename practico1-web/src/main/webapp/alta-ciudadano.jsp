<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <jsp:include page="header.jsp" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TSEE 2023 - Práctico 1 </title>
    </head>
    <body>
    <h2>Alta de Ciudadano</h2>
    <form name="datosCiudadano" action="AltaCiudadano" method="post">
        <label for="nombreCompleto">Nombre completo: </label>
        <input type="text" name="nombreCompleto" id="nombreCompleto" required><br>
        <label for="cedula">Cédula: </label>
        <input type="text" name="cedula" id="cedula" required><br>
        <label for="fechaNacimiento">Fecha de Nacimiento: </label>
        <input type="date" name="fechaNacimiento" id="fechaNacimiento" required><br>
        <label for="correo">Correo electrónico: </label>
        <input type="email" name="correo" id="correo" required><br>
        <label for="sectorLaboral">Sector Laboral: </label>
        <select name="sectorLaboral" required><br>
            <option value="" disabled selected >Elija una opción</option>
            <option value="0" >Procesamiento y conservación de alimentos, bebidas y tabaco</option>
            <option value="1">Industria frigorífica</option>
            <option value="2">Pesca</option>
            <option value="3">Industria Textil</option>
            <option value="4">Industrias del Cuero, Vestimenta y Calzado</option>
            <option value="5">Industria de la madera, celulosa y papel</option>
        </select>
        <button type="submit">Enviar</button>
    </form>
    <jsp:include page="footer.jsp" />
</body>
</html>