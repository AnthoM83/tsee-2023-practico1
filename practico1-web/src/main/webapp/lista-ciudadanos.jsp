<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <jsp:include page="header.jsp" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TSEE 2023 - Práctico 1</title>
    </head>
    <body>
        <h2>Lista de Ciudadanos</h2>
        <c:forEach items="${requestScope.ciudadanos}" var="ciudadano">
            <p>${ciudadano}</p>
        </c:forEach>
        <jsp:include page="footer.jsp" />
    </body>
</html>