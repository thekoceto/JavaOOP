package core.run;

import common.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class EngineImpl implements Engine {
    private Controller controller;
    private BufferedReader reader;

    public EngineImpl() {
        this.controller = new ControllerImpl();
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {
        while (true) {
            String result = null;
            try {
                result = processInput();

                if (result.equals(Command.Over.name())) {
                    break;
                }

            } catch (IOException | IllegalArgumentException | NullPointerException e) {
                result = e.getMessage();
            }

            System.out.println(result);
        }
    }

    private String processInput() throws IOException {
        String input = this.reader.readLine();
        String[] tokens = input.split("\\s");

        Command command = Command.valueOf(tokens[0]);
        String[] data = Arrays.stream(tokens).skip(1).toArray(String[]::new);

        switch (command) {
            case Hire:
                return this.hire(data);
            case Report:
                return this.report(data);
            case ManufactureTank:
                return this.manufactureTank(data);
            case ManufactureFighter:
                return this.manufactureFighter(data);
            case Engage:
                return this.engage(data);
            case Attack:
                return this.attack(data);
            case AggressiveMode:
                return this.aggressiveMode(data);
            case DefenseMode:
                return this.defenseMode(data);
            case Over:
                return Command.Over.name();
            default:
                return null;
        }
    }

    private String hire(String[] data) {
        return this.controller.Hire(data[0]);
    }

    private String report(String[] data) {
        return this.controller.Report(data[0]);
    }
    private String manufactureTank(String[] data) {
        return this.controller.ManufactureTank(data[0],
                Double.parseDouble(data[1]),
                Double.parseDouble(data[2]));
    }

    private String manufactureFighter(String[] data) {
        return this.controller.ManufactureFighter(data[0],
                Double.parseDouble(data[1]),
                Double.parseDouble(data[2]));
    }

    private String engage(String[] data) {
        return this.controller.Engage(data[0], data[1]);
    }

    private String attack(String[] data) {
        return this.controller.Attack(data[0], data[1]);
    }

    private String aggressiveMode(String[] data) {
        return this.controller.AggressiveMode(data[0]);
    }

    private String defenseMode(String[] data) {
        return this.controller.DefenseMode(data[0]);
    }
}
