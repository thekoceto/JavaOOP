package P05_BarracksWars;

import P05_BarracksWars.core.Engine;
import P05_BarracksWars.core.factories.UnitFactoryImpl;
import P05_BarracksWars.data.UnitRepository;
import P05_BarracksWars.interfaces.Repository;
import P05_BarracksWars.interfaces.Runnable;
import P05_BarracksWars.interfaces.UnitFactory;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
