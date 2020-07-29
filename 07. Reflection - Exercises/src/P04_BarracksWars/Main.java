package P04_BarracksWars;

import P04_BarracksWars.core.Engine;
import P04_BarracksWars.core.factories.UnitFactoryImpl;
import P04_BarracksWars.data.UnitRepository;
import P04_BarracksWars.interfaces.Repository;
import P04_BarracksWars.interfaces.Runnable;
import P04_BarracksWars.interfaces.UnitFactory;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
