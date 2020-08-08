package robotService.core;

import robotService.common.Command;
import robotService.common.ExceptionMessages;
import robotService.core.interfaces.Controller;
import robotService.core.interfaces.Engine;
import robotService.io.ConsoleReader;
import robotService.io.ConsoleWriter;
import robotService.io.interfaces.InputReader;
import robotService.io.interfaces.OutputWriter;

import java.io.IOException;
import java.util.Arrays;

public class EngineImpl implements Engine {
    private InputReader reader;
    private OutputWriter writer;
    private Controller controller;

    public EngineImpl() {
        this.controller = new ControllerImpl();
        this.reader = new ConsoleReader();
        this.writer = new ConsoleWriter();
    }

    @Override
    public void run() {
        while (true) {
            String result = null;
            try {
                result = processInput();

                if ("Exit".equals(result)) {
                    break;
                }

            } catch (IOException | IllegalArgumentException | NullPointerException e) {
                result = e.getMessage();
            }

            this.writer.writeLine(result);
        }
    }

    private String processInput() throws IOException {
        String input = this.reader.readLine();
        String[] tokens = input.split("\\s");

        Command command = Command.valueOf(tokens[0]);
        String[] data = Arrays.stream(tokens).skip(1).toArray(String[]::new);

        switch (command) {
            case Manufacture:
                return manufacture(data);
            case Repair:
                return repair(data);
            case Work:
                return work(data);
            case Charge:
                return charge(data);
            case Sell:
                return sell(data);
            case History:
                return history(data);
            case Exit:
                return "Exit";
            default:
                return null;
        }

    }

    private String manufacture(String[] data) {
        return controller.manufacture(data[0], data[1], Integer.parseInt(data[2]),
                Integer.parseInt(data[3]), Integer.parseInt(data[4]));
    }

    private String repair(String[] data) {
        return controller.repair(data[0], Integer.parseInt(data[1]));
    }

    private String work(String[] data) {
        return controller.work(data[0], Integer.parseInt(data[1]));
    }

    private String charge(String[] data) {
        return controller.charge(data[0], Integer.parseInt(data[1]));
    }

    private String sell(String[] data) {
        return controller.sell(data[0], data[1]);
    }

    private String history(String[] data) {
        return controller.history(data[0]);
    }
}
