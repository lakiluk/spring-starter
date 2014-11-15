package org.dworski;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = InitialSpringConfig.class, loader = AnnotationConfigContextLoader.class)
public class InitialSpringConfigTest {

    @Autowired
    private Car car;

    @Value("${car.make}")
    private String carMake;

    @Value("${car.productionYear}")
    private String carProductionYear;

    @Test
    public void shouldGetCarObjectFromContext() {
        assertNotNull(car);
        assertEquals(carMake, car.getMake());
        assertEquals(carProductionYear, String.valueOf(car.getProductionYear()));
    }

}
