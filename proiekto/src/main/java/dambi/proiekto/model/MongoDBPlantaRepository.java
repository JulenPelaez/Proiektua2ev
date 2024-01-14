package dambi.proiekto.model;

import com.mongodb.ReadConcern;
import com.mongodb.TransactionOptions;
import com.mongodb.WriteConcern;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;

import dambi.proiekto.repositorio.PlantaRepositorio;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

@Repository
public class MongoDBPlantaRepository implements PlantaRepositorio {

    // Transakzioen aukerak definitzen dituen konstanteak
    private static final TransactionOptions txnOptions = TransactionOptions.builder()
            .readConcern(ReadConcern.MAJORITY)
            .writeConcern(WriteConcern.MAJORITY)
            .build();

    @Autowired
    private MongoClient client; // MongoDB bezeroa inizializatzeko autowired elementua
    private MongoCollection<Planta> plantaCollection; // Plantak gordetzeko kolekzioa

    @PostConstruct
    void init() {
        // Kolekzioa inizializatzen da aplikazioa hastean
        plantaCollection = client.getDatabase("prueba").getCollection("prueba", Planta.class);
    }

    @Override
    public List<Planta> getPlants() {
        // Aplikazioa egiten diren landaketa guztiak lortu eta zerrendan itzuli
        return plantaCollection.find().into(new ArrayList<>());
    }
    
    @Override
    public Planta getPlantById(String id) {
        // Emandako "id"-ren arabera lantegia bilatu eta lehenengo elementua itzuli
        return plantaCollection.find(eq("_id", new ObjectId(id))).first();
    }

    @Override
    public List<Planta> getPlantsByType(String tipo) {
        // Emandako "tipo"aren arabera lantegiak bilatu eta zerrendan itzuli
        return plantaCollection.find(eq("type", tipo)).into(new ArrayList<>());
    }

    @Override
    public List<Planta> getPlantsByName(String nombre) {
        // Emandako "nombre"aren arabera lantegiak bilatu eta zerrendan itzuli
        return plantaCollection.find(eq("name", nombre)).into(new ArrayList<>());
    }

    @Override
    public Planta addPlant(Planta planta) {
        // Lantegi berria gehitu, "_id" sortu eta itzuli
        planta.set_id(ObjectId.get());
        plantaCollection.insertOne(planta);
        return planta;
    }

    @Override
    public Planta updatePlant(String id, Planta planta) {
        // "id"-ren arabera lantegia eguneratu
        plantaCollection.replaceOne(new Document("_id", new ObjectId(id)), planta);
        return planta;
    }

    @Override
    public void deletePlant(String id) {
        // "id"-ren arabera lantegia ezabatu
        plantaCollection.deleteOne(new Document("_id", new ObjectId(id)));
    }

    @Override
    public long countPlants() {
        // Lantegien kopurua itzuli
        return plantaCollection.countDocuments();
    }
}
