package org.dworski.dao;

import org.dworski.entity.Car;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CarDaoImpl implements CarDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Car car) {
        sessionFactory.getCurrentSession().save(car);
    }

    @Override
    public Car load(Long id) {
        return (Car) sessionFactory.getCurrentSession().load(Car.class, id);
    }
}
