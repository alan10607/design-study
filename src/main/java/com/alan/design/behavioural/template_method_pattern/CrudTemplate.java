package com.alan.design.behavioural.template_method_pattern;

import com.alan.design.behavioural.template_method_pattern.entity.CrudEntity;
import com.alan.design.behavioural.template_method_pattern.repository.Repository;

public abstract class CrudTemplate<E extends CrudEntity> {

    public E create(E entity) {
        getRepository().findById(entity.getId())
                .ifPresent(existing -> {
                    throw new IllegalStateException("Entity already exists");
                });

        // template method here
        validate(entity);
        beforeCreate(entity);
        return getRepository().save(entity);
    }

    protected abstract Repository<E> getRepository();

    protected abstract void validate(E entity);

    protected abstract void beforeCreate(E entity);
}
