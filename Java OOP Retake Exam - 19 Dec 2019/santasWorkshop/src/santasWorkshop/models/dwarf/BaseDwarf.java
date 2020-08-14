package santasWorkshop.models.dwarf;

import santasWorkshop.common.ExceptionMessages;
import santasWorkshop.models.interfaces.Dwarf;
import santasWorkshop.models.interfaces.Instrument;

import java.util.ArrayList;
import java.util.Collection;

public class BaseDwarf implements Dwarf {
    private String name;
    private int energy;
    private Collection<Instrument> instruments;

    public BaseDwarf(String name, int energy) {
        this.setName(name);
        this.setEnergy(energy);
        this.instruments = new ArrayList<>();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty())
            throw new NullPointerException(ExceptionMessages.DWARF_NAME_NULL_OR_EMPTY);
        this.name = name;
    }

    public void setEnergy(int energy) {
        if (energy < 0)
            throw new IllegalArgumentException(ExceptionMessages.DWARF_ENERGY_LESS_THAN_ZERO);
        this.energy = energy;
    }

    @Override
    public void work() {
        this.energy -= 10;
        if (this.energy < 0)
            this.energy = 0;
    }

    @Override
    public void addInstrument(Instrument instrument) {
        instruments.add(instrument);
    }

    @Override
    public boolean canWork() {
        return this.energy > 0;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getEnergy() {
        return this.energy;
    }

    @Override
    public Collection<Instrument> getInstruments() {
        return this.instruments;
    }

    @Override
    public String toString() {
        return  "Name: " + getName() + System.lineSeparator() +
                "Energy: " + getEnergy() + System.lineSeparator() +
                "Instruments: " + this.countNotBrokenInstruments() + " not broken left";
    }

    private int countNotBrokenInstruments(){
        return (int)this.instruments
                .stream()
                .filter(instrument -> !instrument.isBroken())
                .count();
    }
}
