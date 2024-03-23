package com.clinica.veterinaria.service;

import com.clinica.veterinaria.dto.MascotaDuenioDTO;
import com.clinica.veterinaria.model.Mascota;
import com.clinica.veterinaria.repository.IMascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MascotaService implements IMascotaService {

    @Autowired
    private IMascotaRepository mascotaRepo;
    @Autowired
    private MascotaDuenioDTO mascotaDTO;

    @Override
    public List<Mascota> getMascotas() {
        return mascotaRepo.findAll();
    }

    @Override
    public Mascota getMascota(Long id) {
        return mascotaRepo.findById(id).orElse(null);
    }

    @Override
    public void saveMascota(Mascota mascota) {
        mascotaRepo.save(mascota);
    }

    @Override
    public void deleteMascota(Long id) {
        mascotaRepo.deleteById(id);
    }

    @Override
    public void editMascota(Mascota mascota) {
        mascotaRepo.save(mascota);
    }

    @Override
    public List<Mascota> getEspecieRaza(String especie, String raza) {
        List<Mascota> listaMascotas = mascotaRepo.findAll();
        List<Mascota> listaEspecif = new ArrayList<>();

        for (Mascota mascota : listaMascotas) {
            boolean condicion1 = mascota.getEspecie().toLowerCase().contains(especie.toLowerCase());
            boolean condicion2 = mascota.getRaza().toLowerCase().contains(raza.toLowerCase());
            if (condicion1 && condicion2) {
                listaEspecif.add(mascota);
            }
        }
        return listaEspecif;
    }

    @Override
    public List<MascotaDuenioDTO> getMascotaDuenio() {
        List<Mascota> listaMascotas = this.getMascotas();
        List<MascotaDuenioDTO> listaDTO = new ArrayList<>();

        for (Mascota mascota : listaMascotas) {
            mascotaDTO.setNombreMascota(mascota.getNombre());
            mascotaDTO.setEspecie(mascota.getEspecie());
            mascotaDTO.setRaza(mascota.getRaza());
            mascotaDTO.setNombreDuenio(mascota.getDuenio().getNombre());
            mascotaDTO.setApellidoDuenio(mascota.getDuenio().getApellido());
            listaDTO.add(mascotaDTO);
            mascotaDTO = new MascotaDuenioDTO(); //reseteo
        }
        return listaDTO;
    }
}
