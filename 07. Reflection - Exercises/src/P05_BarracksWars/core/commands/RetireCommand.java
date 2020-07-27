package P05_BarracksWars.core.commands;

import P05_BarracksWars.interfaces.Repository;
import P05_BarracksWars.interfaces.UnitFactory;

import javax.naming.OperationNotSupportedException;

public class RetireCommand extends Command {
    public RetireCommand(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        try{
            String unitType = this.getData()[1];
            this.getRepository().removeUnit(unitType);
            return unitType + " retired!";
        }catch (OperationNotSupportedException e){
            return e.getMessage();
        }
    }
}
