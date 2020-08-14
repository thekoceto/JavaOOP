package entities;

import entities.interfaces.Fighter;

public class FighterImpl extends BaseMachine implements Fighter {
    private static final double INITIAL_HEALTH_POINTS = 200d;
    private static final double ATTACK_POINTS_MODIFIER = 50d;
    private static final double DEFENSE_POINTS_MODIFIER = 25d;

    private boolean aggressiveMode = false;

    public FighterImpl(String name, double attackPoints, double defensePoints) {
        super(name, attackPoints, defensePoints, INITIAL_HEALTH_POINTS);
        this.toggleAggressiveMode();
    }

    @Override
    public boolean getAggressiveMode() {
        return this.aggressiveMode;
    }

    @Override
    public void toggleAggressiveMode() {
        this.aggressiveMode = !this.aggressiveMode;
        if (this.aggressiveMode){
            super.setAttackPoints(super.getAttackPoints() + ATTACK_POINTS_MODIFIER);
            super.setDefensePoints(super.getDefensePoints() - DEFENSE_POINTS_MODIFIER);
        }else{
            super.setAttackPoints(super.getAttackPoints() - ATTACK_POINTS_MODIFIER);
            super.setDefensePoints(super.getDefensePoints() + DEFENSE_POINTS_MODIFIER);
        }
    }
    @Override
    public String toString() {
        return super.toString() + System.lineSeparator() +
                " *Aggressive Mode(" + (this.getAggressiveMode() ? "ON" : "OFF") + ")";
    }
}
