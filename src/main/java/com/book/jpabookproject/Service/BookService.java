package com.book.jpabookproject.Service;

import com.book.jpabookproject.Base.BaseService;
import com.book.jpabookproject.Entity.Auther;
import com.book.jpabookproject.Entity.Book;
import com.book.jpabookproject.Error.RecordNotFoundExecption;
import com.book.jpabookproject.Repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService extends BaseService<Book,Long> {
    @Autowired
    private BookRepo bookRepo;

    @Override
    @Cacheable(value = "auther", key = "#id")
    public Book findById(Long id) {
        if(bookRepo.findById(id).isPresent()){
            return bookRepo.findById(id).get();
        }
        throw new RecordNotFoundExecption("this record with the id " + id + " not found");
    }

    @Override
    @Cacheable(value = "auther", key = "#root.methodName")
    public List<Book> findAll() {
//        if (bookRepo.findAll().isEmpty()) {
//            throw new RecordNotFoundExecption("Data Not Found");
//        }else{
            return bookRepo.findAll();
      //  }
    }
    @Override
    @CacheEvict(value = {"auther"} , key ="#root.methodName", allEntries = true)
    public Book update(Book entity) {
        Book book = findById(entity.getId());
        book.setName(entity.getName());
        return super.update(entity);
    }
}
