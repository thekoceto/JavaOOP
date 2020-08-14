package core;

import common.OutputMessages;
import core.interfaces.MachineFactory;
import core.interfaces.PilotFactory;
import core.interfaces.MachinesManager;

import entities.interfaces.Fighter;
import entities.interfaces.Machine;
import entities.interfaces.Pilot;
import entities.interfaces.Tank;

import java.util.Map;

public class MachinesManagerImpl implements MachinesManager {
    private PilotFactory pilotFactory;
    private MachineFactory machineFactory;
    private Map<String, Pilot> pilots;
    private Map<String, Machine> machines;

    public MachinesManagerImpl(PilotFactory pilotFactory, MachineFactory machineFactory, Map<String, Pilot> pilots, Map<String, Machine> machines) {
        this.pilotFactory = pilotFactory;
        this.machineFactory = machineFactory;
        this.pilots = pilots;
        this.machines = machines;
    }


    @Override
    public String hirePilot(String name) {
        if (pilots.containsKey(name))
            return String.format(OutputMessages.pilotExists, name);

        pilots.put(name, pilotFactory.createPilot(name));
        return String.format(OutputMessages.pilotHired, name);
    }

    @Override
    public String manufactureTank(String name, double attackPoints, double defensePoints) {

        if (machines.containsKey(name))
            return String.format(OutputMessages.machineExists, name);

        machines.put(name, machineFactory.createTank(name, attackPoints, defensePoints));
        return String.format(OutputMessages.tankManufactured, name, attackPoints, defensePoints);
    }

    @Override
    public String manufactureFighter(String name, double attackPoints, double defensePoints) {
        if (machines.containsKey(name))
            return String.format(OutputMessages.machineExists, name);

        machines.put(name, machineFactory.createFighter(name, attackPoints, defensePoints));
        return String.format(OutputMessages.fighterManufactured, name, attackPoints, defensePoints);
    }

    @Override
    public String engageMachine(String selectedPilotName, String selectedMachineName) {
        Pilot pilot = pilots.get(selectedPilotName);
        Machine machine = machines.get(selectedMachineName);

        if (pilot == null)
            return String.format(OutputMessages.pilotNotFound, selectedPilotName);

        if (machine == null)
            return String.format(OutputMessages.machineNotFound, selectedMachineName);

        if (machine.getPilot() != null)
            return String.format(OutputMessages.machineHasPilotAlready, selectedMachineName);

        pilot.addMachine(machine);
        machine.setPilot(pilot);
        return String.format(OutputMessages.machineEngaged, selectedPilotName, selectedMachineName);
    }

    @Override
    public String attackMachines(String attackingMachineName, String defendingMachineName) {
        Machine attacker = this.machines.get(attackingMachineName);
        Machine defender = this.machines.get(defendingMachineName);

        if (attacker == null)
            return String.format(OutputMessages.machineNotFound, attackingMachineName);

        if (defender == null)
            return String.format(OutputMessages.machineNotFound, defendingMachineName);

        attacker.attack(defendingMachineName);
        if (attacker.getAttackPoints() > defender.getDefensePoints()){
            double newDefensePoints = defender.getHealthPoints() -
                    (attacker.getAttackPoints() - defender.getDefensePoints());
            if (newDefensePoints < 0)
                newDefensePoints = 0;
            defender.setHealthPoints(newDefensePoints);
        }
        return String.format(OutputMessages.attackSuccessful,
                attackingMachineName,
                defendingMachineName,
                defender.getHealthPoints());
    }

    @Override
    public String pilotReport(String pilotName) {
        Pilot pilot = this.pilots.get(pilotName);
        if (pilot == null)
            return String.format(OutputMessages.pilotNotFound, pilotName);

        return pilot.report();
    }

    @Override
    public String toggleFighterAggressiveMode(String fighterName) {
        Machine machine = machines.get(fighterName);
        if (machine.getClass().getInterfaces()[0].getSimpleName().equals("Fighter")){
            ((Fighter) machine).toggleAggressiveMode();
            return String.format(OutputMessages.fighterOperationSuccessful, fighterName);
        }
        return String.format(OutputMessages.notSupportedOperation, fighterName);
    }

    @Override
    public String toggleTankDefenseMode(String tankName) {
        Machine machine = machines.get(tankName);
        if (machine.getClass().getInterfaces()[0].getSimpleName().equals("Tank")){
            ((Tank) machine).toggleDefenseMode();
            return String.format(OutputMessages.tankOperationSuccessful, tankName);
        }
        return String.format(OutputMessages.notSupportedOperation, tankName);
    }
}
