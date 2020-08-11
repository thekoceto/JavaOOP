package santasWorkshop.repositories;


import santasWorkshop.models.interfaces.Dwarf;

import java.util.ArrayList;
import java.util.Collection;

public class DwarfRepository implements Repository<Dwarf>{
    private final Collection<Dwarf> dwarfs;

    public DwarfRepository() {
        this.dwarfs = new ArrayList<>();
    }

    @Override
    public Collection<Dwarf> getModels() {
        return this.dwarfs;
    }

    @Override
    public void add(Dwarf dwarf) {
        this.dwarfs.add(dwarf);
    }

    @Override
    public boolean remove(Dwarf dwarf) {
        return this.dwarfs.remove(dwarf);
    }

    @Override
    public Dwarf findByName(String name) {
        return this.dwarfs.stream()
                .filter(dwarf -> dwarf.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
