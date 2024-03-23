package com.clinica.veterinaria.controller;

import com.clinica.veterinaria.dto.MascotaDuenioDTO;
import com.clinica.veterinaria.model.Mascota;
import com.clinica.veterinaria.service.IMascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mascota")
public class MascotaController {

    @Autowired
    private IMascotaService mascotaServ;

    // GET
    @GetMapping("/todas")
    @ResponseBody
    public List<Mascota> getMascotas() {
        return mascotaServ.getMascotas();
    }

    @GetMapping("/traer/{id}")
    @ResponseBody
    public Mascota getMascota(@PathVariable Long id) {
        return mascotaServ.getMascota(id);
    }

    @GetMapping("/especieRaza")
    @ResponseBody
    public List<Mascota> getEspecieRaza(@RequestParam String especie, @RequestParam String raza) {
        return mascotaServ.getEspecieRaza(especie,raza);
    }

    @GetMapping("/mascotaDuenio")
    @ResponseBody
    public List<MascotaDuenioDTO> getMascotaDuenio() {
        return mascotaServ.getMascotaDuenio();
    }

    // POST
    @PostMapping("/crear")
    public String saveMascota(@RequestBody Mascota mascota) {
        mascotaServ.saveMascota(mascota);
        return "Mascota guardada con exito";
    }

    // PUT
    @PutMapping("/editar")
    public Mascota editMascota(@RequestBody Mascota mascota) {
        mascotaServ.saveMascota(mascota);
        return mascotaServ.getMascota(mascota.getId());
    }

    // DELETE
    @DeleteMapping("/borrar/{id}")
    public String deleteMascota(@PathVariable Long id) {
        mascotaServ.deleteMascota(id);
        return "Mascota eliminada";
    }
}
