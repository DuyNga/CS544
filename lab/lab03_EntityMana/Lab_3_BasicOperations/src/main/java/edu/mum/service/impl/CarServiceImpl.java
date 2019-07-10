package edu.mum.service.impl;

import edu.mum.dao.CarDao;
import edu.mum.domain.Car;
import edu.mum.domain.User;
import edu.mum.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Component
public class CarServiceImpl implements CarService {
    @Autowired
    CarDao carDao;
    @Override
    public void save(Car car) {
        carDao.save(car);
    }

    @Override
    public List<Car> findAll() {
        return carDao.findAll();
    }

    @Override
    public void update(Car car) {
         carDao.update(car);
    }
}
