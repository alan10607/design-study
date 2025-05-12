package com.alan.design.behavioural.template_method_pattern.repository;

import java.util.Optional;

public interface Repository<E> {
    Optional<E> findById(long id);

    E save(E entity);
}
