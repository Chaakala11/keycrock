package com.cnss.back.Repository;

import com.cnss.back.Entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends PagingAndSortingRepository<User,Long> {

    Page<User> findByAuthority_Role(String role,Pageable pageable);
    User findByEmailEquals(String email);

    Page<User> findByEmployeur_Id(Long id,Pageable pageable);


    long countByIsDeletedEquals(Boolean isDeleted);

    Page<User> findByIsDeletedEquals(Boolean isDeleted, Pageable pageable);

    User findByUsername(String username);

}
