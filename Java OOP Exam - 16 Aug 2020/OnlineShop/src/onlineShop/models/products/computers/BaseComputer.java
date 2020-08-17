package onlineShop.models.products.computers;

import onlineShop.models.products.BaseProduct;
import onlineShop.models.products.Product;
import onlineShop.models.products.components.Component;
import onlineShop.models.products.peripherals.Peripheral;

import java.util.ArrayList;
import java.util.List;

import static onlineShop.common.constants.OutputMessages.*;
import static onlineShop.common.constants.ExceptionMessages.*;

public class BaseComputer extends BaseProduct implements Computer{
    private List<Component> components;
    private List<Peripheral> peripherals;

    public BaseComputer(int id, String manufacturer, String model, double price, double overallPerformance) {
        super(id, manufacturer, model, price, overallPerformance);
        this.components = new ArrayList<>();
        this.peripherals = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder();

        info.append(super.toString()).append(System.lineSeparator());

        info
                .append(" ").append(String.format(COMPUTER_COMPONENTS_TO_STRING,this.components.size()))
                .append(System.lineSeparator());

        this.components.forEach(component -> info
                .append("  ").append(component.toString())
                .append(System.lineSeparator()));

        double averageOverallPerformance =
                this.peripherals.stream()
                        .mapToDouble(Product::getOverallPerformance)
                        .average()
                        .orElse(0d);

        info
            .append(" ")
            .append(String.format(COMPUTER_PERIPHERALS_TO_STRING, this.peripherals.size(), averageOverallPerformance))
            .append(System.lineSeparator());

        this.peripherals.forEach(peripheral -> info
                .append("  ").append(peripheral.toString())
                .append(System.lineSeparator()));

        return info.toString().trim();
    }

    @Override
    public double getOverallPerformance() {
        if (this.components.isEmpty())
            return super.getOverallPerformance();

        return super.getOverallPerformance() + getComponentAverageOverallPerformance ();
    }

    @Override
    public double getPrice() {
        double componentsPrice = this.components.stream()
                .mapToDouble(Product::getPrice)
                .sum();
        double peripheralsPrice = this.peripherals.stream()
                .mapToDouble(Product::getPrice)
                .sum();

        return super.getPrice() + componentsPrice + peripheralsPrice;
    }

    @Override
    public List<Peripheral> getPeripherals() {
        return this.peripherals;
    }

    @Override
    public List<Component> getComponents() {
        return this.components;
    }

    @Override
    public void addComponent(Component component) {
        String componentType = component.getClass().getSimpleName();

        Component existingComponent = this.components.stream()
                .filter(current -> current.getClass().getSimpleName().equals(componentType))
                .findFirst()
                .orElse(null);

        if (existingComponent != null)
            throw new IllegalArgumentException(String.format(EXISTING_COMPONENT,
                    componentType, this.getClass().getSimpleName(), this.getId()));

        this.components.add(component);
    }

    @Override
    public Component removeComponent(String componentType) {
        Component component = this.components.stream()
                .filter(current ->  current.getClass().getSimpleName().equals(componentType))
                .findFirst()
                .orElse(null);

        if (this.components.remove(component))
            return component;

        throw new IllegalArgumentException(
                String.format(NOT_EXISTING_COMPONENT,
                        componentType, this.getClass().getSimpleName(), this.getId()));
    }

    @Override
    public void addPeripheral(Peripheral peripheral) {
        String peripheralType = this.peripherals.getClass().getSimpleName();

        Peripheral existingPeripheral = this.peripherals.stream()
                .filter(current -> current.getClass().getSimpleName().equals(peripheralType))
                .findFirst()
                .orElse(null);

        if (existingPeripheral != null)
            throw new IllegalArgumentException(String.format(EXISTING_PERIPHERAL,
                    peripheralType, this.getClass().getSimpleName(), this.getId()));

        this.peripherals.add(peripheral);
    }

    @Override
    public Peripheral removePeripheral(String peripheralType) {

        Peripheral peripheral = this.peripherals.stream()
                .filter(current ->  current.getClass().getSimpleName().equals(peripheralType))
                .findFirst()
                .orElse(null);

        if (this.peripherals.remove(peripheral))
            return peripheral;

        throw new IllegalArgumentException(String.format(NOT_EXISTING_PERIPHERAL,
                peripheralType, this.getClass().getSimpleName(), this.getId()));
    }

    private double getComponentAverageOverallPerformance (){
        return this.components.stream()
                .mapToDouble(Product::getOverallPerformance)
                .average()
                .orElse(0d);
    }

}
