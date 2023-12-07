package com.cnss.back.Service.Impl;

import com.cnss.back.Entity.Reclamation;
import com.cnss.back.Entity.User;
import com.cnss.back.Repository.ReclamationRepository;
import com.cnss.back.Service.ReclamationService;
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
public class ReclamationServiceImpl implements ReclamationService {
    @Autowired
    private ReclamationRepository reclamationRepository;
    @Override
    public List<Reclamation> findByUser_Id(Long id) {
        return reclamationRepository.findByUser_Id(id);
    }

    @Override
    public Reclamation solveReclamation(Long id) {
        Reclamation reclamation= reclamationRepository.findById(id).orElseThrow(()->new IllegalArgumentException("No reclamation with id "+id));
        reclamation.setResolved(true);
        return reclamationRepository.save(reclamation);
    }

    @Override
    public Reclamation add(Reclamation reclamation) {
        reclamation.setCreationDate(new Date());
        reclamation.setResolved(false);
        return reclamationRepository.save(reclamation);
    }

    @Override
    public Reclamation update(Reclamation reclamation, Long id) {
        return null;
    }

    @Override
    public List<Reclamation> getAll(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<Reclamation> pagedResult = reclamationRepository.findAll(paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public Reclamation get(Long id) {
        return reclamationRepository.findById(id).orElseThrow(()->new IllegalArgumentException("No reclamation with id "+id));
    }

    @Override
    public void delete(Long id) {
        Reclamation reclamation= reclamationRepository.findById(id).orElseThrow(()->new IllegalArgumentException("No reclamation with id "+id));
        reclamationRepository.delete(reclamation);
    }
}
