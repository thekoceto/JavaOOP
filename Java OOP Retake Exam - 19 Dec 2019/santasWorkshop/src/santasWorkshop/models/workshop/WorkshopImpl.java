package santasWorkshop.models.workshop;

import santasWorkshop.models.interfaces.Dwarf;
import santasWorkshop.models.interfaces.Instrument;
import santasWorkshop.models.interfaces.Present;
import santasWorkshop.models.interfaces.Workshop;

public class WorkshopImpl implements Workshop {
    // TODO

    @Override
    public void craft(Present present, Dwarf dwarf) {
        while(dwarf.canWork() && getInstrument(dwarf) != null && !present.isDone()){

            getInstrument(dwarf).use();
            dwarf.work();
            present.getCrafted();
        }

    }

    private Instrument getInstrument(Dwarf dwarf) {
        return dwarf.getInstruments()
                .stream()
                .filter(i -> !i.isBroken())
                .findAny()
                .orElse(null);
    }
}
// Here is how the craft method works:
// The dwarf starts crafting the present.
// This is only possible, if the dwarf has energy and an instrument that isn't broken.

// Keep working until the present is done or the dwarf has energy (and instruments to use).

// If at some point the power of the current instrument
// reaches or drops below 0, meaning it is broken, then the dwarf
// should take the next instrument from its collection, if it has any left.