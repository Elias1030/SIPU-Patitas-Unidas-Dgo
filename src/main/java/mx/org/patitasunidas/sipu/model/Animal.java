package mx.org.patitasunidas.sipu.model;

import java.time.LocalDate;

public class Animal {
    private final long id;
    private final String nombre;
    private final String especie;
    private final String sexo;
    private final String edadAproximada;
    private final String condicion;
    private final LocalDate fechaIngreso;
    private EstadoAnimal estado;

    public Animal(long id, String nombre, String especie, String sexo,
                  String edadAproximada, String condicion,
                  LocalDate fechaIngreso, EstadoAnimal estado) {
        this.id = id;
        this.nombre = nombre;
        this.especie = especie;
        this.sexo = sexo;
        this.edadAproximada = edadAproximada;
        this.condicion = condicion;
        this.fechaIngreso = fechaIngreso;
        this.estado = estado;
    }

    public long getId() { return id; }
    public String getNombre() { return nombre; }
    public String getEspecie() { return especie; }
    public String getSexo() { return sexo; }
    public String getEdadAproximada() { return edadAproximada; }
    public String getCondicion() { return condicion; }
    public LocalDate getFechaIngreso() { return fechaIngreso; }
    public EstadoAnimal getEstado() { return estado; }
    public void setEstado(EstadoAnimal estado) { this.estado = estado; }
}
