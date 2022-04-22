package com.marielagcw.util.controller;

import com.marielagcw.model.dto.OdontologoDTO;
import com.marielagcw.util.IValidation;
import org.springframework.stereotype.Component;

@Component
public class ControllerValidationBodyOdontologo implements IValidation<OdontologoDTO> {

    @Override
    public boolean validate(OdontologoDTO odontologoDTO) {
        return odontologoDTO.getNombre() != null && odontologoDTO.getApellido() != null && odontologoDTO.getNumeroMatricula() != null;
    }
}
