package com.cnss.back.Service.Impl;



import com.cnss.back.Entity.Authority;
import com.cnss.back.Entity.User;
import com.cnss.back.Repository.AuthorityRepository;
import com.cnss.back.Repository.UserRepository;
import com.cnss.back.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    UserRepository appUserRepository;
    @Autowired
    AuthorityRepository appRoleRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public User ValidUser(Long id) {
        User user= appUserRepository.findById(id).orElseThrow(()->new IllegalArgumentException("No user with id "+id));
        user.setIsEnabled(true);
        return appUserRepository.save(user);

    }

    public User loadUserByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }

    public void addRoleToUser(String username, String rolename) {
        User appUser=appUserRepository.findByUsername(username);
        Authority appRole=appRoleRepository.findByRole(rolename);
        appUser.setAuthority(appRole);
    }

    @Override
    public Long getTotal() {
        return appUserRepository.countByIsDeletedEquals(false);
    }

    @Override
    public List<User> getAll(Integer pageNo, Integer pageSize, String sortBy) {

        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<User> pagedResult = appUserRepository.findAll(paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public List<User> findByAuthority_Role(String role, Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<User> pagedResult = appUserRepository.findByAuthority_Role(role,paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public List<User> findByEmployeur_Id(Long id, Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<User> pagedResult = appUserRepository.findByEmployeur_Id(id,paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public User add(User us) {
        User user=appUserRepository.findByUsername(us.getUsername());
        if(user!=null) throw new RuntimeException("User already exists");
        //if(!us.equals(confirmedPassword)) throw new RuntimeException("Please confirm your password");
        us.setIsEnabled(true);

        if(!us.getAuthority().getRole().equals("ROLE_ADMIN")){
            us.setIsEnabled(false);
        }
        us.setIsDeleted(false);
        us.setCreationDate(new Date());
        us.setPassword(bCryptPasswordEncoder.encode(us.getPassword()));
        appUserRepository.save(us);
        return us;
    }

    @Override
    public User update(User user, Long id) {
        return null;
    }



    @Override
    public User get(Long id) {
        return appUserRepository.findById(id).orElseThrow(()->new IllegalArgumentException("No user with id "+id));
    }

    @Override
    public void delete(Long id) {
        User user= appUserRepository.findById(id).orElseThrow(()->new IllegalArgumentException("No user with id "+id));
        user.setIsDeleted(true);
        appUserRepository.save(user);
    }
}