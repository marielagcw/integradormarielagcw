package com.marielagcw.util.controller;

import com.marielagcw.model.dto.TurnoDTO;
import com.marielagcw.util.IValidation;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ControllerValidationBodyTurno implements IValidation<TurnoDTO> {

    @Override
    public boolean validate(TurnoDTO turnoDTO) {
        return turnoDTO.getFechaHora() != null && turnoDTO.getFechaHora().isAfter(LocalDateTime.now()) && turnoDTO.getOdontologo().getId() > 0 && turnoDTO.getPaciente().getId() > 0;
    }
}
