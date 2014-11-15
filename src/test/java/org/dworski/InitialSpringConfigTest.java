package org.dworski;

import org.dworski.dao.CarDao;
import org.dworski.entity.Car;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class, loader = AnnotationConfigContextLoader.class)
@Transactional
public class InitialSpringConfigTest {

    @Autowired
    private CarDao carDao;


    @Test
    public void shouldGetCarObjectFromContext() {
        Car car = new Car();
        car.setMake("SEAT");
        car.setProductionYear(2010);
        carDao.save(car);

        Car loadedCar = carDao.load(car.getId());

        assertEquals(car.getId(), loadedCar.getId());
        assertEquals(car.getMake(), loadedCar.getMake());
        assertEquals(car.getProductionYear(), loadedCar.getProductionYear());

    }

}
