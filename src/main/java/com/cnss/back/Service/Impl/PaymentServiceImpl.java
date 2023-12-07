package com.cnss.back.Service.Impl;

import com.cnss.back.Entity.Payment;
import com.cnss.back.Entity.User;
import com.cnss.back.Repository.PaymentRepository;
import com.cnss.back.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    PaymentRepository paymentRepository;
    @Override
    public Payment add(Payment payment) {
        payment.setCreationDate(new Date());
        return paymentRepository.save(payment);
    }

    @Override
    public Payment update(Payment payment, Long id) {
        return null;
    }

    @Override
    public List<Payment> getAll(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<Payment> pagedResult = paymentRepository.findAll(paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public Payment get(Long id) {
        return paymentRepository.findById(id).orElseThrow(()->new IllegalArgumentException("No payment with id "+id));
    }

    @Override
    public void delete(Long id) {
        paymentRepository.delete(paymentRepository.findById(id).orElseThrow(()->new IllegalArgumentException("No payment with id "+id)));
    }

    @Override
    public List<Payment> findByEmployeur_Assures_Id(Integer pageNo, Integer pageSize, String sortBy, Long id) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<Payment> pagedResult = paymentRepository.findByEmployeur_Assures_Id(paging,id);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public List<Payment> findByEmployeur_Id(Integer pageNo, Integer pageSize, String sortBy, Long id) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<Payment> pagedResult = paymentRepository.findByEmployeur_Id(paging,id);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<>();
        }
    }
}
