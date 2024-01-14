package dambi.proiekto.repositorio;

import dambi.proiekto.model.Planta;

import java.util.List;

// Interfazea landaketen erabilera guztiak adierazten du
public interface PlantaRepositorio {
    List<Planta> getPlants(); // Aplikazioak eskatutako landaketa guztiak itzuli

    Planta getPlantById(String id); // Emandako "id"-ren arabera lantegia bilatu eta itzuli

    List<Planta> getPlantsByType(String tipo); // Emandako "tipo"aren arabera lantegiak bilatu eta itzuli

    List<Planta> getPlantsByName(String nombre); // Emandako "nombre"aren arabera lantegiak bilatu eta itzuli

    Planta addPlant(Planta planta); // Lantegi berria gehitu

    Planta updatePlant(String id, Planta planta); // Emandako "id"-ren arabera lantegia eguneratu

    void deletePlant(String id); // Emandako "id"-ren arabera lantegia ezabatu

    long countPlants(); // Lantegien kopurua itzuli
}
