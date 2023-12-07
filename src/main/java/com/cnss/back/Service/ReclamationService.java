package com.cnss.back.Service;

import com.cnss.back.Entity.Reclamation;
import com.cnss.back.Entity.User;

import java.util.List;

public interface ReclamationService extends ServiceAbstraction<Reclamation> {
    List<Reclamation> findByUser_Id(Long id);
    Reclamation solveReclamation(Long id);
}
