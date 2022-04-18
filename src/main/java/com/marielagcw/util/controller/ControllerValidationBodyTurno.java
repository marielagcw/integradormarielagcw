package com.marielagcw.util.controller;


import com.marielagcw.model.dto.TurnoDTO;
import com.marielagcw.util.IValidationBody;
import org.springframework.stereotype.Component;

@Component
public class ControllerValidationBodyTurno implements IValidationBody<TurnoDTO> {

    @Override
    public boolean bodyValidation(TurnoDTO turnoDTO) {
        boolean validation;
        if (turnoDTO.getFechaHora() != null && turnoDTO.getOdontologo().getId()> 0 && turnoDTO.getPaciente().getId() > 0) {
            validation = true;
        } else validation = false;
        return validation;
    }
}
