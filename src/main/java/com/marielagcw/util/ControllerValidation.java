package com.marielagcw.util;

import org.springframework.stereotype.Component;

@Component
public class ControllerValidation<T> {

    public boolean bodyValidation(T t) {
        if (t != null) {
            return true;
        }
        return false;
    }

    public boolean idValidation(Integer id) {
        if (id != null) {
            return true;
        }
        return false;
    }
}
