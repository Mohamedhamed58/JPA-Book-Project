package com.book.jpabookproject.Repository;

import com.book.jpabookproject.Base.BaseRepository;
import com.book.jpabookproject.Entity.Auther;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AutherRepo extends BaseRepository<Auther, Long> , JpaSpecificationExecutor<Auther> {
//    @Override
//	@EntityGraph(attributePaths = "books")
//    List<Auther> findAll() ;
//
//    @Override
//	@EntityGraph(attributePaths = "books")
//    Optional<Auther> findById(Long id) ;
//    @Transactional
//    @Modifying
//    @Query(value = "UPDATE Auther a set a.isDeleted = false where a.id=?1")
//    public void restoreById(Long id);

    Optional<Auther> findByEmail(String email);
}
