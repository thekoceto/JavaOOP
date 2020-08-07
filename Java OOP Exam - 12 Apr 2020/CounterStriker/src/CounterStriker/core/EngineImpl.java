package CounterStriker.core;

import CounterStriker.common.Command;

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

                if (result.equals(Command.Exit.name())) {
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
            case AddPlayer:
                return this.addPlayer(data);
            case Exit:
                return Command.Exit.name();
            case StartGame:
                return this.start();
            case Report:
                return this.report();
            case AddGun:
                return this.addGun(data);
            default:
                return null;
        }
    }

    private String addGun(String[] data) {
        return this.controller.addGun(data[0],
                data[1], Integer.parseInt(data[2]));
    }

    private String report() {
        return this.controller.report();
    }

    private String addPlayer(String[] data) {
        return this.controller.addPlayer(data[0],
                data[1], Integer.parseInt(data[2]),
                Integer.parseInt(data[3]), data[4]);
    }

    private String start() {
        return this.controller.startGame();
    }
}
