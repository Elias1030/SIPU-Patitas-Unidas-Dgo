package mx.org.patitasunidas.sipu.repository;

import mx.org.patitasunidas.sipu.model.EstadoAnimal;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AnimalRepositoryTest {
    @Test
    void guardaYRecuperaUnExpediente() {
        AnimalRepository repository = AnimalRepository.getInstance();
        var animal = repository.guardar("Sol", "Gato", "Hembra", "1 año",
                "Estable", LocalDate.of(2026, 8, 4), EstadoAnimal.RESCATADO);

        assertTrue(repository.buscar(animal.getId()).isPresent());
        assertEquals("Sol", repository.buscar(animal.getId()).orElseThrow().getNombre());
    }
}
