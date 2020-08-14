import core.run.Engine;
import core.run.EngineImpl;

public class Main {
    public static void main(String[] args) {
//        PilotFactory pilotFactory = null; //TODO change null with your implementation
//        MachineFactory machineFactory = null; //TODO change null with your implementation
//        Map<String, Pilot> pilots = new LinkedHashMap<>();
//        Map<String, Machine> machines = new LinkedHashMap<>();
//
//        MachinesManager machinesManager = new MachinesManagerImpl(pilotFactory, machineFactory, pilots, machines);

        Engine engine = new EngineImpl();
        engine.run();
    }
}
