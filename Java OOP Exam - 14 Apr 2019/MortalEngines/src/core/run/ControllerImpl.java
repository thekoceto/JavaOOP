package core.run;


import core.MachineFactoryImpl;
import core.MachinesManagerImpl;
import core.PilotFactoryImpl;
import core.interfaces.MachineFactory;
import core.interfaces.MachinesManager;
import core.interfaces.PilotFactory;
import entities.interfaces.Machine;
import entities.interfaces.Pilot;

import java.util.LinkedHashMap;
import java.util.Map;

public class ControllerImpl implements Controller{
    private PilotFactory pilotFactory;
    private MachineFactory machineFactory;
    private Map<String, Pilot> pilots;
    private Map<String, Machine> machines ;
    private MachinesManager machinesManager;

    public ControllerImpl() {
        this.pilotFactory = new PilotFactoryImpl();
        this.machineFactory = new MachineFactoryImpl();
        this.pilots = new LinkedHashMap<>();
        this.machines = new LinkedHashMap<>();
        this.machinesManager = new MachinesManagerImpl(pilotFactory, machineFactory, pilots, machines);
    }

    @Override
    public String Hire(String name) {
        return this.machinesManager.hirePilot(name);
    }

    @Override
    public String Report(String pilotName) {
        return this.machinesManager.pilotReport(pilotName);
    }

    @Override
    public String ManufactureTank(String type, double attackPoints, double defensePoints) {
        return this.machinesManager.manufactureTank(type, attackPoints, defensePoints);
    }

    @Override
    public String ManufactureFighter(String type, double attackPoints, double defensePoints) {
        return this.machinesManager.manufactureFighter(type, attackPoints, defensePoints);
    }

    @Override
    public String Engage(String pilotName, String machineName) {
        return this.machinesManager.engageMachine(pilotName, machineName);
    }

    @Override
    public String Attack(String attackMachineName, String defendingMachineName) {
        return this.machinesManager.attackMachines(attackMachineName, defendingMachineName);
    }

    @Override
    public String AggressiveMode(String machineName) {
        return this.machinesManager.toggleFighterAggressiveMode(machineName);
    }

    @Override
    public String DefenseMode(String machineName) {
        return this.machinesManager.toggleTankDefenseMode(machineName);
    }

}
