package org.dworski;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Test
    public void shouldGetCarObjectFromContext() {
        assertNotNull(car);
        assertEquals("SEAT", car.getMake());
        assertEquals(2010, car.getProductionYear());
    }

}
