package edu.mum.main;


import edu.mum.domain.Car;
import edu.mum.domain.Owner;
import edu.mum.service.CarService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.persistence.EntityManagerFactory;
import java.text.ParseException;
import java.util.List;

public class CarApp {
    private static EntityManagerFactory emf;

    public static void main(String[] args) throws ParseException {
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("context/applicationContext.xml");

        CarService carService = (CarService) ctx.getBean("carServiceImpl");


        // Create new instance of Car, Owner and set values in it
        Owner owner = new Owner("Owner 01", "1234 North 4th, FairField, Iowa");
        Car car = new Car("Car 01", owner);
//        ownerService.save(owner);

        // save the Car
        carService.save(car);
        car = new Car("Car 02", owner);
        carService.update(car);

        owner = new Owner("Owner 02", "1000 North 4th, FairField, Iowa");
        car = new Car("Car 03", owner);
        carService.save(car);

        car = new Car("Car 04", owner);
        carService.update(car);

        List<Car> cars = carService.findAll();
        System.out.println("************** Cars **************");
        for (Car c : cars) {
            System.out.println(c);
        }
    }

}