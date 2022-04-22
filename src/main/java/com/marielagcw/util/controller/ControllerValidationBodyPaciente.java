package com.marielagcw.util.controller;

import com.marielagcw.model.dto.PacienteDTO;
import com.marielagcw.util.IValidation;
import org.springframework.stereotype.Component;

@Component
public class ControllerValidationBodyPaciente implements IValidation<PacienteDTO> {

    @Override
    public boolean validate(PacienteDTO pacienteDTO) {
        return pacienteDTO.getNombre() != null && pacienteDTO.getApellido() != null && pacienteDTO.getDni() != null;
    }
}
