package edu.mum.cs544;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
//@Transactional
public class BookService {
    //    @Resource
    @Autowired
    private BookRepository carDao;

    public List<Book> getAll() {
        return carDao.findAll();
    }

    public void add(Book car) {
        carDao.save(car);
    }

    public Book get(int id) {
//        Optional<Book> optionalBook = carDao.findById(id);
//
//        return optionalBook.isPresent() ? optionalBook.get() : null;
        return carDao.getOne(id);
    }

    public void update(Book car) {
        carDao.save(car);
    }

    public void delete(int id) {
        carDao.deleteById(id);
    }
}