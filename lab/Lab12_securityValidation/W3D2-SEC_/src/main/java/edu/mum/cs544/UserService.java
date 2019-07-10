package edu.mum.cs544;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@Transactional
public class UserService {
    //    @Resource
    @Autowired
//    @Lazy
    private UserRepository carDao;

    public List<User> getAll() {
        return carDao.findAll();
    }

    public void add(User car) {
        carDao.save(car);
    }

    public User get(long id) {
//        Optional<User> optionalUser = carDao.findById(id);
//
//        return optionalUser.isPresent() ? optionalUser.get() : null;
        return carDao.getOne(id);
    }

    public void update(User car) {
        carDao.save(car);
    }

    public void delete(long id) {
        carDao.deleteById(id);
    }
}