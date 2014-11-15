package org.dworski;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitialSpringConfig {

    @Bean
    public Car getCar() {
        Car car = new Car();
        car.setMake("SEAT");
        car.setProductionYear(2010);
        return car;
    }
}
