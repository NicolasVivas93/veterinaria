package com.clinica.veterinaria.service;

import com.clinica.veterinaria.model.Duenio;
import com.clinica.veterinaria.repository.IDuenioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DuenioService implements IDuenioService {

    @Autowired
    private IDuenioRepository duenioRepo;

    @Override
    public List<Duenio> getDuenios() {
        return duenioRepo.findAll();
    }

    @Override
    public Duenio getDuenio(Long id) {
        return duenioRepo.findById(id).orElse(null);
    }

    @Override
    public void saveDuenio(Duenio duenio) {
        duenioRepo.save(duenio);
    }

    @Override
    public void deleteDuenio(Long id) {
        duenioRepo.deleteById(id);
    }

    @Override
    public void editDuenio(Duenio duenio) {
        duenioRepo.save(duenio);
    }
}
