package com.cnss.back.Mapper;

import com.cnss.back.Dto.PaymentDto;
import com.cnss.back.Entity.Payment;
import com.cnss.back.Entity.User;
import com.cnss.back.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentMapper {
    @Autowired
    private UserRepository userRepository;

    public Payment PaymentDtoToPayment(PaymentDto paymentDto){
        Payment payment=new Payment();
        payment.setLpaiModepai(paymentDto.getLpaiModepai());
        payment.setLpaiMontant(paymentDto.getLpaiMontant());
        if (paymentDto.getEmployeurId()!=null){
            User user1=userRepository.findById(paymentDto.getEmployeurId()).orElseThrow(()->new IllegalArgumentException("No user with id ="+paymentDto.getEmployeurId()));
            payment.setEmployeur(user1);
        }
        if (paymentDto.getAssureId()!=null){
            User user1=userRepository.findById(paymentDto.getAssureId()).orElseThrow(()->new IllegalArgumentException("No user with id ="+paymentDto.getAssureId()));
            payment.setAssure(user1);
        }
        return payment;
    }
}
