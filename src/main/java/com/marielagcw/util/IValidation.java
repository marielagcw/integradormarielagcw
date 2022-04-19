package com.marielagcw.util;

import org.springframework.stereotype.Component;

@Component
public interface IValidation<T> {
    public boolean validate(T t);
}
