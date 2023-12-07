package com.cnss.back.Repository;

import com.cnss.back.Entity.Reclamation;
import com.cnss.back.Entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ReclamationRepository extends PagingAndSortingRepository<Reclamation,Long> {
    List<Reclamation> findByUser_Id(Long id);
    Page<Reclamation> findAll(Pageable pageable);


}
