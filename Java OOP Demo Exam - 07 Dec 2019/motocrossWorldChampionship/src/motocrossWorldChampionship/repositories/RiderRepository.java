package motocrossWorldChampionship.repositories;

import motocrossWorldChampionship.entities.interfaces.Rider;
import motocrossWorldChampionship.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collection;

public class RiderRepository implements Repository<Rider> {
    private Collection<Rider> models;

    public RiderRepository() {
        this.models = new ArrayList<>();
    }

    @Override
    public Rider getByName(String name) {
        return models.stream()
                .filter(rider -> rider.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Collection<Rider> getAll() {
        return this.models;
    }

    @Override
    public void add(Rider model) {
        models.add(model);
    }

    @Override
    public boolean remove(Rider model) {
        return models.remove(model);
    }
}
