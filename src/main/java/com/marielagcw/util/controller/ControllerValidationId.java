package com.marielagcw.util.controller;

import com.marielagcw.exception.GlobalExceptionHandler;
import com.marielagcw.util.IValidation;
import org.apache.log4j.Logger;
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
