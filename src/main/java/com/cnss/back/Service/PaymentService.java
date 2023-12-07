package com.cnss.back.Service;

import com.cnss.back.Entity.Payment;
import com.cnss.back.Entity.Reclamation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PaymentService extends ServiceAbstraction<Payment> {
    List<Payment> findByEmployeur_Assures_Id(Integer pageNo, Integer pageSize, String sortBy, Long id);
    List<Payment> findByEmployeur_Id(Integer pageNo, Integer pageSize, String sortBy,Long id);


}
