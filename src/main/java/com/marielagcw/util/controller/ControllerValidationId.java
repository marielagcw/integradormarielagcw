package com.marielagcw.util.controller;

import org.springframework.stereotype.Component;

@Component
public class ControllerValidationId{
    public boolean idValidation(Integer id) {
        boolean validation;
        if (id > 0) {
            validation = true;
        } else validation = false;
        return validation;
    }
}
