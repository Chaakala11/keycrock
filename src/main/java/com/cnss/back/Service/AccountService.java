package com.cnss.back.Service;

import com.cnss.back.Entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface AccountService extends ServiceAbstraction<User> {
    public User ValidUser(Long id);
    public User loadUserByUsername(String username);
    public void addRoleToUser(String username, String rolename);
    public Long getTotal();
    public List<User> getAll(Integer pageNo, Integer pageSize, String sortBy);
    List<User> findByAuthority_Role(String role,Integer pageNo, Integer pageSize, String sortBy);
    List<User> findByEmployeur_Id(Long id,Integer pageNo, Integer pageSize, String sortBy);


}
