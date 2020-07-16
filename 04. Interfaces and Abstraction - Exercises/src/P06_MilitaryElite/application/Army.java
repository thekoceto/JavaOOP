package P06_MilitaryElite.application;
import P06_MilitaryElite.interfaces.Soldier;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private List<Soldier> soldiers;

    public Army() {
        this.soldiers = new ArrayList<>();
    }

    public void assSoldier(Soldier soldier) {
        this.soldiers.add(soldier);
    }

    public List<Soldier> getSoldiers() {
        return soldiers;
    }
}
