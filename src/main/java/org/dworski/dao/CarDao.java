package org.dworski.dao;

import org.dworski.entity.Car;

public interface CarDao {

    public void save(Car car);

    public Car load(Long id);
}
