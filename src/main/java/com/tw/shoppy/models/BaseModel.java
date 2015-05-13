package com.tw.shoppy.models;

import com.tw.shoppy.BeanUtil;

import javax.persistence.EntityManager;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import javax.persistence.criteria.CriteriaBuilder;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Optional;

@MappedSuperclass
public abstract class BaseModel<T> {

    @Transient
    private final Class<T> type;

    @SuppressWarnings("unchecked")
    public BaseModel() {
        this.type = ((Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0]);;
    }

    @SuppressWarnings("unchecked")
    public T saveIt() {
        entityManager().persist(this);
        return (T) this;
    }

    public Optional<T> find(Long primaryKey) {
        return Optional.ofNullable(entityManager().find(type, primaryKey));
    }

    public List<T> all() {
        CriteriaBuilder criteriaBuilder = entityManager().getCriteriaBuilder();
        return entityManager().createQuery(criteriaBuilder.createQuery(type)).getResultList();
    }

    private EntityManager entityManager() {
        return BeanUtil.getBean(EntityManager.class);
    }
}
