package edu.mum.cs544.service;

import edu.mum.cs544.domain.Book;
import edu.mum.cs544.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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