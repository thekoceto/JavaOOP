package entities;

import entities.interfaces.Tank;

public class TankImpl extends BaseMachine implements Tank {
    private static final double INITIAL_HEALTH_POINTS = 100d;
    private static final double ATTACK_POINTS_MODIFIER = 40d;
    private static final double DEFENSE_POINTS_MODIFIER = 30d;

    private boolean defenseMode = false; // under initialization get to be true

    public TankImpl(String name, double attackPoints, double defensePoints) {
        super(name, attackPoints, defensePoints, INITIAL_HEALTH_POINTS);
        this.toggleDefenseMode();
    }

    @Override
    public boolean getDefenseMode() {
        return this.defenseMode;
    }

    @Override
    public void toggleDefenseMode() {
        this.defenseMode = !this.defenseMode;
        if (this.defenseMode){
            super.setAttackPoints(super.getAttackPoints() - ATTACK_POINTS_MODIFIER);
            super.setDefensePoints(super.getDefensePoints() + DEFENSE_POINTS_MODIFIER);
        }else{
            super.setAttackPoints(super.getAttackPoints() + ATTACK_POINTS_MODIFIER);
            super.setDefensePoints(super.getDefensePoints() - DEFENSE_POINTS_MODIFIER);
        }
    }

    @Override
    public String toString() {
        return super.toString() + System.lineSeparator() +
                " *Defense Mode(" + (this.getDefenseMode() ? "ON" : "OFF") + ")";
    }
}
