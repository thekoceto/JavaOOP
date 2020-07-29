package P03_BarracksWars;

import P03_BarracksWars.interfaces.Repository;
import P03_BarracksWars.interfaces.Runnable;
import P03_BarracksWars.interfaces.UnitFactory;
import P03_BarracksWars.core.Engine;
import P03_BarracksWars.core.factories.UnitFactoryImpl;
import P03_BarracksWars.data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
