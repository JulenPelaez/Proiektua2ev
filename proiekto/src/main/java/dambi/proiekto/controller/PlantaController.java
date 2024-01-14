package dambi.proiekto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import dambi.proiekto.model.Planta;
import dambi.proiekto.repositorio.PlantaRepositorio;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

import java.util.List;

@RestController
@RequestMapping("api/planta")
public class PlantaController {

    @Autowired
    private PlantaRepositorio plantaRepositorio;

    // Aplikazioak eskatutako landaketa guztiak itzuli
    @GetMapping
    public List<Planta> getPlants() {
        return plantaRepositorio.getPlants();
    }

    // Emandako "id"-ren arabera lantegia bilatu eta erantzuna itzuli
    @GetMapping("/{id}")
    public ResponseEntity<Planta> getPlantById(@PathVariable String id) {
        Planta planta = plantaRepositorio.getPlantById(id);

        if (planta != null) {
            return new ResponseEntity<>(planta, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Emandako "tipo"aren arabera lantegiak bilatu eta itzuli
    @GetMapping("/tipo/{tipo}")
    public List<Planta> getPlantsByType(@PathVariable String tipo) {
        return plantaRepositorio.getPlantsByType(tipo);
    }

    // Emandako "nombre"aren arabera lantegiak bilatu eta itzuli
    @GetMapping("/nombre/{nombre}")
    public List<Planta> getPlantsByName(@PathVariable String nombre) {
        return plantaRepositorio.getPlantsByName(nombre);
    }

    // Lantegi berria gehitu
    @PostMapping
    public Planta addPlant(@RequestBody Planta planta) {
        return plantaRepositorio.addPlant(planta);
    }

    // Emandako "id"-ren arabera lantegia eguneratu
    @PutMapping("/{id}")
    public Planta updatePlant(@PathVariable String id, @RequestBody Planta planta) {
        return plantaRepositorio.updatePlant(id, planta);
    }

    // Emandako "id"-ren arabera lantegia ezabatu
    @DeleteMapping("/{id}")
    public void deletePlant(@PathVariable String id) {
        plantaRepositorio.deletePlant(id);
    }

    // Lantegien kopurua itzuli
    @GetMapping("/count")
    public long countPlants() {
        return plantaRepositorio.countPlants();
    }
}
