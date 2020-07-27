package P05_BarracksWars.core.commands;

import P05_BarracksWars.interfaces.Repository;
import P05_BarracksWars.interfaces.Unit;
import P05_BarracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.InvocationTargetException;

public class AddCommand extends Command {

    public AddCommand(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        String unitType = this.getData()[1];
        Unit unitToAdd = null;
        try {
            unitToAdd = this.getUnitFactory().createUnit(unitType);
        } catch (ExecutionControl.NotImplementedException
                | InstantiationException
                | InvocationTargetException
                | NoSuchMethodException
                | IllegalAccessException
                | ClassNotFoundException e) {
            e.printStackTrace();
        }
        this.getRepository().addUnit(unitToAdd);
        return unitType + " added!";
    }
}
