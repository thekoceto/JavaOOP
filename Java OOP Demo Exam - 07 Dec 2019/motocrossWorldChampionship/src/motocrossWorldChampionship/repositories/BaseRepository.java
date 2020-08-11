package motocrossWorldChampionship.repositories;

import motocrossWorldChampionship.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collection;

public abstract class BaseRepository<T> implements Repository {
    private Collection<T> models;

    protected BaseRepository() {
        this.models = new ArrayList<>();
    }
}
