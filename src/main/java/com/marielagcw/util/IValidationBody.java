package com.marielagcw.util;

import org.springframework.stereotype.Component;

@Component
public interface IValidationBody<T> {
    public boolean bodyValidation(T t);
}
