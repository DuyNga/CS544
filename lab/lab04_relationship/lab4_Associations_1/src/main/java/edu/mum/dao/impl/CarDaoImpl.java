package edu.mum.dao.impl;

import edu.mum.dao.CarDao;
import edu.mum.domain.Car;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CarDaoImpl extends GenericDaoImpl<Car> implements CarDao {
    public CarDaoImpl() {
        super.setDaoType(Car.class);
    }
}
