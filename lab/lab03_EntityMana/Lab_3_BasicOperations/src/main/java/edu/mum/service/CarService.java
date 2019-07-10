package edu.mum.service;

import edu.mum.domain.Car;
import edu.mum.domain.User;

import java.util.List;

public interface CarService {

    public void save(Car car);

    public List<Car> findAll();

    public void update(Car car);

}
