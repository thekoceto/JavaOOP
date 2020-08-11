package motocrossWorldChampionship.repositories;

import motocrossWorldChampionship.entities.interfaces.Motorcycle;
import motocrossWorldChampionship.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collection;

public class MotorcycleRepository implements Repository<Motorcycle> {
    private Collection<Motorcycle> models;

    public MotorcycleRepository() {
        this.models = new ArrayList<>();
    }

    @Override
    public Motorcycle getByName(String name) {
        return models.stream()
                .filter(motorcycle -> motorcycle.getModel().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Collection<Motorcycle> getAll() {
        return this.models;
    }

    @Override
    public void add(Motorcycle model) {
        models.add(model);
    }

    @Override
    public boolean remove(Motorcycle model) {
        return models.remove(model);
    }
}
