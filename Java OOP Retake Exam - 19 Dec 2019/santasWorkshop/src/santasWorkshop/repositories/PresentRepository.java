package santasWorkshop.repositories;

import santasWorkshop.models.interfaces.Dwarf;
import santasWorkshop.models.interfaces.Present;

import java.util.ArrayList;
import java.util.Collection;

public class PresentRepository implements Repository<Present>{
    private final Collection<Present> presents;

    public PresentRepository() {
        this.presents  = new ArrayList<>();
    }

    @Override
    public Collection<Present> getModels() {
        return this.presents;
    }

    @Override
    public void add(Present present) {
        this.presents.add(present);
    }

    @Override
    public boolean remove(Present present) {
        return this.presents.remove(present);
    }

    @Override
    public Present findByName(String name) {
        return this.presents.stream()
                .filter(present -> present.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

}
