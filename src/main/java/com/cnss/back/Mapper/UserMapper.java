package com.cnss.back.Mapper;

import com.cnss.back.Dto.UserDto;
import com.cnss.back.Entity.Office;
import com.cnss.back.Entity.User;
import com.cnss.back.Repository.AuthorityRepository;
import com.cnss.back.Repository.OfficeRepository;
import com.cnss.back.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserMapper {
    @Autowired
    private AuthorityRepository authorityRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OfficeRepository officeRepository;
    public User UserDtoToUser(UserDto userDto){
        User user =new User();
        user.setEmail(userDto.getEmail());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setBirthDate(userDto.getBirthDate());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setCin(userDto.getCin());
        user.setGender(userDto.getGender());
        user.setActivity(userDto.getActivity());
        user.setRib(userDto.getRib());
        if(userDto.getOfficeId()!=null){
            Office office=officeRepository.findById(userDto.getOfficeId()).orElseThrow(()->new IllegalArgumentException("No office with id ="+userDto.getOfficeId()));
            user.setOffice(office);
        }
        if (userDto.getEmployeurId()!=null){
            User user1=userRepository.findById(userDto.getEmployeurId()).orElseThrow(()->new IllegalArgumentException("No user with id ="+userDto.getEmployeurId()));
            user.setEmployeur(user1);
        }
        if (userDto.getAuthorityId()!=null){
                user.setAuthority(authorityRepository.findById(userDto.getAuthorityId()).orElseThrow(()->new IllegalArgumentException("No authority with id ="+userDto.getAuthorityId())));
        }
        return user;
    }
}
