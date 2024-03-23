package com.clinica.veterinaria.service;

import com.clinica.veterinaria.model.Duenio;

import java.util.List;

public interface IDuenioService {
    public List<Duenio> getDuenios();
    public Duenio getDuenio(Long id);

    public void saveDuenio(Duenio duenio);
    public void deleteDuenio(Long id);
    public void editDuenio(Duenio duenio);
}
