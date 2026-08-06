package mx.org.patitasunidas.sipu.repository;

import mx.org.patitasunidas.sipu.model.Animal;
import mx.org.patitasunidas.sipu.model.EstadoAnimal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

public class AnimalRepository {
    private static final AnimalRepository INSTANCE = new AnimalRepository();
    private final List<Animal> animales = new CopyOnWriteArrayList<>();
    private final AtomicLong secuencia = new AtomicLong();

    private AnimalRepository() {
        guardar("Luna", "Perro", "Hembra", "2 años",
                "Rescatada y estable", LocalDate.now(), EstadoAnimal.DISPONIBLE);
    }

    public static AnimalRepository getInstance() { return INSTANCE; }

    public Animal guardar(String nombre, String especie, String sexo,
                           String edadAproximada, String condicion,
                           LocalDate fechaIngreso, EstadoAnimal estado) {
        Animal animal = new Animal(secuencia.incrementAndGet(), nombre, especie,
                sexo, edadAproximada, condicion, fechaIngreso, estado);
        animales.add(animal);
        return animal;
    }

    public List<Animal> listar() {
        List<Animal> copia = new ArrayList<>(animales);
        copia.sort(Comparator.comparingLong(Animal::getId).reversed());
        return copia;
    }

    public Optional<Animal> buscar(long id) {
        return animales.stream().filter(animal -> animal.getId() == id).findFirst();
    }
}
