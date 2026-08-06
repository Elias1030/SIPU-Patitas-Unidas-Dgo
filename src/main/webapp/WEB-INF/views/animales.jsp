<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="mx.org.patitasunidas.sipu.model.Animal" %>
<%@ page import="mx.org.patitasunidas.sipu.model.EstadoAnimal" %>
<%!
    private String e(String value) {
        if (value == null) return "";
        return value.replace("&", "&amp;").replace("<", "&lt;")
                .replace(">", "&gt;").replace("\"", "&quot;")
                .replace("'", "&#39;");
    }
    private String etiqueta(EstadoAnimal estado) {
        return estado.name().toLowerCase().replace('_', '-');
    }
%>
<%
    List<Animal> animales = (List<Animal>) request.getAttribute("animales");
    EstadoAnimal[] estados = (EstadoAnimal[]) request.getAttribute("estados");
%>
<!doctype html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Expedientes | SIPU</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/assets/sipu.css">
</head>
<body>
<header class="topbar">
    <a class="brand" href="<%= request.getContextPath() %>/">SIPU</a>
    <nav><a href="<%= request.getContextPath() %>/animales">Expedientes</a></nav>
</header>
<main class="container">
    <section class="hero compact">
        <div><span class="eyebrow">Patitas Unidas Dgo</span><h1>Expedientes de animales</h1>
        <p>Registra cada rescate y consulta su estado actual.</p></div>
        <span class="counter"><strong><%= animales.size() %></strong> registros</span>
    </section>

    <section class="panel">
        <h2>Nuevo expediente</h2>
        <form method="post" action="<%= request.getContextPath() %>/animales" class="form-grid">
            <label>Nombre<input name="nombre" maxlength="80" required></label>
            <label>Especie<select name="especie" required><option>Perro</option><option>Gato</option><option>Otro</option></select></label>
            <label>Sexo<select name="sexo" required><option>Hembra</option><option>Macho</option><option>No determinado</option></select></label>
            <label>Edad aproximada<input name="edadAproximada" placeholder="Ej. 2 años" maxlength="40" required></label>
            <label>Fecha de ingreso<input type="date" name="fechaIngreso" required></label>
            <label>Estado<select name="estado" required>
                <% for (EstadoAnimal estado : estados) { %><option value="<%= estado.name() %>"><%= e(estado.name().replace('_', ' ')) %></option><% } %>
            </select></label>
            <label class="wide">Condición al ingresar<textarea name="condicion" maxlength="300" required></textarea></label>
            <div class="wide actions"><button type="submit">Guardar expediente</button></div>
        </form>
    </section>

    <section class="cards">
        <% for (Animal animal : animales) { %>
        <article class="animal-card">
            <div class="animal-icon"><%= "Gato".equals(animal.getEspecie()) ? "🐱" : "🐶" %></div>
            <div class="animal-data">
                <div class="card-heading"><h2><%= e(animal.getNombre()) %></h2><span class="status <%= etiqueta(animal.getEstado()) %>"><%= e(animal.getEstado().name().replace('_', ' ')) %></span></div>
                <p><strong><%= e(animal.getEspecie()) %></strong> · <%= e(animal.getSexo()) %> · <%= e(animal.getEdadAproximada()) %></p>
                <p><%= e(animal.getCondicion()) %></p>
                <small>Ingreso: <%= animal.getFechaIngreso() %> · Folio SIPU-<%= String.format("%04d", animal.getId()) %></small>
                <form method="post" action="<%= request.getContextPath() %>/animales" class="state-form">
                    <input type="hidden" name="accion" value="cambiarEstado"><input type="hidden" name="id" value="<%= animal.getId() %>">
                    <select name="estado" aria-label="Nuevo estado"><% for (EstadoAnimal estado : estados) { %><option value="<%= estado.name() %>"><%= e(estado.name().replace('_', ' ')) %></option><% } %></select>
                    <button type="submit" class="secondary">Cambiar estado</button>
                </form>
            </div>
        </article>
        <% } %>
    </section>
</main>
</body>
</html>
