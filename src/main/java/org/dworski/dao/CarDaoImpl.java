package org.dworski.dao;

import org.dworski.entity.Car;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class CarDaoImpl implements CarDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Car car) {
        entityManager.persist(car);
    }

    @Override
    public Car load(Long id) {
        return entityManager.find(Car.class, id);
    }
}
