package com.cnss.back.Controller;

import com.cnss.back.Mapper.UserMapper;
import com.cnss.back.Service.AccountService;
import com.cnss.back.Dto.UserDto;
import com.cnss.back.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private UserMapper modelMapper;
    @PostMapping
    public User add(@RequestBody UserDto userDto){
        User user=modelMapper.UserDtoToUser(userDto);
        return  accountService.add(user);
    }
    @GetMapping
    public ResponseEntity<?> getAll(@RequestParam(defaultValue = "0") Integer pageNo,
                                    @RequestParam(defaultValue = "10") Integer pageSize,
                                    @RequestParam(defaultValue = "id") String sortBy) {

        return new ResponseEntity<>(accountService.getAll(pageNo,pageSize,sortBy), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Long id) {
        return new ResponseEntity<>(accountService.get(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        accountService.delete(id);
        return new ResponseEntity<>( HttpStatus.OK);
    }
    @GetMapping("/get-total")
    public ResponseEntity<?> getTotal() {
        return new ResponseEntity<>(accountService.getTotal(), HttpStatus.OK);
    }

    //validation
    @PostMapping("/valid-user/{id}")
    public ResponseEntity<?> validUser(@PathVariable("id") Long id){
        return new ResponseEntity<>(accountService.ValidUser(id), HttpStatus.OK);
    }

    @GetMapping("/get-by-role/{role}")
    public ResponseEntity<?> findByAuthority_Role(@PathVariable("role") String role,
                                                  @RequestParam(defaultValue = "0") Integer pageNo,
                                                  @RequestParam(defaultValue = "10") Integer pageSize,
                                                  @RequestParam(defaultValue = "id") String sortBy) {
        return new ResponseEntity<>(accountService.findByAuthority_Role(role, pageNo, pageSize, sortBy), HttpStatus.OK);
    }




























































    @GetMapping("/get-by-employeur/{id}")
    public ResponseEntity<?> findByEmployeur_Id(@PathVariable("id") Long id,
                                                @RequestParam(defaultValue = "0") Integer pageNo,
                                                @RequestParam(defaultValue = "10") Integer pageSize,
                                                @RequestParam(defaultValue = "id") String sortBy) {
        return new ResponseEntity<>(accountService.findByEmployeur_Id(id, pageNo, pageSize, sortBy), HttpStatus.OK);
    }

}

