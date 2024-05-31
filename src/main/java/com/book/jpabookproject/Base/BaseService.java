package com.book.jpabookproject.Base;

import com.book.jpabookproject.Entity.Auther;
import com.book.jpabookproject.Error.RecordNotFoundExecption;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.MappedSuperclass;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@MappedSuperclass
public class BaseService <T extends BaseEntity,ID extends Number> {
    @Autowired
    BaseRepository<T, ID> baseRepository;

    public T getById(ID id) {
        Optional<T> entity = Optional.of(baseRepository.getReferenceById(id));
        if (entity.isPresent()) {
            return entity.get();
        } else {
            throw new RecordNotFoundExecption("this record with the id " + id + "not found");
        }
        //return baseRepository.findById(id).orElseThrow();
    }

    public T findById(ID id) {

        Optional<T> entity = baseRepository.findById(id);
        if (entity.isPresent()) {
            return entity.get();
        }else {
            return null;
        }
    }

    public List<T> findAll() {
//        if (baseRepository.findAll().isEmpty()) {
//            throw new RecordNotFoundExecption("this record is empty");
//        }
        return baseRepository.findAll();
    }

    public T insert(T entity) {

        if (entity.getId() != null) {

            throw new RuntimeException();
        }

        return baseRepository.save(entity);
    }

    public List<T> insertAll(List<T> entity) {

        return baseRepository.saveAll(entity);
    }

    public T update(T entity) {

        return baseRepository.save(entity);
    }

    public T deleteById(ID id) {
        if (baseRepository.existsById(id)) {
            baseRepository.deleteById(id);
        } else {
            throw new RecordNotFoundExecption("this record with the id " + id + " already deleted");
        }
        return null;
    }

    public void deleteByAutherId(Long id) {

    }
}
