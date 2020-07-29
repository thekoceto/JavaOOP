package P04_BarracksWars.core;

import P04_BarracksWars.interfaces.*;
import P04_BarracksWars.interfaces.Runnable;
import jdk.jshell.spi.ExecutionControl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Engine implements Runnable {
	private static final String COMMANDS_PACKAGE_NAME =
			"P04_BarracksWars.core.commands.";
	private Repository repository;
	private UnitFactory unitFactory;

	public Engine(Repository repository, UnitFactory unitFactory) {
		this.repository = repository;
		this.unitFactory = unitFactory;
	}

	@Override
	public void run() {
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in));
		while (true) {
			try {
				String input = reader.readLine();
				String[] data = input.split("\\s+");
				String commandName = data[0];
				String result = interpretCommand(data, commandName);
				if (result.equals("fight")) {
					break;
				}
				System.out.println(result);
			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
			} catch (IOException
					| InstantiationException
					| InvocationTargetException
					| NoSuchMethodException
					| IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}

	private String interpretCommand(String[] data, String commandName) throws NoSuchMethodException,
			IllegalAccessException, InvocationTargetException, InstantiationException {

		try {
			commandName = Character.toUpperCase(commandName.charAt(0)) + commandName.substring(1);
			Class<?> command = Class.forName(COMMANDS_PACKAGE_NAME + commandName + "Command");
			Constructor<?> constructor = command.getDeclaredConstructor(String[].class, Repository.class, UnitFactory.class);
			Executable instance = (Executable) constructor.newInstance(data, this.repository, this.unitFactory);
			return instance.execute();
		}catch (ClassNotFoundException e){
			return "Invalid command";
		}
	}

}
