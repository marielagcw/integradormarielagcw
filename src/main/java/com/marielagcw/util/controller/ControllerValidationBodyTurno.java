package com.marielagcw.util.controller;


import com.marielagcw.model.dto.TurnoDTO;
import com.marielagcw.util.IValidation;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ControllerValidationBodyTurno implements IValidation<TurnoDTO> {

    @Override
    public boolean validate(TurnoDTO turnoDTO) {
        boolean validation;
        if (turnoDTO.getFechaHora() != null && turnoDTO.getFechaHora().isAfter(LocalDateTime.now()) && turnoDTO.getOdontologo().getId() > 0 && turnoDTO.getPaciente().getId() > 0) {
            validation = true;
        } else
            validation = false;
        return validation;
    }
}
