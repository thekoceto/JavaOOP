package onlineShop.core;

import onlineShop.core.interfaces.Controller;
import onlineShop.models.products.components.*;
import onlineShop.models.products.computers.Computer;
import onlineShop.models.products.computers.DesktopComputer;
import onlineShop.models.products.computers.Laptop;
import onlineShop.models.products.peripherals.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static onlineShop.common.constants.ExceptionMessages.*;
import static onlineShop.common.constants.OutputMessages.*;

public class ControllerImpl implements Controller {
    private List<Computer> computers;
    private List<Component> components;
    private List<Peripheral> peripherals;

    public ControllerImpl() {
        this.computers = new ArrayList<>();
        this.components = new ArrayList<>();
        this.peripherals = new ArrayList<>();
    }

    @Override
    public String addComputer(String computerType, int id, String manufacturer, String model, double price) {
        checkComputerIdExist(id);

        switch (computerType){
            case "DesktopComputer":
                this.computers.add(new DesktopComputer(id, manufacturer, model, price));
                return String.format(ADDED_COMPUTER, id);

            case "Laptop":
                this.computers.add(new Laptop(id, manufacturer, model, price));
                return String.format(ADDED_COMPUTER, id);
            default:
                throw new IllegalArgumentException(INVALID_COMPUTER_TYPE);

        }
    }

    @Override
    public String addPeripheral(int computerId, int id, String peripheralType, String manufacturer, String model, double price, double overallPerformance, String connectionType) {
        Computer computer = checkAndReturnComputerWithId(computerId);

        if (getPeripheral(id, computer) != null)
            throw new IllegalArgumentException(EXISTING_PERIPHERAL_ID);

        Peripheral peripheral;

        switch (peripheralType) {
            case "Headset":
                peripheral = new Headset(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            case "Keyboard":
                peripheral = new Keyboard(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            case "Monitor":
                peripheral = new Monitor(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            case "Mouse":
                peripheral = new Mouse(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            default:
                throw new IllegalArgumentException(INVALID_PERIPHERAL_TYPE);
        }
        computer.addPeripheral(peripheral);
        this.peripherals.add(peripheral);
        return String.format(ADDED_PERIPHERAL, peripheralType, id, computerId);
    }

    @Override
    public String removePeripheral(String peripheralType, int computerId) {
        Computer computer = checkAndReturnComputerWithId(computerId);

        Peripheral peripheral = computer.removePeripheral(peripheralType);
        this.peripherals.remove(peripheral);

        return String.format(REMOVED_PERIPHERAL, peripheralType, peripheral.getId());
    }

    @Override
    public String addComponent(int computerId, int id, String componentType, String manufacturer, String model, double price, double overallPerformance, int generation) {
        Computer computer = checkAndReturnComputerWithId(computerId);

        if (getComponent(id, computer) != null)
            throw new IllegalArgumentException(EXISTING_COMPONENT_ID);

        Component component;

        switch (componentType){
            case "CentralProcessingUnit":
                component = new CentralProcessingUnit(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "Motherboard":
                component = new Motherboard(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "PowerSupply":
                component = new PowerSupply(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "RandomAccessMemory":
                component = new RandomAccessMemory(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "SolidStateDrive":
                component = new SolidStateDrive(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "VideoCard":
                component = new VideoCard(id, manufacturer, model, price, overallPerformance, generation);
                break;
            default:
                throw new IllegalArgumentException(INVALID_COMPONENT_TYPE);
        }

        computer.addComponent(component);
        this.components.add(component);
        return String.format(ADDED_COMPONENT, componentType, id, computerId);
    }

    @Override
    public String removeComponent(String componentType, int computerId) {
        Computer computer = checkAndReturnComputerWithId(computerId);

        Component component = computer.removeComponent(componentType);

        this.components.remove(component);

        return String.format(REMOVED_COMPONENT, componentType, component.getId());
    }

    @Override
    public String buyComputer(int id) {
        Computer computer = checkAndReturnComputerWithId(id);

        this.computers.remove(computer);

        return computer.toString();
    }

    @Override
    public String BuyBestComputer(double budget) {

        Computer bestComputer = this.computers.stream()
                .filter(computer -> computer.getPrice() <= budget)
                .max(Comparator.comparing(Computer::getOverallPerformance))
                .orElse(null);

        if (bestComputer == null)
            throw new IllegalArgumentException (String.format(CAN_NOT_BUY_COMPUTER, budget));

        this.computers.remove(bestComputer);

        return bestComputer.toString();
    }

    @Override
    public String getComputerData(int id) {
        Computer computer = checkAndReturnComputerWithId(id);

        return computer.toString();
    }

    private Computer checkAndReturnComputerWithId(int computerId){
        Computer computer = getComputerWithID(computerId);

        if (computer == null)
            throw new IllegalArgumentException(NOT_EXISTING_COMPUTER_ID);

        return computer;
    }

    private void checkComputerIdExist(int computerId){
        if (getComputerWithID(computerId) != null)
            throw new IllegalArgumentException(EXISTING_COMPUTER_ID);
    }

    private Computer getComputerWithID(int computerId) {
        return this.computers
                .stream()
                .filter(current -> current.getId() == computerId)
                .findFirst().orElse(null);
    }

    private Component getComponent(int componentId, Computer computer) {
        return computer.getComponents()
                .stream()
                .filter(component -> component.getId() == componentId)
                .findFirst()
                .orElse(null);
    }

    private Peripheral getPeripheral(int peripheralId, Computer computer) {
        return computer.getPeripherals()
                .stream()
                .filter(peripheral -> peripheral.getId() == peripheralId)
                .findFirst()
                .orElse(null);
    }
}
