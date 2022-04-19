package com.marielagcw.util.controller;

import com.marielagcw.model.dto.OdontologoDTO;
import com.marielagcw.util.IValidation;
import org.springframework.stereotype.Component;

@Component
public class ControllerValidationBodyOdontologo implements IValidation<OdontologoDTO> {

    @Override
    public boolean validate(OdontologoDTO odontologoDTO) {
        boolean validation;
        if (odontologoDTO.getNombre() != null && odontologoDTO.getApellido() != null) {
            validation = true;
        } else validation = false;
        return validation;
    }
}
