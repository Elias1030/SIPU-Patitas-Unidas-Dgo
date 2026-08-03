package mx.org.patitasunidas.sipu.service;

import mx.org.patitasunidas.sipu.model.EstadoAnimal;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EstadoAnimalServiceTest {

    private final EstadoAnimalService service = new EstadoAnimalService();

    @Test
    void permiteQueUnAnimalDisponiblePaseAEvaluacion() {
        assertTrue(service.esTransicionValida(
                EstadoAnimal.DISPONIBLE,
                EstadoAnimal.EN_EVALUACION));
    }

    @Test
    void impideQueUnAnimalAdoptadoRegreseADisponible() {
        assertFalse(service.esTransicionValida(
                EstadoAnimal.ADOPTADO,
                EstadoAnimal.DISPONIBLE));
    }
}
