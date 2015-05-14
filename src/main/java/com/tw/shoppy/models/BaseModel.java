package com.tw.shoppy.models;

import com.tw.shoppy.BeanUtil;

import javax.persistence.EntityManager;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Optional;

@MappedSuperclass
public abstract class BaseModel<T> {

    public static class Repo<T> {
        private Class<T> klass;

        public Repo(Class<T> klass) {
            this.klass = klass;
        }

        public List<T> all() {
            CriteriaBuilder criteriaBuilder = entityManager().getCriteriaBuilder();
            CriteriaQuery<T> query = criteriaBuilder.createQuery(klass);

            Root<T> table = query.from(klass);

            return entityManager()
                    .createQuery(
                            query.select(table))
                    .getResultList();
        }

        public Optional<T> find(Long primaryKey) {
            return Optional.ofNullable(entityManager().find(klass, primaryKey));
        }

    }

    @SuppressWarnings("unchecked")
    public T saveIt() {
        entityManager().persist(this);
        return (T) this;
    }

    private static EntityManager entityManager() {
        return BeanUtil.getBean(EntityManager.class);
    }
}
