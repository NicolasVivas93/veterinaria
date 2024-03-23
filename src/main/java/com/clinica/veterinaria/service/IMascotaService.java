package com.clinica.veterinaria.service;

import com.clinica.veterinaria.dto.MascotaDuenioDTO;
import com.clinica.veterinaria.model.Mascota;

import java.util.List;

public interface IMascotaService {

    public List<Mascota> getMascotas();
    public Mascota getMascota(Long id);

    public void saveMascota(Mascota mascota);
    public void deleteMascota(Long id);
    public void editMascota(Mascota mascota);

    public List<Mascota> getEspecieRaza(String especie, String raza);

    public List<MascotaDuenioDTO> getMascotaDuenio();
}
