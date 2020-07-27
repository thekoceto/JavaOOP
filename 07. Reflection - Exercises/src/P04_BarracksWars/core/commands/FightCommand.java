package P04_BarracksWars.core.commands;

import P04_BarracksWars.interfaces.Repository;
import P04_BarracksWars.interfaces.UnitFactory;

public class FightCommand extends Command{
    public FightCommand(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        return "fight";
    }
}
