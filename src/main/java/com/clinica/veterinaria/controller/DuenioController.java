package com.clinica.veterinaria.controller;

import com.clinica.veterinaria.model.Duenio;
import com.clinica.veterinaria.service.IDuenioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/duenio")
public class DuenioController {
    @Autowired
    private IDuenioService duenioServ;

    // GET
    @GetMapping("/todos")
    @ResponseBody
    public List<Duenio> getDuenios() {
        return duenioServ.getDuenios();
    }

    @GetMapping("/traer/{id}")
    @ResponseBody
    public Duenio getDuenio(@PathVariable Long id) {
        return duenioServ.getDuenio(id);
    }

    // POST
    @PostMapping("/crear")
    public String saveDuenio(@RequestBody Duenio duenio) {
        duenioServ.saveDuenio(duenio);
        return "Dueño guardado con exito";
    }

    // PUT
    @PutMapping("/editar")
    public Duenio editDuenio(@RequestBody Duenio duenio) {
        duenioServ.saveDuenio(duenio);
        return duenioServ.getDuenio(duenio.getId());
    }

    // DELETE
    @DeleteMapping("/borrar/{id}")
    public String deleteDuenio(@PathVariable Long id) {
        duenioServ.deleteDuenio(id);
        return "Dueño eliminado";
    }
}
