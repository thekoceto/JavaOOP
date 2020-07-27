package P03_BarracksWars.core.commands;

import P03_BarracksWars.interfaces.Repository;
import P03_BarracksWars.interfaces.Unit;
import P03_BarracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

public class AddCommand extends Command{

    public AddCommand(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        String unitType = this.getData()[1];
        Unit unitToAdd = null;
        try {
            unitToAdd = this.getUnitFactory().createUnit(unitType);
        } catch (ExecutionControl.NotImplementedException e) {
            e.printStackTrace();
        }
        this.getRepository().addUnit(unitToAdd);
        return unitType + " added!";
    }
}
