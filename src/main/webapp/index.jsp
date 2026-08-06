<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>SIPU | Patitas Unidas Dgo</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/assets/sipu.css">
</head>
<body>
    <header class="topbar">
        <a class="brand" href="<%= request.getContextPath() %>/">SIPU</a>
        <nav><a href="<%= request.getContextPath() %>/animales">Expedientes</a></nav>
    </header>
    <main class="container">
        <section class="hero">
            <span class="eyebrow">Patitas Unidas Dgo</span>
            <h1>Cada rescate merece seguimiento.</h1>
            <p>Sistema Integral Patitas Unidas para organizar expedientes, salud y adopciones.</p>
            <p style="margin-top:28px"><a href="<%= request.getContextPath() %>/animales"><button>Administrar animales</button></a></p>
        </section>
    </main>
</body>
</html>
