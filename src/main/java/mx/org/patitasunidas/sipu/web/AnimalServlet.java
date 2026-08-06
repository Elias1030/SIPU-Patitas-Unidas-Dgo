package mx.org.patitasunidas.sipu.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mx.org.patitasunidas.sipu.model.EstadoAnimal;
import mx.org.patitasunidas.sipu.repository.AnimalRepository;
import mx.org.patitasunidas.sipu.service.EstadoAnimalService;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

@WebServlet("/animales")
public class AnimalServlet extends HttpServlet {
    private final AnimalRepository repository = AnimalRepository.getInstance();
    private final EstadoAnimalService estadoService = new EstadoAnimalService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("animales", repository.listar());
        request.setAttribute("estados", EstadoAnimal.values());
        request.getRequestDispatcher("/WEB-INF/views/animales.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String accion = request.getParameter("accion");

        if ("cambiarEstado".equals(accion)) {
            cambiarEstado(request);
        } else {
            registrar(request);
        }
        response.sendRedirect(request.getContextPath() + "/animales");
    }

    private void registrar(HttpServletRequest request) throws ServletException {
        String nombre = requerido(request, "nombre");
        String especie = requerido(request, "especie");
        String sexo = requerido(request, "sexo");
        String edad = requerido(request, "edadAproximada");
        String condicion = requerido(request, "condicion");
        try {
            LocalDate fecha = LocalDate.parse(requerido(request, "fechaIngreso"));
            EstadoAnimal estado = EstadoAnimal.valueOf(requerido(request, "estado"));
            repository.guardar(nombre, especie, sexo, edad, condicion, fecha, estado);
        } catch (DateTimeParseException | IllegalArgumentException ex) {
            throw new ServletException("Los datos del expediente no son válidos.", ex);
        }
    }

    private void cambiarEstado(HttpServletRequest request) throws ServletException {
        try {
            long id = Long.parseLong(requerido(request, "id"));
            EstadoAnimal siguiente = EstadoAnimal.valueOf(requerido(request, "estado"));
            var animal = repository.buscar(id)
                    .orElseThrow(() -> new ServletException("No se encontró el animal."));
            if (!estadoService.esTransicionValida(animal.getEstado(), siguiente)) {
                throw new ServletException("El cambio de estado solicitado no está permitido.");
            }
            animal.setEstado(siguiente);
        } catch (IllegalArgumentException ex) {
            throw new ServletException("El cambio de estado no es válido.", ex);
        }
    }

    private String requerido(HttpServletRequest request, String nombre) throws ServletException {
        String valor = request.getParameter(nombre);
        if (valor == null || valor.isBlank()) {
            throw new ServletException("El campo " + nombre + " es obligatorio.");
        }
        return valor.trim();
    }
}
