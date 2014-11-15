package org.dworski;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@Configuration
public class InitialSpringConfig {

    @Value("${car.make}")
    private String carMake;

    @Value("${car.productionYear}")
    private String carProductionYear;

    @Bean
    public static PropertySourcesPlaceholderConfigurer getPropertySourcesPlaceholderConfigurer() {
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        propertySourcesPlaceholderConfigurer.setLocations(new Resource[]{new ClassPathResource("org/dworski/car.properties")});
        return propertySourcesPlaceholderConfigurer;
    }


    @Bean
    public Car getCar() {
        Car car = new Car();
        car.setMake(carMake);
        car.setProductionYear(Integer.valueOf(carProductionYear));
        return car;
    }
}
