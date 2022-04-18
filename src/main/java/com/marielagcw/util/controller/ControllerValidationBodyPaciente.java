package com.marielagcw.util.controller;

import com.marielagcw.model.dto.PacienteDTO;
import com.marielagcw.util.IValidationBody;
import org.springframework.stereotype.Component;

@Component
public class ControllerValidationBodyPaciente implements IValidationBody<PacienteDTO> {

    @Override
    public boolean bodyValidation(PacienteDTO pacienteDTO) {
        boolean validation;
        if (pacienteDTO.getNombre() != null && pacienteDTO.getApellido() != null && pacienteDTO.getDni() != null) {
            validation = true;
        } else validation = false;
        return validation;
    }
}
