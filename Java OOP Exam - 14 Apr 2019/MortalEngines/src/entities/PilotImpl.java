package entities;

import entities.interfaces.Machine;
import entities.interfaces.Pilot;

import java.util.ArrayList;
import java.util.List;

public class PilotImpl implements Pilot {
    private String name;
    private List<Machine> machines;

    public PilotImpl(String name) {
        this.setName(name);
        this.machines = new ArrayList<>();
    }

    public void setName(String name) {
        if(name == null || name.trim().isEmpty())
            throw new  IllegalArgumentException("Pilot name cannot be null or empty string.");

        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void addMachine(Machine machine) {
        if(machine == null)
            throw new  IllegalArgumentException("Null machine cannot be added to the pilot.");

        this.machines.add(machine);
    }

    @Override
    public List<Machine> getMachines() {
        return this.machines;
    }

    @Override
    public String report() {
        StringBuilder report = new StringBuilder();

        report.append(this.getName()).append(" - ")
                .append(this.getMachines().size())
                .append(" machines")
                .append(System.lineSeparator());
        machines.forEach(machine -> report.append(machine.toString()).append(System.lineSeparator()));

        return report.toString().trim();
    }
}
