package com.unal.cronus.model.service;

import java.util.Optional;

public interface GenericService<E,T> {
    Optional<E> findById(T id);
    E save(E entidad);
    void deleteById(T id);
}
