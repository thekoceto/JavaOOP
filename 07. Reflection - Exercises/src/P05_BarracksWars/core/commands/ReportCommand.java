package P05_BarracksWars.core.commands;

import P05_BarracksWars.interfaces.Repository;
import P05_BarracksWars.interfaces.UnitFactory;

public class ReportCommand extends Command {
    public ReportCommand(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        return this.getRepository().getStatistics();
    }
}
