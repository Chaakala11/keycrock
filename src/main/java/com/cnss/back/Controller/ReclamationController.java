package com.cnss.back.Controller;

import com.cnss.back.Entity.Reclamation;
import com.cnss.back.Mapper.ReclamationMapper;
import com.cnss.back.Service.ReclamationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/reclamations")
public class ReclamationController {
    @Autowired
    private ReclamationService reclamationService;
    @Autowired
    private ReclamationMapper modelMapper;

    @PostMapping
    public Reclamation add(@RequestBody com.dev.back.Dto.ReclamationDto reclamationDto){
        Reclamation reclamation=modelMapper.ReclamationDtoToReclamation(reclamationDto);
        return  reclamationService.add(reclamation);
    }
    @GetMapping
    public ResponseEntity<?> getAll(@RequestParam(defaultValue = "0") Integer pageNo,
                                    @RequestParam(defaultValue = "10") Integer pageSize,
                                    @RequestParam(defaultValue = "id") String sortBy) {

        return new ResponseEntity<>(reclamationService.getAll(pageNo,pageSize,sortBy), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Long id) {
        return new ResponseEntity<>(reclamationService.get(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        reclamationService.delete(id);
        return new ResponseEntity<>( HttpStatus.OK);
    }
    @PostMapping("/solve/{id}")
    public ResponseEntity<?> solveReclamation(@PathVariable("id") Long id) {
        return new ResponseEntity<>(reclamationService.solveReclamation(id), HttpStatus.OK);
    }
}

