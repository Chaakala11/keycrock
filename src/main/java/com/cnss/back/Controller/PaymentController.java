package com.cnss.back.Controller;

import com.cnss.back.Dto.PaymentDto;
import com.cnss.back.Dto.UserDto;
import com.cnss.back.Entity.Payment;
import com.cnss.back.Entity.User;
import com.cnss.back.Mapper.PaymentMapper;
import com.cnss.back.Mapper.UserMapper;
import com.cnss.back.Service.AccountService;
import com.cnss.back.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @Autowired
    private PaymentMapper modelMapper;

    @PostMapping
    public Payment add(@RequestBody PaymentDto paymentDto){
        Payment payment=modelMapper.PaymentDtoToPayment(paymentDto);
        return  paymentService.add(payment);
    }
    @GetMapping
    public ResponseEntity<?> getAll(@RequestParam(defaultValue = "0") Integer pageNo,
                                    @RequestParam(defaultValue = "10") Integer pageSize,
                                    @RequestParam(defaultValue = "id") String sortBy) {

        return new ResponseEntity<>(paymentService.getAll(pageNo,pageSize,sortBy), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Long id) {
        return new ResponseEntity<>(paymentService.get(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        paymentService.delete(id);
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @GetMapping("/find-by-assure/{id}")
    public ResponseEntity<?> findByEmployeur_Assures_Id(@PathVariable("id") Long id,
                                 @RequestParam(defaultValue = "0") Integer pageNo,
                                 @RequestParam(defaultValue = "10") Integer pageSize,
                                 @RequestParam(defaultValue = "id") String sortBy) {
        return new ResponseEntity<>(paymentService.findByEmployeur_Assures_Id(pageNo,pageSize,sortBy,id), HttpStatus.OK);
    }

    @GetMapping("/find-by-employeur/{id}")
    public ResponseEntity<?> findByEmployeur_Id(@PathVariable("id") Long id,
                                                        @RequestParam(defaultValue = "0") Integer pageNo,
                                                        @RequestParam(defaultValue = "10") Integer pageSize,
                                                        @RequestParam(defaultValue = "id") String sortBy) {
        return new ResponseEntity<>(paymentService.findByEmployeur_Id(pageNo,pageSize,sortBy,id), HttpStatus.OK);
    }





}

