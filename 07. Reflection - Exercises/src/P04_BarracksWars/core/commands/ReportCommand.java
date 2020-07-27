package P04_BarracksWars.core.commands;

import P04_BarracksWars.interfaces.Repository;
import P04_BarracksWars.interfaces.UnitFactory;

public class ReportCommand extends Command{
    public ReportCommand(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        return this.getRepository().getStatistics();
    }
}
