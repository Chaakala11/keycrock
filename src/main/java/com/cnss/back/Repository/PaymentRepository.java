package com.cnss.back.Repository;

import com.cnss.back.Entity.Payment;
import com.cnss.back.Entity.Reclamation;
import com.cnss.back.Entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PaymentRepository extends PagingAndSortingRepository<Payment,Long> {
    Page<Payment> findAll(Pageable pageable);

    Page<Payment> findByEmployeur_Assures_Id(Pageable pageable,Long id);

    Page<Payment> findByEmployeur_Id(Pageable pageable,Long id);


}
