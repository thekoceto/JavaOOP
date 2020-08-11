package santasWorkshop.core;

import santasWorkshop.common.ConstantMessages;
import santasWorkshop.common.ExceptionMessages;
import santasWorkshop.models.dwarf.Happy;
import santasWorkshop.models.dwarf.Sleepy;
import santasWorkshop.models.instrument.InstrumentImpl;
import santasWorkshop.models.interfaces.Dwarf;
import santasWorkshop.models.interfaces.Instrument;
import santasWorkshop.models.interfaces.Present;
import santasWorkshop.models.interfaces.Workshop;
import santasWorkshop.models.present.PresentImpl;
import santasWorkshop.models.workshop.WorkshopImpl;
import santasWorkshop.repositories.DwarfRepository;
import santasWorkshop.repositories.PresentRepository;

public class ControllerImpl implements Controller{
    private PresentRepository presents;
    private DwarfRepository dwarfs;
    private Workshop workshop;
    private int countCraftedPresents;

    public ControllerImpl() {
        this.presents = new PresentRepository();
        this.dwarfs = new DwarfRepository();
        this.workshop = new WorkshopImpl();
        this.countCraftedPresents = 0;
    }

    @Override
    public String addDwarf(String type, String dwarfName) {
        switch (type){
            case "Happy":
                this.dwarfs.add(new Happy(dwarfName));
                return String.format(ConstantMessages.ADDED_DWARF, type, dwarfName);
            case "Sleepy":
                this.dwarfs.add(new Sleepy(dwarfName));
                return String.format(ConstantMessages.ADDED_DWARF, type, dwarfName);
            default:
                throw new  IllegalArgumentException(ExceptionMessages.DWARF_TYPE_DOESNT_EXIST);
        }
    }

    @Override
    public String addInstrumentToDwarf(String dwarfName, int power) {
        Dwarf dwarf = this.dwarfs.findByName(dwarfName);
        if (dwarf != null){
            dwarf.addInstrument(new InstrumentImpl(power));
            return String.format(ConstantMessages.SUCCESSFULLY_ADDED_INSTRUMENT_TO_DWARF, power, dwarfName);
        }else
            throw new IllegalArgumentException(ExceptionMessages.DWARF_DOESNT_EXIST);
    }

    @Override
    public String addPresent(String presentName, int energyRequired) {
        this.presents.add(new PresentImpl(presentName, energyRequired));
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_PRESENT, presentName);
    }

    @Override
    public String craftPresent(String presentName) {
        Dwarf dwarf = dwarfs.getModels()
                .stream()
                .filter(d -> d.getEnergy() > 50)
                .findFirst()
                .orElse(null);

        if (dwarf == null)
            throw new IllegalArgumentException(ExceptionMessages.NO_DWARF_READY);

        Present present = this.presents.findByName(presentName);

        workshop.craft(present, dwarf);

        long countBrokenInstruments = dwarf.getInstruments().stream()
                .filter(Instrument::isBroken)
                .count();

        if (present.isDone())
            this.countCraftedPresents++;

        return  String.format(ConstantMessages.PRESENT_DONE,presentName, present.isDone() ? "done" : "not done") +
                String.format(ConstantMessages.COUNT_BROKEN_INSTRUMENTS,countBrokenInstruments);
    }

    @Override
    public String report() {
        StringBuilder report = new StringBuilder();

        report
                .append(countCraftedPresents)
                .append(" presents are done!")
                .append(System.lineSeparator())
                .append("Dwarfs info:")
                .append(System.lineSeparator());

        this.dwarfs.getModels()
                .forEach(dwarf -> report.append(dwarf.toString()).append(System.lineSeparator()));

        return report.toString().trim();
    }
}
