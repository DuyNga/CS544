package edu.mum.cs544;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
//@Transactional
public class AuthorityService {
    //    @Resource
    @Autowired
//    @Lazy
    private AuthorityRepository carDao;

    public List<Authority> getAll() {
        return carDao.findAll();
    }

//    public void add(User car) {
//        carDao.save(car);
//    }
//
    public Authority get(int id) {
        Optional<Authority> optionalUser = carDao.findById(id);

        return optionalUser.isPresent() ? optionalUser.get() : null;
//        return carDao.getOne(id);
    }
//
//    public void update(User car) {
//        carDao.save(car);
//    }
//
//    public void delete(long id) {
//        carDao.deleteById(id);
//    }
}