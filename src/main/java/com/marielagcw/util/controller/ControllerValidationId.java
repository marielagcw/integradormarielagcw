package com.marielagcw.util.controller;

import com.marielagcw.util.IValidation;
import org.springframework.stereotype.Component;

@Component
public class ControllerValidationId implements IValidation<Integer> {

    public boolean validate(Integer id) {
        boolean validation;
        if (id > 0) {
            validation = true;
        } else validation = false;
        return validation;
    }
}
