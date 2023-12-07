package com.cnss.back.Mapper;

import com.cnss.back.Entity.Reclamation;
import com.cnss.back.Entity.User;
import com.cnss.back.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReclamationMapper {
    @Autowired
    private UserRepository userRepository;

    public Reclamation ReclamationDtoToReclamation(com.dev.back.Dto.ReclamationDto reclamationDto){
        Reclamation reclamation=new Reclamation();
        reclamation.setText(reclamationDto.getText());
        if(reclamationDto.getUserId()!=null){
            User user=userRepository.findById(reclamationDto.getUserId()).orElseThrow(()->new IllegalArgumentException("No user with id ="+reclamationDto.getUserId()));
            reclamation.setUser(user);
        }
        return reclamation;
    }
}
