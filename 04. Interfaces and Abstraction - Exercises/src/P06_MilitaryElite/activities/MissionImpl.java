package P06_MilitaryElite.activities;

import P06_MilitaryElite.enumerations.State;
import P06_MilitaryElite.interfaces.Mission;


public class MissionImpl implements Mission {
    private String codeName;
    private State state;

    public MissionImpl(String codeName, State state) {
        this.codeName = codeName;
        this.state = state;
    }

    @Override
    public String toString() {
        return String.format("Code Name: %s State: %s", this.codeName, this.state);
    }
}
