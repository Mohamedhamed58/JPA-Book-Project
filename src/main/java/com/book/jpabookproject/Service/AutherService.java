package com.book.jpabookproject.Service;
import com.book.jpabookproject.Base.BaseService;
import com.book.jpabookproject.Entity.Auther;
import com.book.jpabookproject.Entity.AutherSearch;
import com.book.jpabookproject.Error.DuplicateRecoredException;
import com.book.jpabookproject.Error.RecordNotFoundExecption;
import com.book.jpabookproject.Repository.AutherRepo;
import com.book.jpabookproject.Repository.AutherSpec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutherService extends BaseService<Auther,Long> {
    @Autowired
    private AutherRepo autherRepo;

    Logger log = LoggerFactory.getLogger(AutherService.class);
@Override
@Cacheable(value = "auther", key = "#root.methodName")
public List<Auther> findAll() {
//    if (autherRepo.findAll().isEmpty()) {
//        throw new RecordNotFoundExecption("Data Not Found");
//    }else{
        return autherRepo.findAll();
 //   }
}
    @Override
    @Cacheable(value = "auther", key = "#id")
    public Auther findById(Long id) {
    if(autherRepo.findById(id).isPresent()){
        return autherRepo.findById(id).get();
    }
        throw new RecordNotFoundExecption("this record with the id " + id + " not found");
    }
    @Override
	@CacheEvict(value = {"auther"} , key ="#root.methodName", allEntries = true)
    public Auther insert(Auther entity) {

        if (!entity.getEmail().isEmpty() && entity.getEmail() != null) {
            Optional<Auther> auther = findByEmail(entity.getEmail());
            log.info("author name is {} and email is {} " , entity.getName() , entity.getEmail());
            if(auther.isPresent()) {
                log.error("This email already found with anther author");
                throw new DuplicateRecoredException("This email already found with anther author");
            }
        }
        return super.insert(entity);
    }
    public List<Auther> findByAutherSpec(AutherSearch search) {
        AutherSpec spec = new AutherSpec(search);
        return autherRepo.findAll(spec);
    }
    @Override
    @CacheEvict(value = {"auther"} , key ="#root.methodName", allEntries = true)
    public Auther update(Auther entity) {
		Auther auther = findById(entity.getId());
		auther.setName(entity.getName());
        return super.update(entity);
    }
    private Optional<Auther> findByEmail(String email) {
    return autherRepo.findByEmail(email);
    }
}
