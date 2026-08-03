package mx.org.patitasunidas.sipu.service;

import mx.org.patitasunidas.sipu.model.EstadoAnimal;

public class EstadoAnimalService {

    public boolean esTransicionValida(EstadoAnimal actual, EstadoAnimal siguiente) {
        if (actual == null || siguiente == null || actual == siguiente) {
            return false;
        }
        return switch (actual) {
            case RESCATADO -> siguiente == EstadoAnimal.EN_TRATAMIENTO
                    || siguiente == EstadoAnimal.DISPONIBLE;
            case EN_TRATAMIENTO -> siguiente == EstadoAnimal.DISPONIBLE;
            case DISPONIBLE -> siguiente == EstadoAnimal.EN_EVALUACION;
            case EN_EVALUACION -> siguiente == EstadoAnimal.DISPONIBLE
                    || siguiente == EstadoAnimal.ADOPTADO;
            case ADOPTADO -> siguiente == EstadoAnimal.EN_SEGUIMIENTO;
            case EN_SEGUIMIENTO -> false;
        };
    }
}
